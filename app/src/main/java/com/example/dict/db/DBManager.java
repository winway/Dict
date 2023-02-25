package com.example.dict.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.dict.bean.PinyinAndBushouWordBean;
import com.example.dict.bean.WordBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName: db
 * @ClassName: DBManager
 * @Author: winwa
 * @Date: 2023/2/22 8:21
 * @Description:
 **/
public class DBManager {
    private static final String TAG = "DBManager";

    private static SQLiteDatabase sDatabase;

    public static void initDB(Context context) {
        DBOpenHelper helper = new DBOpenHelper(context);
        sDatabase = helper.getWritableDatabase();
    }

    public static void insertWordOne(PinyinAndBushouWordBean.ResultBean.ListBean bean) {
        ContentValues values = new ContentValues();
        values.put("id", bean.getId());
        values.put("zi", bean.getZi());
        values.put("py", bean.getPy());
        values.put("wubi", bean.getWubi());
        values.put("pinyin", bean.getPinyin());
        values.put("bushou", bean.getBushou());
        values.put("bihua", bean.getBihua());

        sDatabase.insert("word", null, values);
    }

    public static void insertWordMany(List<PinyinAndBushouWordBean.ResultBean.ListBean> beanList) {
        for (int i = 0; i < beanList.size(); i++) {
            PinyinAndBushouWordBean.ResultBean.ListBean bean = beanList.get(i);
            try {
                insertWordOne(bean);
            } catch (Exception e) {
                Log.i(TAG, "insertWordMany: " + bean.getZi());
                e.printStackTrace();
            }
        }
    }

    public static List<PinyinAndBushouWordBean.ResultBean.ListBean> queryWordByPinyin(String py, int page, int pageSize) {
        List<PinyinAndBushouWordBean.ResultBean.ListBean> beanList = new ArrayList<>();

        int start = (page - 1) * pageSize;
        int end = page * pageSize;

        Log.i(TAG, "queryWordByPinyin: " + py + " " + start + " " + end);

        String querySql = "select * from word where py=? or py like ? or py like ? or py like ? limit ?,?";

        Cursor cursor = sDatabase.rawQuery(querySql, new String[]{py, py + ",%", ",%" + py + ",%", ",%" + py, start + "", end + ""});
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String zi = cursor.getString(cursor.getColumnIndex("zi"));
            String wubi = cursor.getString(cursor.getColumnIndex("wubi"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String bushou = cursor.getString(cursor.getColumnIndex("bushou"));
            String bihua = cursor.getString(cursor.getColumnIndex("bihua"));

            PinyinAndBushouWordBean.ResultBean.ListBean bean = new PinyinAndBushouWordBean.ResultBean.ListBean(id, zi, py, wubi, pinyin, bushou, bihua);
            beanList.add(bean);
        }

        Log.i(TAG, "queryWordByPinyin: " + beanList.size());

        return beanList;
    }

    public static List<PinyinAndBushouWordBean.ResultBean.ListBean> queryWordByBushou(String bushou, int page, int pageSize) {
        List<PinyinAndBushouWordBean.ResultBean.ListBean> beanList = new ArrayList<>();

        int start = (page - 1) * pageSize;
        int end = page * pageSize;

        Log.i(TAG, "queryWordByBushou: " + bushou + " " + start + " " + end);

        String querySql = "select * from word where bushou=? limit ?,?";

        Cursor cursor = sDatabase.rawQuery(querySql, new String[]{bushou, start + "", end + ""});
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String zi = cursor.getString(cursor.getColumnIndex("zi"));
            String py = cursor.getString(cursor.getColumnIndex("py"));
            String wubi = cursor.getString(cursor.getColumnIndex("wubi"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String bihua = cursor.getString(cursor.getColumnIndex("bihua"));

            PinyinAndBushouWordBean.ResultBean.ListBean bean = new PinyinAndBushouWordBean.ResultBean.ListBean(id, zi, py, wubi, pinyin, bushou, bihua);
            beanList.add(bean);
        }

        Log.i(TAG, "queryWordByBushou: " + beanList.size());

        return beanList;
    }

    public static void insertWordDetail(WordBean.ResultBean bean) {
        ContentValues values = new ContentValues();
        values.put("id", bean.getId());
        values.put("zi", bean.getZi());
        values.put("py", bean.getPy());
        values.put("wubi", bean.getWubi());
        values.put("pinyin", bean.getPinyin());
        values.put("bushou", bean.getBushou());
        values.put("bihua", bean.getBihua());
        values.put("jijie", String.join("|", bean.getJijie()));
        values.put("xiangjie", String.join("|", bean.getXiangjie()));

        sDatabase.insert("word_detail", null, values);
    }

    public static WordBean.ResultBean queryWordDetail(String word) {

        String querySql = "select * from word_detail where zi=?";

        Cursor cursor = sDatabase.rawQuery(querySql, new String[]{word});
        if (cursor.moveToFirst()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String zi = cursor.getString(cursor.getColumnIndex("zi"));
            String py = cursor.getString(cursor.getColumnIndex("py"));
            String wubi = cursor.getString(cursor.getColumnIndex("wubi"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String bushou = cursor.getString(cursor.getColumnIndex("bushou"));
            String bihua = cursor.getString(cursor.getColumnIndex("bihua"));
            String jijie = cursor.getString(cursor.getColumnIndex("jijie"));
            String xiangjie = cursor.getString(cursor.getColumnIndex("xiangjie"));

            List<String> jijieList = new ArrayList<String>(Arrays.asList(jijie.split("\\|")));
            List<String> xiangjieList = new ArrayList<String>(Arrays.asList(xiangjie.split("\\|")));

            return new WordBean.ResultBean(id, zi, py, wubi, pinyin, bushou, bihua, jijieList, xiangjieList);
        }

        return null;
    }
}
