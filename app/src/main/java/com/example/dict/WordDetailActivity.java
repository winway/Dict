package com.example.dict;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dict.bean.WordBean;
import com.example.dict.common.BaseActivity;
import com.example.dict.common.URLHelper;
import com.example.dict.db.DBManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class WordDetailActivity extends BaseActivity {

    private static final String TAG = "WordDetailActivity";
    private static final String ARG_WORD = "word";

    private ImageView mCollectIV;
    private TextView mWordTV;
    private TextView mPinyinTV;
    private TextView mBushouTV;
    private TextView mBihuaTV;
    private TextView mWubiTV;
    private TextView mExtBasicTV;
    private TextView mExtDetailTV;
    private ListView mExtendLV;

    private String mWord;
    private List<String> mExtBasicContent;
    private List<String> mExtDetailContent;

    private ArrayAdapter<String> mListAdapter;
    private List<String> mListAdapterData;

    public static Intent newIntent(Context context, String word) {
        Intent intent = new Intent(context, WordDetailActivity.class);
        intent.putExtra(ARG_WORD, word);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);

        Intent intent = getIntent();
        mWord = intent.getStringExtra(ARG_WORD);

        initView();

        initListAdapter();

        String url = URLHelper.getWordQueryUrl(mWord);
        Log.i(TAG, "onCreate: " + url);
        requestData(url);
    }

    private void initListAdapter() {
        mListAdapterData = new ArrayList<>();
        mListAdapter = new ArrayAdapter<>(this, R.layout.lvitem_word_detail_extend, R.id.lvitem_word_detail_extend_tv, mListAdapterData);
        mExtendLV.setAdapter(mListAdapter);
    }

    private void initView() {
        mCollectIV = findViewById(R.id.word_detail_collect_iv);
        mWordTV = findViewById(R.id.word_detail_word_tv);
        mPinyinTV = findViewById(R.id.word_detail_pinyin_tv);
        mBushouTV = findViewById(R.id.word_detail_bushou_tv);
        mBihuaTV = findViewById(R.id.word_detail_bihua_tv);
        mWubiTV = findViewById(R.id.word_detail_wubi_tv);
        mExtBasicTV = findViewById(R.id.word_detail_extend_basic_tv);
        mExtDetailTV = findViewById(R.id.word_detail_extend_detail_tv);
        mExtendLV = findViewById(R.id.word_detail_extend_lv);
    }

    @Override
    public void onSuccess(String result) {
        WordBean wordBean = new Gson().fromJson(result, WordBean.class);
        WordBean.ResultBean resultBean = wordBean.getResult();

        DBManager.insertWordDetail(resultBean);

        refreshView(resultBean);
    }

    private void refreshView(WordBean.ResultBean resultBean) {
        mWordTV.setText(resultBean.getZi());
        mPinyinTV.setText(resultBean.getPinyin());
        mBushouTV.setText("部首：" + resultBean.getBushou());
        mBihuaTV.setText("笔画：" + resultBean.getBihua());
        mWubiTV.setText("五笔：" + resultBean.getWubi());

        mExtBasicContent = resultBean.getJijie();
        mExtDetailContent = resultBean.getXiangjie();

        showExtBasic();
    }

    private void showExtBasic() {
        mExtBasicTV.setTextColor(Color.RED);
        mExtDetailTV.setTextColor(Color.BLACK);

        mListAdapterData.clear();
        mListAdapterData.addAll(mExtBasicContent);
        mListAdapter.notifyDataSetChanged();
    }

    private void showExtDetail() {
        mExtBasicTV.setTextColor(Color.BLACK);
        mExtDetailTV.setTextColor(Color.RED);

        mListAdapterData.clear();
        mListAdapterData.addAll(mExtDetailContent);
        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        super.onError(ex, isOnCallback);

        WordBean.ResultBean resultBean = DBManager.queryWordDetail(mWord);
        if (resultBean != null) {
            refreshView(resultBean);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.word_detail_back_iv:
                finish();
                break;
            case R.id.word_detail_collect_iv:
                break;
            case R.id.word_detail_extend_basic_tv:
                showExtBasic();
                break;
            case R.id.word_detail_extend_detail_tv:
                showExtDetail();
                break;
        }
    }
}