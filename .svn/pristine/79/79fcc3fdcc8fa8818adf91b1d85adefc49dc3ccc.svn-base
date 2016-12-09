package com.yanyin.maoyan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.me.fragment.login.AccountFragment;
import com.yanyin.maoyan.me.fragment.login.PhoneFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends FragmentActivity {

    @Bind(R.id.login_zhuce)
    TextView loginZhuce;
    @Bind(R.id.viewpager_login)
    ViewPager viewpagerLogin;
    @Bind(R.id.slidingTabLayout)
    SlidingTabLayout slidingTabLayout;

    private List<Fragment> fragmentLists;
    private final String[] mTitles = {
            "帐号密码登陆", "手机号快捷登录"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initLoginFragment();

        initData();

        initListener();
    }

    private void initLoginFragment() {
        fragmentLists = new ArrayList<>();
        AccountFragment accountFragment = new AccountFragment();
        PhoneFragment phoneFragment = new PhoneFragment();

        fragmentLists.add(accountFragment);
        fragmentLists.add(phoneFragment);

    }

    private void initData() {

        //ViewPager适配器
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());

        viewpagerLogin.setAdapter(adapter);

        slidingTabLayout.setViewPager(viewpagerLogin);
        viewpagerLogin.setCurrentItem(0);

    }


    private void initListener() {

        //注册
        loginZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "注册", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * FragmentStatePagerAdapter  在Fragment比较多的情况下采用，内部封装了系统销毁回收长时间不用的fragment界面，防止内存溢出
     * FragmentPagerAdapter   如果viewPager中加载显示的Fragment较少情况。系统不会做回收操作
     */
    class MyFragmentAdapter extends FragmentPagerAdapter {


        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentLists.get(position);
        }

        @Override
        public int getCount() {
            return fragmentLists.size();
        }
    }


}
