package com.yanyin.maoyan.me.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.loopj.android.http.RequestParams;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.activity.LoginActivity;
import com.yanyin.maoyan.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：我的
 */
public class MeFragment extends BaseFragment {

    @Bind(R.id.ll_me_login)
    LinearLayout llMeLogin;

    @Override
    protected RequestParams getParams() {
        return null;
    }

    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    protected void initData(String content) {


        initListener();
    }

    private void initListener() {

        llMeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });


    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }
}
