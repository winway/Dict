package com.hui.dict.common;

import android.app.Application;

import org.xutils.x;

import com.hui.dict.db.DBManager;

/**
 * @PackageName: com.hui.dict.common
 * @ClassName: MyApplication
 * @Author: winwa
 * @Date: 2023/2/19 17:06
 * @Description:
 **/
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        DBManager.initDB(this);
    }
}
