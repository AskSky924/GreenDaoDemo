package com.asksky.greendaotest.util;

import android.content.Context;

import com.asksky.greendaotest.entity.DaoMaster;
import com.asksky.greendaotest.entity.DaoSession;

/**
 * Created by AskSky on 2016/11/22.
 * 数据库辅助类
 */

public class DBHelper {
    private static final String TAG = DBHelper.class.getSimpleName();
    private static DBHelper mInstance;
    private DaoMaster.DevOpenHelper mOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private String password = "AskSky_TanPeiQi_1195211669_JMSQJ";
    private static final String DBName = "TrafficManager";

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (mInstance == null) {
            mInstance = new DBHelper();
        }
        return mInstance;
    }

    public void init(Context context) {
        mOpenHelper = new DaoMaster.DevOpenHelper(context, DBName, null);
        mDaoMaster = new DaoMaster(mOpenHelper.getEncryptedWritableDb(Utils.getMd5(password)));
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

}
