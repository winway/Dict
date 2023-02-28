package com.hui.dict.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @PackageName: db
 * @ClassName: DBOpenHelper
 * @Author: winwa
 * @Date: 2023/2/22 8:16
 * @Description:
 **/
public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context) {
        super(context, "dict.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createSql = "create table word(_id integer primary key autoincrement, " +
                "id varchar(20), " +
                "zi varchar(4) unique not null, " +
                "py varchar(10), " +
                "wubi varchar(10), " +
                "pinyin varchar(10), " +
                "bushou varchar(4), " +
                "bihua integer)";
        sqLiteDatabase.execSQL(createSql);

        createSql = "create table word_detail(_id integer primary key autoincrement, " +
                "id varchar(20), " +
                "zi varchar(4) unique not null, " +
                "py varchar(10), " +
                "wubi varchar(10), " +
                "pinyin varchar(10), " +
                "bushou varchar(4), " +
                "bihua integer, " +
                "jijie text, " +
                "xiangjie text)";
        sqLiteDatabase.execSQL(createSql);

        createSql = "create table chengyu(_id integer primary key autoincrement, " +
                "chengyu varchar(10) unique not null, " +
                "pinyin varchar(4), " +
                "chuchu text, " +
                "xxjs text, " +
                "tongyi text, " +
                "fanyi text)";
        sqLiteDatabase.execSQL(createSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
