package com.yanyin.maoyan.find.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.activity.MoveSearchActivity;
import com.yanyin.maoyan.activity.WebViewActivity;
import com.yanyin.maoyan.base.BaseFragment;
import com.yanyin.maoyan.find.adapter.FindFragmentRecycleviewAdapter;
import com.yanyin.maoyan.find.bean.FindBean;
import com.yanyin.maoyan.ui.refreshView.CustomProgressDrawable;
import com.yanyin.maoyan.ui.refreshView.CustomSwipeRefreshLayout;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：发现
 */

public class FindFragment extends BaseFragment {

    @Bind(R.id.tv_title_search)
    TextView tvTitleSearch;
    @Bind(R.id.recycleview_find)
    RecyclerView recycleviewFind;

    @Bind(R.id.swipe)
    CustomSwipeRefreshLayout swipe;

    //主题部分集合
    private List<FindBean.DataBean.FeedsBean> feeds;
    private FindFragmentRecycleviewAdapter adapter;


    //上啦加载
    private int realSize = 10;
    private int pager = 0;

    @Override
    protected RequestParams getParams() {
        return null;
    }

    @Override
    protected String getUrl() {
        return Constants.FIND_BODYMSG + "0" + Constants.FIND_BODYMSG_LAST;
    }

    @Override
    protected void initData(String content) {
        LogUtil.e("字符串" + content);

        praseData(content);

        if (feeds != null && feeds.size() > 0) {
            adapter = new FindFragmentRecycleviewAdapter(mContext, feeds);
            recycleviewFind.setAdapter(adapter);
            recycleviewFind.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        }

        //监听
        initListener();
    }

    private void initListener() {

        CustomProgressDrawable mprogressview = new CustomProgressDrawable(mContext,swipe);
        mprogressview.setProgressResource(mContext,R.drawable.a_a);
        mprogressview.setBackgroundColor(Color.GRAY);
        swipe.setProgressView(mprogressview,R.drawable.progress_bg);
        swipe.setOnRefreshListener(new CustomSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                //调用LoadPager中的方法刷新
                loadingPager.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(swipe.isRefreshing()) {

                            //发消息刷新数据
                            handler.sendEmptyMessage(0);

                            swipe.setRefreshing(false);
                        }
                    }
                },3000);

            }
        });

        if (adapter != null) {
            adapter.setOnTopClickListener(new FindFragmentRecycleviewAdapter.OnTopClickListener() {
                @Override
                public void onTopClick(View v) {
//                    Toast.makeText(mContext, "今日Top10", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("web", Constants.FIND_TOP10);
                    intent.putExtra("title", "今日TOP10");
                    getActivity().startActivity(intent);

                }

                @Override
                public void onKuaiXunClick(View v) {
//                    Toast.makeText(mContext, "影视快讯", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("web", Constants.FIND_KUAIXUN);
                    intent.putExtra("title", "影视快讯");
                    getActivity().startActivity(intent);
                }

                @Override
                public void onZhouBianClick(View v) {
                    Toast.makeText(mContext, "周边商城", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onShiShiClick(View v) {
//                    Toast.makeText(mContext, "实时票房", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("web", Constants.FIND_SHISHI);
                    intent.putExtra("title", "猫眼专业版");
                    getActivity().startActivity(intent);

                }
            });
        }


        //上啦加载更多
        recycleviewFind.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int lastPosition = ((LinearLayoutManager) (recyclerView.getLayoutManager())).findLastVisibleItemPosition();

                LogUtil.e("最后一个是第几条"+lastPosition);//最后一条

                if(lastPosition == realSize){//请求更多数据
                    pager += 10;//增加10条信息

                    getMoreData(Constants.FIND_BODYMSG + pager + Constants.FIND_BODYMSG_LAST);


                }else {

                }

            }


        });


    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            switch (msg.what) {
                case 0 :
                    refreshData();
                    break;
            }

        }
    };


    //上啦加载更多
    private void getMoreData(String url) {

        OkHttpUtils
                .get()
                .url(url)
                .id(100)//下面回调的id
                .build()
                .execute(new MoreCallbackListView());

    }

    public class MoreCallbackListView extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.e("联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功" + response);
            if (!TextUtils.isEmpty(response)) {
                praseMoreData(response);
            }

        }
    }

    private void praseMoreData(String json) {
        Gson gson = new Gson();
        FindBean moreData = gson.fromJson(json, FindBean.class);

        boolean hasMore = moreData.getData().getPaging().isHasMore();
        if(hasMore){//有更多
            //太多了，不判断啦 ，实际是要判断的
        }else {//没有更多
            Toast.makeText(mContext, "没有更多数据了", Toast.LENGTH_SHORT).show();
            return;
        }

        //主体部分数据集合
        List<FindBean.DataBean.FeedsBean> feeds = moreData.getData().getFeeds();

        realSize += feeds.size();

        if(adapter!=null){
            adapter.addMoreData(feeds);
        }



    }


    //下拉刷新
    private void refreshData() {

        OkHttpUtils
                .get()
                .url(Constants.FIND_BODYMSG + "0" + Constants.FIND_BODYMSG_LAST)
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
//                praseRefreshData(response);
                praseData(response);

                //初始化下拉加载也的数字
                realSize = 10;

            }

        }
    }

    //下拉刷新
    private void praseRefreshData(String json) {
        Gson gson = new Gson();
        FindBean findBean = gson.fromJson(json, FindBean.class);
        //主体部分数据集合
        List<FindBean.DataBean.FeedsBean> feeds = findBean.getData().getFeeds();

        if(adapter!=null){
            adapter.refresh(feeds);
        }
//        FindBean.DataBean.PagingBean paging = findBean.getData().getPaging();
    }


    //解析字符串
    private void praseData(String json) {
        Gson gson = new Gson();
        FindBean findBean = gson.fromJson(json, FindBean.class);
        //主体部分数据集合
        feeds = findBean.getData().getFeeds();

        //下面判断还有更多
        FindBean.DataBean.PagingBean paging = findBean.getData().getPaging();
    }

    @Override
    protected void initTitle() {

        tvTitleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(mContext, MoveSearchActivity.class));
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

}
