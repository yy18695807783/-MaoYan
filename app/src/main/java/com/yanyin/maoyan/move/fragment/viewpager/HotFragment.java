package com.yanyin.maoyan.move.fragment.viewpager;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.listviewrefresh_library.RefreshListView;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.activity.MoveSearchActivity;
import com.yanyin.maoyan.activity.WebViewActivity;
import com.yanyin.maoyan.base.BaseFragment;
import com.yanyin.maoyan.move.adapter.HotFragmentAdapter;
import com.yanyin.maoyan.move.bean.FirstEvent;
import com.yanyin.maoyan.move.bean.ListViewBean;
import com.yanyin.maoyan.move.bean.ViewPagerBean;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

import static com.yanyin.maoyan.R.id.listview_move;


/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：电影-热映
 */
public class HotFragment extends BaseFragment {


    @Bind(listview_move)
    RefreshListView listviewMove;

    //    @Bind(R.id.listview_move)
//    ListView listviewMove;
    //    @Bind(tv_title_search)
    TextView tvTitleSearch;
    //    @Bind(R.id.banner)
    Banner banner;

//    private TextView tvTitleSearch;
//    private Banner banner;


    private ViewPagerBean viewPagerBean;
    private List<ListViewBean.DataBean.MoviesBean> movies;
    private HotFragmentAdapter adapter;


    @Override
    protected RequestParams getParams() {
        return null;
    }

    @Override
    protected String getUrl() {
        return Constants.MOVE_HOT;
    }

    @Override
    protected void initData(String content) {

//        LogUtil.e("666666666666666666666666" + content);
        if (!TextUtils.isEmpty(content)) {
            parseJson(content);//解析头布局
        }

        //listView布局联网下载
        OkHttpUtils
                .get()
                .url(Constants.MOVE_LISTVIEW)
                .id(100)//下面回调的id
                .build()
                .execute(new MyStringCallbackListView());


        //搜索动画监听
        initListViewListener();
    }

    private void initListViewListener() {


        listviewMove.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                LogUtil.e("---y:" + view.getScaleY() + "----scrollState" + scrollState);

                //以下方法可以测量出listView第一个子View 的动态滑动高度  可以发消息改变头部动态搜索放大镜按钮
                View childAt = view.getChildAt(0);
                int firstVisiblePosition = listviewMove.getFirstVisiblePosition();
                int top = childAt.getTop();
                int i = -top + firstVisiblePosition * childAt.getHeight();

                if (i <= 140) {
                    //头才发
                    // Eventbus发送消息的地方 转送一个类的对象
                    EventBus.getDefault().post(new FirstEvent(-i));
                    LogUtil.e("------------>" + i);
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                LogUtil.e("---Y:" + firstVisibleItem + "---" + visibleItemCount + "---" + totalItemCount);


            }
        });
    }


    @Override
    protected void initTitle() {


        View headView = getLayoutInflater(null).inflate(R.layout.tabdetail_banner, listviewMove, false);
        tvTitleSearch = (TextView) headView.findViewById(R.id.tv_title_search);
        banner = (Banner) headView.findViewById(R.id.banner);

//        listviewMove.addHeaderView(headView);
        listviewMove.addTopNewsView(headView);

        //设置刷新监听
        listviewMove.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            //下拉刷新
            @Override
            public void onPullDownRefresh() {

                //listView布局联网下载
                OkHttpUtils
                        .get()
                        .url(Constants.MOVE_LISTVIEW)
                        .id(100)//下面回调的id
                        .build()
                        .execute(new MyStringCallbackListView());
            }

            //加载更多
            @Override
            public void onLoadMore() {
                //直接结束  不做先
                listviewMove.onFinishRefrsh(false);
            }
        });

        //搜索框点击事件
        tvTitleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(mContext, MoveSearchActivity.class));
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }


    //listView的联网回调方法
    public class MyStringCallbackListView extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.e("联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功" + response);
            if (!TextUtils.isEmpty(response)) {
                parseJsonForListView(response);
            }
            listviewMove.onFinishRefrsh(false);

        }
    }

    private void parseJsonForListView(String json) {
        if (!TextUtils.isEmpty(json)) {
            JSONObject jsonObject = JSON.parseObject(json);

            //ListView的数据信息
            String data = jsonObject.getString("data");
//            LogUtil.e("listView————data-->" + data.toString());

            ListViewBean listViewBean = new ListViewBean();

            ListViewBean.DataBean dataBean = JSON.parseObject(data, ListViewBean.DataBean.class);
            listViewBean.setData(dataBean);

            //电影集合
            movies = listViewBean.getData().getMovies();
//            LogUtil.e("movies条数" + movies.size());

            //数据完成
            if (movies != null && movies.size() > 0) {
                LogUtil.e("movies.size()" + movies.size());
                adapter = new HotFragmentAdapter(movies, mContext);
                listviewMove.setAdapter(adapter);
            }

            //listView的点击事件
            adapter.setOnListViewItemClickListener(new HotFragmentAdapter.OnListViewItemClickListener() {
                //整条
                @Override
                public void onItemClick(View view, ListViewBean.DataBean.MoviesBean moviesBean) {
//                    Toast.makeText(mContext, moviesBean.getNm(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("title", moviesBean.getNm());
                    intent.putExtra("web", Constants.MOVE_LISEVIEW_CLICK + moviesBean.getId() + Constants.MOVE_LISTVIEW_CLICK_LAST);
                    startActivity(intent);

                }

                //图片点击事件
                @Override
                public void onPictureClick(View v, ListViewBean.DataBean.MoviesBean moviesBean) {
                    Toast.makeText(mContext, "播放界面的点击-->" + moviesBean.getNm(), Toast.LENGTH_SHORT).show();
                }

                //预定
                @Override
                public void onYuDingBtn(View v, ListViewBean.DataBean.MoviesBean moviesBean) {
                    Toast.makeText(mContext, "预定:-->" + moviesBean.getNm(), Toast.LENGTH_SHORT).show();
                }

                //订购
                @Override
                public void onDingGouBtn(View v, ListViewBean.DataBean.MoviesBean moviesBean) {
                    Toast.makeText(mContext, "订购:-->" + moviesBean.getNm(), Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

    private void parseJson(String json) {
        if (!TextUtils.isEmpty(json)) {
            JSONObject jsonObject = JSON.parseObject(json);

            String data = jsonObject.getString("data");
            LogUtil.e("data-->" + data.toString());

            viewPagerBean = new ViewPagerBean();

            List<ViewPagerBean.DataBean> dataBeen = JSON.parseArray(data, ViewPagerBean.DataBean.class);
            viewPagerBean.setData(dataBeen);

            //创建图片Url集合
            List<String> imageUrl = new ArrayList<>();
            viewPagerBean.setData(dataBeen);
            LogUtil.e("dataBeen.size():" + dataBeen.size());
            for (int i = 0; i < dataBeen.size(); i++) {
                imageUrl.add(dataBeen.get(i).getImgUrl());
                LogUtil.e(i + "图片地址-->" + dataBeen.get(i).getImgUrl());
            }

//            LogUtil.e("333333333" + imageUrl.size());

            //设置Banner
            if (imageUrl != null && imageUrl.size() > 0) {
                setBanner(imageUrl);
            }

        }
        //关闭刷新
        listviewMove.onFinishRefrsh(false);
    }

    //Banner的设置
    private void setBanner(List<String> imageUrls) {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //获取图片路径集合--上面已经获取过了

        banner.setImages(imageUrls);
        //设置banner动画效果   Transformer.CubeOut //立体效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
//        String[] titles = new String[]{"尚硅谷在线课堂", "抱歉，没座位了", "史上最高大上的开学典礼"};
//        banner.setBannerTitles(Arrays.asList(titles));
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        //Banner的点击事件
        initListener();
    }

    /**
     * banner加载图片用的
     */
    public class GlideImageLoader implements ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            //Picasso 加载图片简单用法
            Picasso.with(context).load((String) path).into(imageView);
//            Log.e("TAG", "444444444444");

        }
    }


    //banner的点击事件
    protected void initListener() {

        //listView监听


        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                LogUtil.e("位置" + position);

                String name = viewPagerBean.getData().get(position - 1).getName();
                Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();

            }
        });

    }


}
