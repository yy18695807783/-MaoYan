package com.yanyin.maoyan.utils;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.yanyin.maoyan.activity.MyApplication;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class UIUtils {

    //获得全局的Context
    public static Context getContext() {
        return MyApplication.mContext;
    }

    //获得全局线程
    public static Handler getHandler() {
        return MyApplication.mHandler;
    }

    //通过资源id获得字符串数组
    public static String[] getStringArr(int arrID) {
        String[] stringArray = getContext().getResources().getStringArray(arrID);
        return stringArray;
    }

    //通过视图id获得加载视图
    public static View getView(int viewId) {
        View view = View.inflate(getContext(), viewId, null);
        return view;
    }

    //保证如下的操作在主线程中执行的
    public static void runonUiThread(Runnable runnable){
        if(isMainThread()){
            runnable.run();//是主线程，就直接运行run方法
        }else {
            UIUtils.getHandler().post(runnable);//不是主线程，就发消息到主线程执行
        }
    }


    //判断当前的线程是否是主线程
    private static boolean isMainThread() {
        int currentThreadId = android.os.Process.myTid();
        return MyApplication.mainThreadId == currentThreadId;
    }

    //屏幕相关
    public static int dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);//四舍五入  获得px
    }

    public static int px2dp(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);//四舍五入  获得dp
    }



}
