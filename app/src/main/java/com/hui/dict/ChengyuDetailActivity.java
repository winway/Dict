package com.hui.dict;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hui.dict.bean.ChengyuBean;
import com.hui.dict.common.BaseActivity;
import com.hui.dict.common.NoScrollGridView;
import com.hui.dict.common.URLHelper;
import com.hui.dict.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class ChengyuDetailActivity extends BaseActivity {
    private static final String TAG = "ChengyuDetailActivity";
    private static final String KEY_CHENGYU = "cheng_yu";

    private ImageView mCollectIV;
    private TextView mWord1TV;
    private TextView mWord2TV;
    private TextView mWord3TV;
    private TextView mWord4TV;
    private TextView mPinyinTV;
    private TextView mExplainTV;
    private TextView mChuchuTV;
    private TextView mLijuTV;
    private TextView mYufaTV;
    private TextView mYinzhengTV;
    private TextView mHuyiTV;
    private NoScrollGridView mTongyiGV;
    private NoScrollGridView mFanyiGV;

    private String mChengyu;

    private ArrayAdapter<String> mTongyiGridAdapter;
    private ArrayAdapter<String> mFanyiGridAdapter;
    private List<String> mTongyiGridAdapterData;
    private List<String> mFanyiGridAdapterData;

    private boolean isCollected;
    private boolean needCollect;

    public static Intent newIntent(Context context, String chengyu) {
        Intent intent = new Intent(context, ChengyuDetailActivity.class);
        intent.putExtra(KEY_CHENGYU, chengyu);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengyu_detail);

        mChengyu = getIntent().getStringExtra(KEY_CHENGYU);

        isCollected = DBManager.isChengyuCollected(mChengyu);
        needCollect = isCollected;

        initView();

        String url = URLHelper.getChengyuQueryUrl(mChengyu);
        Log.i(TAG, "onCreate: " + url);
        requestData(url);

        initGridAdapter();
    }

    private void initGridAdapter() {
        mTongyiGridAdapterData = new ArrayList<>();
        mFanyiGridAdapterData = new ArrayList<>();
        mTongyiGridAdapter = new ArrayAdapter<>(this, R.layout.gvitem_chengyu, R.id.gvitem_chengyu_tv, mTongyiGridAdapterData);
        mFanyiGridAdapter = new ArrayAdapter<>(this, R.layout.gvitem_chengyu, R.id.gvitem_chengyu_tv, mFanyiGridAdapterData);
        mTongyiGV.setAdapter(mTongyiGridAdapter);
        mFanyiGV.setAdapter(mFanyiGridAdapter);
    }

    private void initView() {
        mCollectIV = findViewById(R.id.chengyu_detail_collect_iv);
        mWord1TV = findViewById(R.id.chengyu_detail_word1_tv);
        mWord2TV = findViewById(R.id.chengyu_detail_word2_tv);
        mWord3TV = findViewById(R.id.chengyu_detail_word3_tv);
        mWord4TV = findViewById(R.id.chengyu_detail_word4_tv);
        mPinyinTV = findViewById(R.id.chengyu_detail_pinyin_tv);
        mExplainTV = findViewById(R.id.chengyu_detail_explain_tv);
        mChuchuTV = findViewById(R.id.chengyu_detail_chuchu_content_tv);
        mLijuTV = findViewById(R.id.chengyu_detail_liju_content_tv);
        mYufaTV = findViewById(R.id.chengyu_detail_yufa_content_tv);
        mYinzhengTV = findViewById(R.id.chengyu_detail_yinzheng_content_tv);
        mHuyiTV = findViewById(R.id.chengyu_detail_huyi_content_tv);
        mTongyiGV = findViewById(R.id.chengyu_detail_tongyi_gv);
        mFanyiGV = findViewById(R.id.chengyu_detail_fanyi_gv);

        setupCollectStyle();
    }

    private void setupCollectStyle() {
        if (needCollect) {
            mCollectIV.setImageResource(R.mipmap.ic_collection_fs);
        } else {
            mCollectIV.setImageResource(R.mipmap.ic_collection);
        }
    }

    @Override
    public void onSuccess(String result) {
        ChengyuBean chengyuBean = new Gson().fromJson(result, ChengyuBean.class);
        ChengyuBean.ResultBean resultBean = chengyuBean.getResult();

        if (resultBean == null) {
            Toast.makeText(this, "成语无法找到", Toast.LENGTH_SHORT).show();
            return;
        }

        saveChengyu2DB(resultBean);

        refreshView(resultBean);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        super.onError(ex, isOnCallback);
        ChengyuBean.ResultBean resultBean = DBManager.queryChengyuDetail(mChengyu);
        if (resultBean != null) {
            refreshView(resultBean);
        }
    }

    private void refreshView(ChengyuBean.ResultBean resultBean) {
        String chengyu = resultBean.getName();
        mWord1TV.setText(String.valueOf(chengyu.charAt(0)));
        mWord2TV.setText(String.valueOf(chengyu.charAt(1)));
        mWord3TV.setText(String.valueOf(chengyu.charAt(2)));
        mWord4TV.setText(String.valueOf(chengyu.charAt(3)));

        mPinyinTV.setText("拼音：" + resultBean.getPinyin());
        try {
            mExplainTV.setText(resultBean.getXxsy().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mChuchuTV.setText(resultBean.getChuchu());
        try {
            mLijuTV.setText(resultBean.getXxsy().get(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mYufaTV.setText(resultBean.getXxsy().get(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mYinzhengTV.setText(resultBean.getXxsy().get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mHuyiTV.setText("");

        List<String> tongyiList = resultBean.getJyc();
        if (tongyiList != null && tongyiList.size() > 0) {
            mTongyiGridAdapterData.addAll(tongyiList);
            mTongyiGridAdapter.notifyDataSetChanged();
        }

        List<String> fanyiList = resultBean.getFyc();
        if (fanyiList != null && fanyiList.size() > 0) {
            mFanyiGridAdapterData.addAll(fanyiList);
            mFanyiGridAdapter.notifyDataSetChanged();
        }
    }

    private void saveChengyu2DB(ChengyuBean.ResultBean resultBean) {
        DBManager.insertChengyu(resultBean);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chengyu_detail_back_iv:
                finish();
                break;
            case R.id.chengyu_detail_collect_iv:
                needCollect = !needCollect;
                setupCollectStyle();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isCollected && !needCollect) {
            DBManager.deleteCollectChengyu(mChengyu);
        } else if (!isCollected && needCollect) {
            DBManager.insertCollectChengyu(mChengyu);
        }
    }
}