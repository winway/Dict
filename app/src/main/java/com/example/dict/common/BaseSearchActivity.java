package com.example.dict.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.dict.R;
import com.example.dict.WordDetailActivity;
import com.example.dict.adapter.NaviListAdapter;
import com.example.dict.adapter.WordGridAdapter;
import com.example.dict.bean.PinyinAndBushouMappingBean;
import com.example.dict.bean.PinyinAndBushouWordBean;
import com.example.dict.db.DBManager;
import com.example.dict.utils.AssetsUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSearchActivity extends BaseActivity {

    private static final String TAG = "PinyinSearchActivity";

    private TextView mTitleTV;
    private ExpandableListView mNaviELV;
    private PullToRefreshGridView mWordPRGV;

    private NaviListAdapter mNaviListAdapter;
    private List<String> mParentListAdapterData;
    private List<List<PinyinAndBushouMappingBean.ResultBean>> mChildListAdapterData;

    private WordGridAdapter mWordGridAdapter;
    private List<PinyinAndBushouWordBean.ResultBean.ListBean> mWordGridAdapterData;

    private int mSelectedGroupPos = 0;
    private int mSelectedChildPos = 0;

    private int mTotalPage;
    private int mCurrentPage = 1;
    private int mPageSize = 48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_search);

        mTitleTV = findViewById(R.id.base_search_title_tv);
        mNaviELV = findViewById(R.id.base_search_navigate_elv);
        mWordPRGV = findViewById(R.id.base_search_word_prgv);

        mTitleTV.setText(getTitleName());

        initNaviListAdapterData(getAssetFilename(), getType());

        initNaviListAdapter();
        setupNaviListAdapter();

        initWordGridAdapter();
        setupWordGridAdapter();

        String url = getPinyinOrBushouQueryUrl(getSelectedPinyinOrBushou(), mCurrentPage, mPageSize);
        Log.i(TAG, "onCreate: " + url);
        requestData(url);
    }

    protected String getSelectedPinyinOrBushou() {
        if (getType().equals("pinyin")) {
            return mChildListAdapterData.get(mSelectedGroupPos).get(mSelectedChildPos).getPinyin();
        } else {
            return mChildListAdapterData.get(mSelectedGroupPos).get(mSelectedChildPos).getBushou();
        }
    }

    protected abstract String getPinyinOrBushouQueryUrl(String selectedPinyinOrBushou, int currentPage, int pageSize);

    private void initWordGridAdapter() {
        mWordGridAdapterData = new ArrayList<>();

        mWordGridAdapter = new WordGridAdapter(this, mWordGridAdapterData);
        mWordPRGV.setAdapter(mWordGridAdapter);
    }

    private void setupWordGridAdapter() {
        mWordPRGV.setMode(PullToRefreshBase.Mode.PULL_FROM_END);

        mWordPRGV.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<GridView>() {
            @Override
            public void onRefresh(PullToRefreshBase<GridView> refreshView) {
                if (mCurrentPage < mTotalPage) {
                    mCurrentPage += 1;
                    String url = getPinyinOrBushouQueryUrl(getSelectedPinyinOrBushou(), mCurrentPage, mPageSize);
                    Log.i(TAG, "onRefresh: " + url);
                    requestData(url);
                } else {
                    mWordPRGV.onRefreshComplete();
                }
            }
        });

        mWordPRGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PinyinAndBushouWordBean.ResultBean.ListBean bean = mWordGridAdapterData.get(i);
                Intent intent = WordDetailActivity.newIntent(getBaseContext(), bean.getZi());
                startActivity(intent);
            }
        });
    }

    private void refreshWordGridAdapter(List<PinyinAndBushouWordBean.ResultBean.ListBean> listBean) {
        if (mCurrentPage == 1) {
            mWordGridAdapterData.clear();
            mWordGridAdapterData.addAll(listBean);
            mWordGridAdapter.notifyDataSetChanged();
        } else {
            mWordGridAdapterData.addAll(listBean);
            mWordGridAdapter.notifyDataSetChanged();
            mWordPRGV.onRefreshComplete();
        }
    }

    private void initNaviListAdapter() {
        mNaviListAdapter = new NaviListAdapter(this, getType(), mParentListAdapterData, mChildListAdapterData);
        mNaviELV.setAdapter(mNaviListAdapter);
    }

    private void setupNaviListAdapter() {
        mNaviListAdapter = new NaviListAdapter(this, getType(), mParentListAdapterData, mChildListAdapterData);
        mNaviELV.setAdapter(mNaviListAdapter);

        mNaviELV.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                mSelectedGroupPos = i;
                mSelectedChildPos = Math.min(mSelectedChildPos, mChildListAdapterData.get(mSelectedGroupPos).size() - 1);
                mNaviListAdapter.setSelectedGroupPos(i);
                mNaviListAdapter.setSelectedChildPos(mSelectedChildPos);
                mNaviListAdapter.notifyDataSetInvalidated();

                updateWord();

                return false;
            }
        });
        mNaviELV.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                mSelectedGroupPos = i;
                mSelectedChildPos = i1;
                mNaviListAdapter.setSelectedGroupPos(i);
                mNaviListAdapter.setSelectedChildPos(i1);
                mNaviListAdapter.notifyDataSetInvalidated();

                updateWord();

                return false;
            }
        });

        mNaviELV.expandGroup(0);
    }

    private void updateWord() {
        List<PinyinAndBushouMappingBean.ResultBean> resultBeanList = mChildListAdapterData.get(mSelectedGroupPos);
        PinyinAndBushouMappingBean.ResultBean resultBean = resultBeanList.get(mSelectedChildPos);

        mCurrentPage = 1;
        String url = getPinyinOrBushouQueryUrl(getSelectedPinyinOrBushou(), mCurrentPage, mPageSize);
        Log.i(TAG, "updateWord: " + url);
        requestData(url);
    }

    protected abstract String getTitleName();

    protected abstract String getType();

    protected abstract String getAssetFilename();

    private void initNaviListAdapterData(String filename, String type) {
        mParentListAdapterData = new ArrayList<>();
        mChildListAdapterData = new ArrayList<>();

        String content = AssetsUtils.readAssetFile(this, filename);
        if (!TextUtils.isEmpty(content)) {
            PinyinAndBushouMappingBean pinyinAndBushouMappingBean = new Gson().fromJson(content, PinyinAndBushouMappingBean.class);
            List<PinyinAndBushouMappingBean.ResultBean> pinyinAndBushouMappingResultBeanList = pinyinAndBushouMappingBean.getResult();

            List<PinyinAndBushouMappingBean.ResultBean> childList = new ArrayList<>();
            for (int i = 0; i < pinyinAndBushouMappingResultBeanList.size(); i++) {
                PinyinAndBushouMappingBean.ResultBean resultBean = pinyinAndBushouMappingResultBeanList.get(i);

                String parentItem = "";
                if (type.equals("pinyin")) {
                    parentItem = resultBean.getPinyin_key();
                } else if (type.equals("bushou")) {
                    parentItem = resultBean.getBihua();
                }

                if (!mParentListAdapterData.contains(parentItem)) {
                    mParentListAdapterData.add(parentItem);

                    if (mParentListAdapterData.size() > 1) {
                        mChildListAdapterData.add(childList);
                    }

                    childList = new ArrayList<>();
                    childList.add(resultBean);
                } else {
                    childList.add(resultBean);
                }
            }

            mChildListAdapterData.add(childList);
        }
    }

    @Override
    public void onSuccess(String result) {
        PinyinAndBushouWordBean pinyinAndBushouWordBean = new Gson().fromJson(result, PinyinAndBushouWordBean.class);
        if (pinyinAndBushouWordBean.getError_code() != 0) {
            Log.e(TAG, "onSuccess: " + pinyinAndBushouWordBean.getReason());
            return;
        }

        PinyinAndBushouWordBean.ResultBean resultBean = pinyinAndBushouWordBean.getResult();
        List<PinyinAndBushouWordBean.ResultBean.ListBean> listBean = resultBean.getList();

        mTotalPage = resultBean.getTotalpage();

        refreshWordGridAdapter(listBean);

        saveWord2DB(listBean);
    }

    private void saveWord2DB(List<PinyinAndBushouWordBean.ResultBean.ListBean> listBean) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBManager.insertWordMany(listBean);
                Log.i(TAG, "run: " + listBean.size());
            }
        }).start();
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        super.onError(ex, isOnCallback);

        List<PinyinAndBushouWordBean.ResultBean.ListBean> beanList = queryWordFromDB(getSelectedPinyinOrBushou(), mCurrentPage, mPageSize);

        refreshWordGridAdapter(beanList);
    }

    protected abstract List<PinyinAndBushouWordBean.ResultBean.ListBean> queryWordFromDB(String pinyinOrBushou, int currentPage, int pageSize);

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_search_back_iv:
                finish();
                break;
        }
    }
}