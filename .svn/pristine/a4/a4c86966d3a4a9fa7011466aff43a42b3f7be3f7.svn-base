package com.yanyin.maoyan.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 颜银 on 2016/12/6.
 * QQ:443098360
 * 微信：y443098360
 * 作用：用于处理拦截事件的问题
 */

public class MyRecycleView extends RecyclerView {
    public MyRecycleView(Context context) {
        this(context,null);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);



    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }


//    @Override
//    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        getParent().requestDisallowInterceptTouchEvent(true);
//        super.requestDisallowInterceptTouchEvent(disallowIntercept);
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//
//        switch (e.getAction()) {
//            case MotionEvent.ACTION_MOVE :
//                return true;
//
//        }
//
//        return super.onTouchEvent(e);
//
//    }

}
