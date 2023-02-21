package com.example.dict.common;

import android.app.Application;

import org.xutils.x;

/**
 * @PackageName: com.example.dict.common
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
    }
}
