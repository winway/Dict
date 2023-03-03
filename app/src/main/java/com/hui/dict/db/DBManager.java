package com.hui.dict.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hui.dict.bean.ChengyuBean;
import com.hui.dict.bean.PinyinAndBushouWordBean;
import com.hui.dict.bean.WordBean;

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

    public static void insertChengyu(ChengyuBean.ResultBean bean) {
        ContentValues values = new ContentValues();
        values.put("chengyu", bean.getName());
        values.put("pinyin", bean.getPinyin());
        values.put("chuchu", bean.getChuchu());
        values.put("xxjs", String.join("|", bean.getXxsy()));
        values.put("tongyi", String.join("|", bean.getJyc()));
        values.put("fanyi", String.join("|", bean.getFyc()));

        sDatabase.insert("chengyu", null, values);
    }

    public static ChengyuBean.ResultBean queryChengyuDetail(String chengyu) {

        Log.e(TAG, "queryChengyu: " + chengyu);

        String querySql = "select * from chengyu where chengyu=?";

        Cursor cursor = sDatabase.rawQuery(querySql, new String[]{chengyu});
        if (cursor.moveToFirst()) {
            String pingyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            String chuchu = cursor.getString(cursor.getColumnIndex("chuchu"));
            String xxjs = cursor.getString(cursor.getColumnIndex("xxjs"));
            String tongyi = cursor.getString(cursor.getColumnIndex("tongyi"));
            String fanyi = cursor.getString(cursor.getColumnIndex("fanyi"));

            List<String> xxjsList = new ArrayList<String>(Arrays.asList(xxjs.split("\\|")));
            List<String> tongyiList = new ArrayList<String>(Arrays.asList(tongyi.split("\\|")));
            List<String> fanyiList = new ArrayList<String>(Arrays.asList(fanyi.split("\\|")));

            return new ChengyuBean.ResultBean(chengyu, pingyin, chuchu, xxjsList, tongyiList, fanyiList);
        }

        return null;
    }

    public static List<String> queryChengyuList() {
        List<String> chengyuList = new ArrayList<>();

        String querySql = "select chengyu from chengyu";

        Cursor cursor = sDatabase.rawQuery(querySql, null);
        while (cursor.moveToNext()) {
            String chengyu = cursor.getString(cursor.getColumnIndex("chengyu"));
            chengyuList.add(chengyu);
        }

        return chengyuList;
    }

    public static void insertCollectWord(String word) {
        ContentValues values = new ContentValues();
        values.put("word", word);

        sDatabase.insert("collect_word", null, values);
    }

    public static void deleteCollectWord(String word) {
        String sql = "delete from collect_word where word=?";
        sDatabase.execSQL(sql, new String[]{word});
    }

    public static boolean isWordCollected(String word) {
        String sql = "select * from collect_word where word=?";
        Cursor cursor = sDatabase.rawQuery(sql, new String[]{word});
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    public static void insertCollectChengyu(String chengyu) {
        ContentValues values = new ContentValues();
        values.put("chengyu", chengyu);

        sDatabase.insert("collect_chengyu", null, values);
    }

    public static void deleteCollectChengyu(String chengyu) {
        String sql = "delete from collect_chengyu where chengyu=?";
        sDatabase.execSQL(sql, new String[]{chengyu});
    }

    public static boolean isChengyuCollected(String chengyu) {
        String sql = "select * from collect_chengyu where chengyu=?";
        Cursor cursor = sDatabase.rawQuery(sql, new String[]{chengyu});
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }
}
