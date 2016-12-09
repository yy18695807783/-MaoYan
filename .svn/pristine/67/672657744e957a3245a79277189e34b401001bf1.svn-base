package com.yanyin.maoyan.cinema.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.activity.FindCinemaActivity;
import com.yanyin.maoyan.activity.MeituanSelectCityActivity;
import com.yanyin.maoyan.base.BaseFragment;
import com.yanyin.maoyan.cinema.adapter.CinemaRecycleViewAdapyer;
import com.yanyin.maoyan.cinema.adapter.PinPaiAdapter;
import com.yanyin.maoyan.cinema.adapter.QuYuAdater;
import com.yanyin.maoyan.cinema.adapter.QuYuRightAdapter;
import com.yanyin.maoyan.cinema.bean.CinemaBean;
import com.yanyin.maoyan.ui.refreshView.CustomProgressDrawable;
import com.yanyin.maoyan.ui.refreshView.CustomSwipeRefreshLayout;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import okhttp3.Call;

import static com.yanyin.maoyan.R.id.listview_quyu_content;
import static com.yanyin.maoyan.R.id.recycleView_cinema;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：影院
 */
public class CinemaFragment extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.cb_01)
    CheckBox cb01;
    @Bind(R.id.cb_02)
    CheckBox cb02;
    @Bind(R.id.cb_03)
    CheckBox cb03;
    @Bind(R.id.cb_04)
    CheckBox cb04;
    @Bind(R.id.cb_05)
    CheckBox cb05;

    @Bind(R.id.cb_10)
    CheckBox cb10;
    @Bind(R.id.cb_11)
    CheckBox cb11;
    @Bind(R.id.cb_12)
    CheckBox cb12;
    @Bind(R.id.cb_13)
    CheckBox cb13;
    @Bind(R.id.cb_14)
    CheckBox cb14;
    @Bind(R.id.cb_15)
    CheckBox cb15;
    @Bind(R.id.cb_16)
    CheckBox cb16;
    @Bind(R.id.cb_17)
    CheckBox cb17;
    @Bind(R.id.cb_18)
    CheckBox cb18;
    @Bind(R.id.cb_19)
    CheckBox cb19;
    @Bind(R.id.cb_20)
    CheckBox cb20;
    @Bind(R.id.cb_21)
    CheckBox cb21;
    @Bind(R.id.cb_22)
    CheckBox cb22;
    @Bind(R.id.cb_23)
    CheckBox cb23;


    @Bind(R.id.tv_fuwu_chongzhi)
    TextView tvFuwuChongzhi;
    @Bind(R.id.tv_fuwu_wancheng)
    TextView tvFuwuWancheng;

    //四个控件透明地方消失
    @Bind(R.id.tv_quyu_xiaoshi)
    TextView tvQuyuXiaoshi;
    @Bind(R.id.tv_zuijin_xiaoshi)
    TextView tvZuijinXiaoshi;
    @Bind(R.id.tv_pinpai_xiaoshi)
    TextView tvPinpaiXiaoshi;
    @Bind(R.id.tv_fuwu_xiaoshi)
    TextView tvFuwuXiaoshi;
    @Bind(R.id.ll_zuijin_xiaoshi)
    LinearLayout llZuijinXiaoshi;
    private String[] diqu = new String[]{"全部", "朝阳区", "海淀区", "大兴区", "东城区", "丰台区", "西城区", "通州区", "昌平区", "房山区", "顺义区", "门头沟区",
            "石景山区", "怀柔区", "平谷区", "密云县", "延庆县"};

    private String[] ditie = new String[]{"1号线", "2号线", "3号线", "4号线", "5号线", "6号线", "7号线", "8号线", "9号线", "10号线"};

    private String[] cinema = new String[]{"大地影院", "保利国际影城", "耀莱成龙国际影城", "博纳国际影城", "星美国际影城", "百脑汇影城",
            "17.5影城", "CGV影城", "橙天嘉禾影城", "金逸影院", "中影国际影城", "万达影城",
            "新华国际影城", "首都电影院", "UME国际影城", "幸福蓝海国际影城", "卢米埃影城", "华谊兄弟影城", "17.5影城", "CGV影城", "橙天嘉禾影城", "金逸影院", "中影国际影城", "万达影城",
            "新华国际影城", "首都电影院", "UME国际影城", "幸福蓝海国际影城", "卢米埃影城", "华谊兄弟影城"};

    @Bind(R.id.title_city)
    TextView titleCity;
    @Bind(recycleView_cinema)
    RecyclerView recycleViewCinema;
    @Bind(R.id.iv_cinema_search)
    ImageView ivCinemaSearch;

    @Bind(R.id.ll_choose_addr)
    LinearLayout llChooseAddr;

    @Bind(R.id.swipe)
    CustomSwipeRefreshLayout swipe;

    @Bind(R.id.tv_addr_now)
    TextView tvAddrNow;
    @Bind(R.id.ll_addr_weizhi)
    LinearLayout llAddrWeizhi;


    @Bind(R.id.tv_cinema_quyu)
    TextView tvCinemaQuyu;
    @Bind(R.id.tv_cinema_zuijin)
    TextView tvCinemaZuijin;
    @Bind(R.id.tv_cinema_pinpai)
    TextView tvCinemaPinpai;
    @Bind(R.id.tv_cinema_fuwu)
    TextView tvCinemaFuwu;
    @Bind(R.id.rb_quyu_shangquan)
    RadioButton rbQuyuShangquan;
    @Bind(R.id.rb_quyu_ditie)
    RadioButton rbQuyuDitie;
    @Bind(R.id.rg_quyu)
    RadioGroup rgQuyu;
    @Bind(R.id.listview_quyu)
    ListView listviewQuyu;
    @Bind(listview_quyu_content)
    ListView listviewQuyuContent;
    @Bind(R.id.ll_quyu_layout)
    LinearLayout llQuyuLayout;

    @Bind(R.id.iv_cinema_quyu)
    ImageView ivCinemaQuyu;
    @Bind(R.id.ll_cinema_quyu)
    LinearLayout llCinemaQuyu;
    @Bind(R.id.iv_cinema_zuijin)
    ImageView ivCinemaZuijin;
    @Bind(R.id.ll_cinema_zuijin)
    LinearLayout llCinemaZuijin;
    @Bind(R.id.iv_cinema_pinpai)
    ImageView ivCinemaPinpai;
    @Bind(R.id.ll_cinema_pinpai)
    LinearLayout llCinemaPinpai;
    @Bind(R.id.iv_cinema_fuwu)
    ImageView ivCinemaFuwu;
    @Bind(R.id.ll_cinema_fuwu)
    LinearLayout llCinemaFuwu;

    @Bind(R.id.ll_zuidi)
    LinearLayout llZuidi;

    @Bind(R.id.listview_pinpai)
    ListView listviewPinpai;

    @Bind(R.id.ll_pinpai)
    LinearLayout llPinpai;
    @Bind(R.id.ll_fuwu)
    LinearLayout llFuwu;


    @Override
    protected RequestParams getParams() {
        return null;
    }

    @Override
    protected String getUrl() {
        return Constants.CINEMA_BODAY;
    }

    @Override
    protected void initData(String content) {
        LogUtil.e("影院数据：" + content);

        praseData(content);
    }

    private void praseData(String json) {
        Gson gson = new Gson();
        CinemaBean cinemaBean = gson.fromJson(json, CinemaBean.class);
        CinemaBean.DataBean data = cinemaBean.getData();

        CinemaRecycleViewAdapyer adapyer = new CinemaRecycleViewAdapyer(mContext, cinemaBean);
        recycleViewCinema.setAdapter(adapyer);

        recycleViewCinema.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        //单独悬浮窗点击事件
//        adapyer.setOnXuanFuZhuangClickListener(new CinemaRecycleViewAdapyer.OnXuanFuZhuangClickListener() {
//            @Override
//            public void onXuanFuChuangClick(View v) {
//                recycleViewCinema.scrollToPosition(2);
//
//                Toast.makeText(mContext, "影院界面的点击", Toast.LENGTH_SHORT).show();
//            }
//        });

        //数据
        initQuYuData(data);

        //监听
        initListener();
    }

    private void initQuYuData(CinemaBean.DataBean data) {

        final QuYuRightAdapter quYuRightAdapter = new QuYuRightAdapter(mContext);
        quYuRightAdapter.refresh(ditie);
        listviewQuyuContent.setAdapter(quYuRightAdapter);


        final QuYuAdater quYuAdater = new QuYuAdater(mContext);
        quYuAdater.refresh(diqu);
        listviewQuyu.setAdapter(quYuAdater);


        listviewQuyu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //选中时改变颜色
                quYuAdater.selectIndex = position;
                quYuAdater.notifyDataSetChanged();

                listviewQuyuContent.smoothScrollToPosition(0);

            }
        });


        rgQuyu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_quyu_shangquan://商圈
                        if (quYuAdater != null) {
                            quYuAdater.refresh(diqu);
                        }
                        if (quYuRightAdapter != null) {
                            quYuRightAdapter.refresh(ditie);
                        }

                        break;
                    case R.id.rb_quyu_ditie://地铁
                        if (quYuAdater != null) {
                            quYuAdater.refresh(ditie);
                        }
                        if (quYuRightAdapter != null) {
                            quYuRightAdapter.refresh(diqu);
                        }

                        break;
                }
            }
        });


    }

    //是否打开区域

    private boolean quyu = false;
    private boolean zuijin = false;
    private boolean pinpai = false;
    private boolean fuwu = false;


    @Override
    public void onClick(View v) {

        if (v == llCinemaQuyu) {//区域
            if (quyu) {//隐藏
                quyu = false;
                tvCinemaQuyu.setTextColor(Color.GRAY);
                ivCinemaQuyu.setBackgroundResource(R.drawable.a4k);

                //退出动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_out) ;
                llQuyuLayout.startAnimation(animation);

                llQuyuLayout.setVisibility(View.GONE);
            } else {//显示
                //全部变灰色  初始化
                setHuiSe();

                hideAll();

                quyu = true;
                tvCinemaQuyu.setTextColor(Color.RED);
                ivCinemaQuyu.setBackgroundResource(R.drawable.a4n);

                //显示动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_in) ;
                llQuyuLayout.startAnimation(animation);

                llQuyuLayout.setVisibility(View.VISIBLE);
            }


        } else if (v == llCinemaZuijin) {//离我最近
            if (zuijin) {//隐藏
                zuijin = false;
                tvCinemaZuijin.setTextColor(Color.GRAY);
                ivCinemaZuijin.setBackgroundResource(R.drawable.a4k);

                //退出动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_out) ;
                llZuidi.startAnimation(animation);

                llZuidi.setVisibility(View.GONE);
            } else {//显示

                //全部变灰色  初始化
                setHuiSe();

                hideAll();

                zuijin = true;
                tvCinemaZuijin.setTextColor(Color.RED);
                ivCinemaZuijin.setBackgroundResource(R.drawable.a4n);

                llZuidi.setVisibility(View.VISIBLE);

                //显示动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_in) ;
                llZuidi.startAnimation(animation);
            }


        } else if (v == llCinemaPinpai) {//品牌
            if (pinpai) {//退出隐藏
                pinpai = false;
                tvCinemaPinpai.setTextColor(Color.GRAY);
                ivCinemaPinpai.setBackgroundResource(R.drawable.a4k);

                //退出动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_out) ;
                llPinpai.startAnimation(animation);

                llPinpai.setVisibility(View.GONE);
            } else {

                //全部变灰色  初始化
                setHuiSe();

                hideAll();

                pinpai = true;
                tvCinemaPinpai.setTextColor(Color.RED);
                ivCinemaPinpai.setBackgroundResource(R.drawable.a4n);

                //显示动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_in) ;
                llPinpai.startAnimation(animation);

                llPinpai.setVisibility(View.VISIBLE);

                PinPaiAdapter pinPaiAdapter = new PinPaiAdapter(mContext);
                listviewPinpai.setAdapter(pinPaiAdapter);
                pinPaiAdapter.refresh(cinema);


            }

        } else if (v == llCinemaFuwu) {//特效/服务
            if (fuwu) {//隐藏
                fuwu = false;
                tvCinemaFuwu.setTextColor(Color.GRAY);
                ivCinemaFuwu.setBackgroundResource(R.drawable.a4k);

                //退出动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_out) ;
                llFuwu.startAnimation(animation);

                llFuwu.setVisibility(View.GONE);
            } else {//显示

                //全部变灰色  初始化
                setHuiSe();

                hideAll();

                fuwu = true;
                tvCinemaFuwu.setTextColor(Color.RED);
                ivCinemaFuwu.setBackgroundResource(R.drawable.a4n);

                //显示动画
                Animation animation = AnimationUtils.loadAnimation (mContext, R.anim.menu_bottombar_in) ;
                llFuwu.startAnimation(animation);

                llFuwu.setVisibility(View.VISIBLE);

                //先取消所有
                cb_gongneng(false);
                cb_texiao(false);

                //默认两个全部选择
                cb01.setChecked(true);
                cb10.setChecked(true);
            }

        } else if (v == cb01) {
            cb_gongneng(false);
            cb01.setChecked(true);
        } else if (v == cb02) {
            cb_gongneng(false);
            cb02.setChecked(true);
        } else if (v == cb03) {
            cb_gongneng(false);
            cb03.setChecked(true);
        } else if (v == cb04) {
            cb_gongneng(false);
            cb04.setChecked(true);
        } else if (v == cb05) {
            cb_gongneng(false);
            cb05.setChecked(true);
        } else if (v == cb10) {
            cb_texiao(false);
            cb10.setChecked(true);
        } else if (v == cb11) {
            cb_texiao(false);
            cb11.setChecked(true);
        } else if (v == cb12) {
            cb_texiao(false);
            cb12.setChecked(true);
        } else if (v == cb13) {
            cb_texiao(false);
            cb13.setChecked(true);
        } else if (v == cb14) {
            cb_texiao(false);
            cb14.setChecked(true);
        } else if (v == cb15) {
            cb_texiao(false);
            cb15.setChecked(true);
        } else if (v == cb16) {
            cb_texiao(false);
            cb16.setChecked(true);
        } else if (v == cb17) {
            cb_texiao(false);
            cb17.setChecked(true);
        } else if (v == cb18) {
            cb_texiao(false);
            cb18.setChecked(true);
        } else if (v == cb19) {
            cb_texiao(false);
            cb19.setChecked(true);
        } else if (v == cb20) {
            cb_texiao(false);
            cb20.setChecked(true);
        } else if (v == cb21) {
            cb_texiao(false);
            cb21.setChecked(true);
        } else if (v == cb22) {
            cb_texiao(false);
            cb22.setChecked(true);
        } else if (v == cb23) {
            cb_texiao(false);
            cb23.setChecked(true);
        } else if (v == tvFuwuChongzhi) {//重置
            cb_texiao(false);
            cb_gongneng(false);
            //重新默认两个全部选择
            cb01.setChecked(true);
            cb10.setChecked(true);

        } else if (v == tvFuwuWancheng) {//完成
            //相当于点击服务消失
            fuwu = false;
            tvCinemaFuwu.setTextColor(Color.GRAY);
            ivCinemaFuwu.setBackgroundResource(R.drawable.a4k);

            llFuwu.setVisibility(View.GONE);
        } else if (v == tvFuwuXiaoshi) {
            //服务消失
            fuwu = false;
            tvCinemaFuwu.setTextColor(Color.GRAY);
            ivCinemaFuwu.setBackgroundResource(R.drawable.a4k);

            llFuwu.setVisibility(View.GONE);
        } else if (v == tvPinpaiXiaoshi) {
            //品牌消失
            pinpai = false;
            tvCinemaPinpai.setTextColor(Color.GRAY);
            ivCinemaPinpai.setBackgroundResource(R.drawable.a4k);

            llPinpai.setVisibility(View.GONE);

        } else if (v == tvQuyuXiaoshi || v == llZuijinXiaoshi) {

            //区域消失
            quyu = false;
            tvCinemaQuyu.setTextColor(Color.GRAY);
            ivCinemaQuyu.setBackgroundResource(R.drawable.a4k);

            llQuyuLayout.setVisibility(View.GONE);

        } else if (v == tvZuijinXiaoshi) {
            //最近消失
            zuijin = false;
            tvCinemaZuijin.setTextColor(Color.GRAY);
            ivCinemaZuijin.setBackgroundResource(R.drawable.a4k);

            llZuidi.setVisibility(View.GONE);

        }

    }

    private void setHuiSe() {

        quyu = false;
        tvCinemaQuyu.setTextColor(Color.GRAY);
        ivCinemaQuyu.setBackgroundResource(R.drawable.a4k);

        zuijin = false;
        tvCinemaZuijin.setTextColor(Color.GRAY);
        ivCinemaZuijin.setBackgroundResource(R.drawable.a4k);

        pinpai = false;
        tvCinemaPinpai.setTextColor(Color.GRAY);
        ivCinemaPinpai.setBackgroundResource(R.drawable.a4k);

        fuwu = false;
        tvCinemaFuwu.setTextColor(Color.GRAY);
        ivCinemaFuwu.setBackgroundResource(R.drawable.a4k);

    }


    private void hideAll() {

        //区域
        llQuyuLayout.setVisibility(View.GONE);
        //最近
        llZuidi.setVisibility(View.GONE);
        //品牌
        llPinpai.setVisibility(View.GONE);
        //服务
        llFuwu.setVisibility(View.GONE);
    }

    private void initListener() {

        //悬浮窗的点击事件
        llCinemaQuyu.setOnClickListener(this);
        llCinemaZuijin.setOnClickListener(this);
        llCinemaPinpai.setOnClickListener(this);
        llCinemaFuwu.setOnClickListener(this);

        //服务check点击事件

        cb01.setOnClickListener(this);
        cb02.setOnClickListener(this);
        cb03.setOnClickListener(this);
        cb04.setOnClickListener(this);
        cb05.setOnClickListener(this);

        cb10.setOnClickListener(this);
        cb11.setOnClickListener(this);
        cb12.setOnClickListener(this);
        cb13.setOnClickListener(this);
        cb14.setOnClickListener(this);
        cb15.setOnClickListener(this);
        cb16.setOnClickListener(this);
        cb17.setOnClickListener(this);
        cb18.setOnClickListener(this);
        cb19.setOnClickListener(this);
        cb20.setOnClickListener(this);
        cb21.setOnClickListener(this);
        cb22.setOnClickListener(this);
        cb23.setOnClickListener(this);

        tvFuwuChongzhi.setOnClickListener(this);
        tvFuwuWancheng.setOnClickListener(this);

        //点击透明消失
        tvFuwuXiaoshi.setOnClickListener(this);
        tvPinpaiXiaoshi.setOnClickListener(this);
        tvQuyuXiaoshi.setOnClickListener(this);
        tvZuijinXiaoshi.setOnClickListener(this);
        llZuijinXiaoshi.setOnClickListener(this);


        //浮动窗的其他点击事件---品牌
        listviewPinpai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "您选择了" + cinema[position], Toast.LENGTH_SHORT).show();


                //相当于品牌消失
                pinpai = false;
                tvCinemaPinpai.setTextColor(Color.GRAY);
                ivCinemaPinpai.setBackgroundResource(R.drawable.a4k);

                llPinpai.setVisibility(View.GONE);
            }
        });



        recycleViewCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recycleViewCinema.scrollToPosition(1);
            }
        });




        recycleViewCinema.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //状态改变后显示
                llAddrWeizhi.setVisibility(View.VISIBLE);


            }

            //滑动过程中
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //状态变化就消失
                llAddrWeizhi.setVisibility(View.GONE);


                //获得recycleView中第一个可见视图的方法
                int firstVisibleItemPosition = ((LinearLayoutManager) (recyclerView.getLayoutManager())).findFirstVisibleItemPosition();
                if (firstVisibleItemPosition >= 1) {
                    llChooseAddr.setVisibility(View.VISIBLE);//第一个  吸顶文本的消失隐藏
                    LogUtil.e("33333333333333333333333333333---显示" + llChooseAddr.toString());
                } else {
                    llChooseAddr.setVisibility(View.GONE);
                    LogUtil.e("44444444444444444444444444444---隐藏");
                }

                LogUtil.e("23232323232323232323232333---可见第一个位置：" + firstVisibleItemPosition);
            }
        });


        final CustomProgressDrawable mprogressview = new CustomProgressDrawable(mContext, swipe);
        mprogressview.setProgressResource(mContext, R.drawable.a_a);
        mprogressview.setBackgroundColor(Color.GRAY);
        swipe.setProgressView(mprogressview, R.drawable.progress_bg);
        swipe.setOnRefreshListener(new CustomSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                //刷新的时候不让界面滑动
                recycleViewCinema.setLayoutFrozen(true);

                //调用LoadPager中的方法刷新
//                loadingPager.show();//重新加载布局，布局文件的id会变化，控制可能不一样

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipe.isRefreshing()) {

                            //发消息刷新数据
                            handler.sendEmptyMessage(0);

                            swipe.setRefreshing(false);

                            //刷新结束就可以滑动
                            recycleViewCinema.setLayoutFrozen(false);
                        }
                    }
                }, 2000);

            }
        });

//        assert recycleViewCinema != null;//RecyclerView
//        assert llChooseAddr != null;//吸顶文本


        //位置点击监听
        llAddrWeizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAddrNow.setText("定位中...");

                //2秒延迟
                handler.sendEmptyMessageDelayed(1, 2000);

            }
        });

        //城市按钮点击事件
        titleCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MeituanSelectCityActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        //搜索按钮的点击事件
        ivCinemaSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), FindCinemaActivity.class));
            }
        });

    }

    //城市按钮的回调
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

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    refreshData();
                    break;
                case 1:
                    tvAddrNow.setText("北京市昌平区北七家镇七北路");
                    break;
            }

        }
    };

    private void refreshData() {

        OkHttpUtils
                .get()
                .url(Constants.CINEMA_BODAY)
                .id(100)//下面回调的id
                .build()
                .execute(new MyCallbackListView());

    }


    public class MyCallbackListView extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.e("联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功" + response);
            if (!TextUtils.isEmpty(response)) {
                praseData(response);
            }

        }
    }


    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cinema;
    }


    private void cb_gongneng(boolean isOk) {

        cb01.setChecked(isOk);
        cb02.setChecked(isOk);
        cb03.setChecked(isOk);
        cb04.setChecked(isOk);
        cb05.setChecked(isOk);

    }

    private void cb_texiao(boolean isOk) {

        cb10.setChecked(isOk);
        cb11.setChecked(isOk);
        cb12.setChecked(isOk);
        cb13.setChecked(isOk);
        cb14.setChecked(isOk);
        cb15.setChecked(isOk);
        cb16.setChecked(isOk);
        cb17.setChecked(isOk);
        cb18.setChecked(isOk);
        cb19.setChecked(isOk);
        cb20.setChecked(isOk);
        cb21.setChecked(isOk);
        cb22.setChecked(isOk);
        cb23.setChecked(isOk);
    }


}
