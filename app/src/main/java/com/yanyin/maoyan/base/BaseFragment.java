package com.yanyin.maoyan.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;
import com.yanyin.maoyan.ui.LoadingPager;

import butterknife.ButterKnife;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：Fragment的公共基类
 */

public abstract class BaseFragment extends Fragment {
    public static Context mContext;
    public LoadingPager loadingPager;
    public LayoutInflater mLayoutInflater;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    /**
     * 当fragment创建视图的时候调用
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        loadingPager = new LoadingPager(getActivity()) {
            @Override
            public int layoutId() {
                return getLayoutId();
            }

            @Override
            protected void onSuccess(ResultState resultState, View successView) {//
                ButterKnife.bind(BaseFragment.this, successView);//绑定布局
                //初始化标题
                initTitle();

                //初始化数据
                initData(resultState.getContent());
            }

            @Override
            protected RequestParams params() {
                return getParams();
            }

            @Override
            protected String url() {
                return getUrl();
            }
        };

        loadingPager.error_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击刷新", Toast.LENGTH_SHORT).show();
               show();
            }
        });


        return loadingPager;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //实现联网操作的方法
        show();
    }

    /**
     * 实现联网操作的方法
     */
    private void show() {
        //还有不需要联网的界面，写在这里不合适
//        UIUtils.getHandler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                loadingPager.show();
//            }
//        },2000);

        loadingPager.show();
    }


    /**
     * 加载布局是否充满
     */
    protected abstract RequestParams getParams();

    /**
     * 获得联网路径
     * @return
     */
    protected abstract String getUrl();

    /**
     * 初始化数据的方法
     * @param content
     *
     */
    protected abstract void initData(String content);

    /**
     * 初始化标题的方法
     *
     */
    protected abstract void initTitle();

    /**
     * 得到添加布局资源id的方法
     * @return
     */
    protected abstract int getLayoutId();





//    /**
//     * 初始化数据
//     * 初始化监听
//     *
//     * @param savedInstanceState
//     */
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        initData();
//        initListener();
//    }
//
//
//    //加载布局文件
//    protected abstract View initView();
//
//    //初始化数据方法
//    protected abstract void initData();
//
//    //初始化监听方法
//    protected abstract void initListener();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

