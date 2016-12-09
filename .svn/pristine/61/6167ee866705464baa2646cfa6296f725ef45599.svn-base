package com.yanyin.maoyan.move.fragment.viewpager;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loopj.android.http.RequestParams;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.activity.JieCaoActivity;
import com.yanyin.maoyan.activity.MoveSearchActivity;
import com.yanyin.maoyan.activity.WebViewActivity;
import com.yanyin.maoyan.base.BaseFragment;
import com.yanyin.maoyan.move.adapter.WaiteRecycleViewAdapter;
import com.yanyin.maoyan.move.bean.FirstEvent;
import com.yanyin.maoyan.move.bean.WaiteBean;
import com.yanyin.maoyan.move.bean.WaiteYuGaoBean;
import com.yanyin.maoyan.move.bean.WaiteZuiQiDaiBean;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.Bind;

import static com.yanyin.maoyan.R.id.tv_sticky_header_view;


/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：电影-待映
 */
public class WaiteFragment extends BaseFragment {

    @Bind(R.id.recycleview_waite)
    RecyclerView recycleviewWaite;
    @Bind(tv_sticky_header_view)
    TextView tvStickyHeaderView;

    private List<WaiteBean.DataBean.ComingBean> comingBeanList;
    private WaiteRecycleViewAdapter adapter;

    @Override
    protected RequestParams getParams() {
        return null;
    }

    @Override
    protected String getUrl() {
        return Constants.WAITE_LISTVIEW;
    }

    @Override
    protected void initData(String content) {
        LogUtil.e("JSON:-->" + content);
        if (!TextUtils.isEmpty(content)) {
            praseBaen(content);
        }

    }

    @Override
    protected void initTitle() {

    }

    private void praseBaen(String json) {
        JSONObject jsonObject = JSON.parseObject(json);

        String data = jsonObject.getString("data");

        WaiteBean.DataBean dataBean = JSON.parseObject(data, WaiteBean.DataBean.class);

        //数据集合
        comingBeanList = dataBean.getComing();
        LogUtil.e("数据集合：-->" + comingBeanList.toString());

        if (comingBeanList != null && comingBeanList.size() > 0) {

            adapter = new WaiteRecycleViewAdapter(mContext, comingBeanList);

            recycleviewWaite.setAdapter(adapter);
            //设置recycleView的管理器
//            GridLayoutManager gridLayoutManager =  new GridLayoutManager(mContext, 1,GridLayoutManager.VERTICAL, false);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);

            //设置滑动到哪个位置了的监听
//            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                @Override
//                public int getSpanSize(int position) {
//                    if (position <= 3) {//当分类型RecycleView屏幕条数小于3条或等于3条时，就隐藏。
//                        ibTop.setVisibility(View.GONE);
//                    } else {//完全显示第四条就开始显示ibTop 键
//                        ibTop.setVisibility(View.VISIBLE);
//                    }
//                    return 1;//表示一行就占一个部分的GridLayoutManager分列
//                }
//            });

            recycleviewWaite.setLayoutManager(linearLayoutManager);

        }
        initListener();


    }



    private void initListener() {

        //悬浮窗推动
        assert recycleviewWaite != null;//RecyclerView
        assert tvStickyHeaderView != null;//吸顶文本

        recycleviewWaite.addOnScrollListener(new RecyclerView.OnScrollListener() {


//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//
//                //测试自定义控件
//                int height = recyclerView.getChildAt(0).getHeight();
//                LogUtil.e("=====" + height);
//            }

            private int totalDy = 0;


            //滑动过程中
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalDy = recyclerView.getChildAt(0).getTop();



                LogUtil.e("------" + totalDy);

                //获得recycleView中第一个可见视图的方法
                int firstVisibleItemPosition = ((LinearLayoutManager) (recyclerView.getLayoutManager())).findFirstVisibleItemPosition();
                if(firstVisibleItemPosition == 0){
                    tvStickyHeaderView.setVisibility(View.GONE);//第一个  吸顶文本的消失隐藏

                    //头才发
                    // Eventbus发送消息的地方 转送一个类的对象
                    EventBus.getDefault().post(new FirstEvent(totalDy));

                }else{
                    tvStickyHeaderView.setVisibility(View.VISIBLE);
                }


                // Get the sticky information from the topmost view of the screen.从屏幕顶端的观点得到了粘性信息。
                View stickyInfoView = recyclerView.findChildViewUnder(
                        tvStickyHeaderView.getMeasuredWidth() / 2, 5);

                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {//判断顶部第一个item
                    tvStickyHeaderView.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                // Get the sticky view's translationY by the first view below the sticky's height.下面由粘性的高度第一视角得到视图的translationy粘。
                View transInfoView = recyclerView.findChildViewUnder(
                        tvStickyHeaderView.getMeasuredWidth() / 2, tvStickyHeaderView.getMeasuredHeight() + 1);

                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tvStickyHeaderView.getMeasuredHeight();
                    if (transViewStatus == WaiteRecycleViewAdapter.HAS_STICKY_VIEW) {
                        // If the first view below the sticky's height scroll off the screen,如果第一个视图低于粘性的高度从屏幕上滚动，
                        // then recovery the sticky view's translationY.然后恢复视图的translationy粘。
                        if (transInfoView.getTop() > 0) {
                            tvStickyHeaderView.setTranslationY(dealtY);
                        } else {
                            tvStickyHeaderView.setTranslationY(0);
                        }
                    } else if (transViewStatus == WaiteRecycleViewAdapter.NONE_STICKY_VIEW) {
                        tvStickyHeaderView.setTranslationY(0);
                    }
                }
            }

        });



        if (adapter != null) {
            adapter.setOnsetWaiteAdapterItemListener(new WaiteRecycleViewAdapter.OnsetWaiteAdapterItemListener() {
                //预告点击回调
                @Override
                public void onYuGaoClick(View v, WaiteYuGaoBean.DataBean dataBean) {
//                    Toast.makeText(mContext, "预告：" + dataBean.getMovieName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, JieCaoActivity.class);
                    intent.putExtra("title", dataBean.getMovieName());
                    intent.putExtra("move",dataBean.getUrl());
                    startActivity(intent);

                }

                //期待点击回调
                @Override
                public void onQiDaiClick(View v, WaiteZuiQiDaiBean.DataBean.ComingBean comingBean) {
//                    Toast.makeText(mContext, "期待：" + comingBean.getNm(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("title", comingBean.getNm());
                    intent.putExtra("web", Constants.MOVE_LISEVIEW_CLICK + comingBean.getId() + Constants.MOVE_LISTVIEW_CLICK_LAST);
                    startActivity(intent);

                }

                //图片的点击回调
                @Override
                public void onPictureClick(View v, WaiteBean.DataBean.ComingBean comingBean) {
                    Toast.makeText(mContext, "图片：" + comingBean.getImg(), Toast.LENGTH_SHORT).show();
                }

                //预售按钮的点击回调
                @Override
                public void onButtonClick(View v, WaiteBean.DataBean.ComingBean comingBean) {
                    Toast.makeText(mContext, "预售：" + comingBean.getNm(), Toast.LENGTH_SHORT).show();
                }

                //整条的点击回调
                @Override
                public void onItemClick(View v, WaiteBean.DataBean.ComingBean comingBean) {
//                    Toast.makeText(mContext, "整条：" + comingBean.getNm(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("title", comingBean.getNm());
                    intent.putExtra("web", Constants.MOVE_LISEVIEW_CLICK + comingBean.getId() + Constants.MOVE_LISTVIEW_CLICK_LAST);
                    startActivity(intent);
                }

                //搜索框点击监听
                @Override
                public void onTitleClick(View v) {
//                    Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(mContext, MoveSearchActivity.class));
                }
            });

        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_waite;
    }

}
