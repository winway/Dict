package com.example.dict;

import com.example.dict.bean.PinyinAndBushouWordBean;
import com.example.dict.common.BaseSearchActivity;
import com.example.dict.common.URLHelper;

import java.util.List;

import com.example.dict.db.DBManager;

public class BushouSearchActivity extends BaseSearchActivity {

    @Override
    protected String getPinyinOrBushouQueryUrl(String selectedPinyinOrBushou, int currentPage, int pageSize) {
        return URLHelper.getBushouQueryUrl(selectedPinyinOrBushou, currentPage, pageSize);
    }

    @Override
    protected String getTitleName() {
        return "部首查询";
    }

    @Override
    protected String getType() {
        return "bushou";
    }

    @Override
    protected String getAssetFilename() {
        return "bushou.json";
    }

    @Override
    protected List<PinyinAndBushouWordBean.ResultBean.ListBean> queryWordFromDB(String pinyinOrBushou, int currentPage, int pageSize) {
        return DBManager.queryWordByBushou(pinyinOrBushou, currentPage, pageSize);
    }
}