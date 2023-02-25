package com.example.dict;

import com.example.dict.bean.PinyinAndBushouWordBean;
import com.example.dict.common.BaseSearchActivity;
import com.example.dict.common.URLHelper;

import java.util.List;

import com.example.dict.db.DBManager;

public class PinyinSearchActivity extends BaseSearchActivity {

    @Override
    protected String getPinyinOrBushouQueryUrl(String selectedPinyinOrBushou, int currentPage, int pageSize) {
        return URLHelper.getPinyinQueryUrl(selectedPinyinOrBushou, currentPage, pageSize);
    }

    @Override
    protected String getTitleName() {
        return "拼音查询";
    }

    @Override
    protected String getType() {
        return "pinyin";
    }

    @Override
    protected String getAssetFilename() {
        return "pinyin.json";
    }

    @Override
    protected List<PinyinAndBushouWordBean.ResultBean.ListBean> queryWordFromDB(String pinyinOrBushou, int currentPage, int pageSize) {
        return DBManager.queryWordByPinyin(pinyinOrBushou, currentPage, pageSize);
    }
}