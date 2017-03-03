package com.asksky.greendaotest;

import android.app.Application;

import com.asksky.greendaotest.util.DBHelper;

/**
 * Created by asksky on 2017/3/3.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBHelper.getInstance().init(getApplicationContext());
    }
}
