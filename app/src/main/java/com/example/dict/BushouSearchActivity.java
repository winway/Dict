package com.example.dict;

import com.example.dict.common.BaseSearchActivity;
import com.example.dict.common.URLHelper;

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
}