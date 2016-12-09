package com.yanyin.maoyan.activity;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：应用APP
 */

public class MyApplication extends Application {

    public static Context mContext;
    public static Handler mHandler;
    public static int mainThreadId;


    @Override
    public void onCreate() {
        super.onCreate();

        mHandler = new Handler();
        mContext = this;
        mainThreadId = android.os.Process.myTid();//得到当前主线程id

//        SMSSDK.initSDK(this, "19c65b51c428e", "677f08b2e6921ee906a52e7975953b1f");
    }
}
