package com.yanyin.maoyan.move.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.loopj.android.http.RequestParams;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.activity.MeituanSelectCityActivity;
import com.yanyin.maoyan.activity.MoveSearchActivity;
import com.yanyin.maoyan.base.BaseFragment;
import com.yanyin.maoyan.move.bean.FirstEvent;
import com.yanyin.maoyan.move.fragment.viewpager.FindmovesFragment;
import com.yanyin.maoyan.move.fragment.viewpager.HotFragment;
import com.yanyin.maoyan.move.fragment.viewpager.WaiteFragment;
import com.yanyin.maoyan.utils.LogUtil;
import com.yanyin.maoyan.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：电影
 */
public class MoveFragment extends BaseFragment {


    @Bind(R.id.title_city)
    TextView titleCity;
    @Bind(R.id.stl_indicator)
    SlidingTabLayout stlIndicator;
    @Bind(R.id.viewpager_move)
    ViewPager viewpagerMove;
    @Bind(R.id.ll_city_show)
    LinearLayout llCityShow;

    @Bind(R.id.top_search)
    ImageView topSearch;


    //电影界面的pager集合
    private List<Fragment> fragmentLists;

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

        //1 注册
        EventBus.getDefault().register(this);

        //隐藏显示城市选择的头部title
        llCityShow.setVisibility(View.GONE);

        initFragment();

        //viewPager适配器
        MoveFragmentAdapter adapter = new MoveFragmentAdapter(getFragmentManager());
        viewpagerMove.setAdapter(adapter);


        stlIndicator.setViewPager(viewpagerMove);
        viewpagerMove.setCurrentItem(0);

    }


    @Override
    protected void initTitle() {

        initListener();
    }

    //点击监听
    private void initListener() {

        //动画搜索放大镜的点击监听
        topSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MoveSearchActivity.class));
            }
        });


        //定位城市点击
        titleCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MeituanSelectCityActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        LogUtil.e("222222222222222222222222222");
        if (requestCode == 1 && resultCode == 2) {
            titleCity.setText(data.getStringExtra("city"));
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_move;
    }

//
//    protected void initData() {
//        initFragment();
//
//        //viewPager适配器
//        MoveFragmentAdapter adapter = new MoveFragmentAdapter(getFragmentManager());
//        viewpagerMove.setAdapter(adapter);
//
//        tabIndicator.setViewPager(viewpagerMove);
//
//
////        //关联TabPagerIndicator 和 ViewPager
////        tabLayout.setupWithViewPager(viewpagerMove);
////        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//次样式只有一般在左边
////        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//    }

    /**
     * 初始化fragment的集合
     */
    private void initFragment() {
        fragmentLists = new ArrayList<>();

        HotFragment hotFragment = new HotFragment();
        WaiteFragment waiteFragment = new WaiteFragment();
        FindmovesFragment findmovesFragment = new FindmovesFragment();

        fragmentLists.add(hotFragment);
        fragmentLists.add(waiteFragment);
        fragmentLists.add(findmovesFragment);
    }


    /**
     * FragmentStatePagerAdapter  在Fragment比较多的情况下采用，内部封装了系统销毁回收长时间不用的fragment界面，防止内存溢出
     * FragmentPagerAdapter   如果viewPager中加载显示的Fragment较少情况。系统不会做回收操作
     */
    class MoveFragmentAdapter extends FragmentPagerAdapter {

        //提供TabPagerIndicator显示的文本
        @Override
        public CharSequence getPageTitle(int position) {
            //方式一
//            if(position == 0){
//                return "全部理财";
//            }else if(position == 1){
//                return "推荐理财";
//            }else if(position == 2){
//                return "热门理财";
//            }
            //方式二
            return UIUtils.getStringArr(R.array.invest_tab)[position];
        }

        public MoveFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
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


    /**
     * 订阅
     * * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onThread(FirstEvent event) {

        int msg = event.getMsg();


        topSearch.setTranslationX(msg);

        float i = (float) ((140.0-msg)*(255.0 / 140.0));


        topSearch.getBackground().setAlpha((int)i);

        Log.d("harvic", "onThread收到了消息：" + msg + "--i = " + i );
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //解注册
        EventBus.getDefault().unregister(this);
    }
}
