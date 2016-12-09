//package com.yanyin.maoyan.move.fragment.viewpager;
//
//
//import android.content.Intent;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.loopj.android.http.RequestParams;
//import com.yanyin.maoyan.R;
//import com.yanyin.maoyan.activity.MoveSearchActivity;
//import com.yanyin.maoyan.base.BaseFragment;
//import com.yanyin.maoyan.move.adapter.WaiteFragmentAdapter;
//import com.yanyin.maoyan.move.adapter.WaiteQiDaiAdapter;
//import com.yanyin.maoyan.move.adapter.WaiteYuGaoAdapter;
//import com.yanyin.maoyan.move.bean.WaiteBean;
//import com.yanyin.maoyan.move.bean.WaiteYuGaoBean;
//import com.yanyin.maoyan.move.bean.WaiteZuiQiDaiBean;
//import com.yanyin.maoyan.utils.Constants;
//import com.yanyin.maoyan.utils.LogUtil;
//import com.zhy.http.okhttp.OkHttpUtils;
//import com.zhy.http.okhttp.callback.StringCallback;
//
//import java.util.List;
//
//import butterknife.Bind;
//import okhttp3.Call;
//
//
///**
// * Created by 颜银 on 2016/11/30.
// * QQ:443098360
// * 微信：y443098360
// * 作用：电影-待映
// */
//public class WaiteFragment extends BaseFragment {
//
//    @Bind(R.id.listview_waite)
//    ListView listviewWaite;
//
//    private List<WaiteBean.DataBean.ComingBean> comingBeanList;
//    private WaiteFragmentAdapter waiteFragmentAdapter;
//    //头部搜索框
//    private TextView tv_title_search;
//    private WaiteQiDaiAdapter waiteQiDaiAdapter;
//    //待映预告片
//    private List<WaiteYuGaoBean.DataBean> dataYuGaoBeen;
//    //待映最期待
//    private List<WaiteZuiQiDaiBean.DataBean.ComingBean> dataZuiQiDai;
//    private WaiteYuGaoAdapter waiteYuGaoAdapter;
//
//    @Override
//    protected RequestParams getParams() {
//        return null;
//    }
//
//    @Override
//    protected String getUrl() {
//        return Constants.WAITE_LISTVIEW;
//    }
//
//    @Override
//    protected void initData(String content) {
//        LogUtil.e("JSON:-->" + content);
//        if (!TextUtils.isEmpty(content)) {
//            praseBaen(content);
//        }
//
//    }
//
//    private void praseBaen(String json) {
//        JSONObject jsonObject = JSON.parseObject(json);
//
//        String data = jsonObject.getString("data");
//
//        WaiteBean.DataBean dataBean = JSON.parseObject(data, WaiteBean.DataBean.class);
//
//        //数据集合
//        comingBeanList = dataBean.getComing();
//        LogUtil.e("数据集合：-->" + comingBeanList.toString());
//
//        if (comingBeanList != null && comingBeanList.size() > 0) {
//            waiteFragmentAdapter = new WaiteFragmentAdapter(mContext, comingBeanList);
//
//            listviewWaite.setAdapter(waiteFragmentAdapter);
//        }
//
//
//        initHeadData();
//
//        //添加头布局
//        initHead();
//
//        //点击监听
//        initListener();
//
//
//    }
//
//
//    private void initHead() {
//
//
//        View headView = getLayoutInflater(null).inflate(R.layout.head_waite, listviewWaite, false);
//        tv_title_search = (TextView) headView.findViewById(R.id.tv_title_search);
//
//
//
////        LinearLayout ll_head_waite_yugao = (LinearLayout) headView.findViewById(R.id.ll_head_waite_yugao);
////
////        LogUtil.e("进来111111111");
////
////        if (comingBeanList != null && comingBeanList.size() > 0) {
////
////            for (int i = 0; i < comingBeanList.size(); i++) {
////                LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
////                lineLp.setMargins(UIUtils.dp2px(8), UIUtils.dp2px(8), 0, UIUtils.dp2px(8));
////
////                View view = View.inflate(mContext, R.layout.item_waite_yushou, null);
//////                View view = mLayoutInflater.inflate(R.layout.item_waite_yushou,null);
////
////                ImageView iv_waite_yugao_icon = (ImageView) view.findViewById(R.id.iv_waite_yugao_icon);
////                TextView tv_waite_yugao_name = (TextView) view.findViewById(R.id.tv_waite_yugao_name);
////                TextView tv_waite_yugao_desc = (TextView) view.findViewById(R.id.tv_waite_yugao_desc);
////
////                final WaiteBean.DataBean.ComingBean comingBean = comingBeanList.get(i);
////
////                tv_waite_yugao_desc.setText(comingBean.getVideoName() + comingBean.getPubDesc());
////                tv_waite_yugao_name.setText(comingBean.getNm());
////
////                String imgUrl = comingBean.getImg();
////                imgUrl = "http://p0.meituan.net/80.120" + imgUrl.substring(25);
////                Picasso.with(mContext).load(imgUrl).into(iv_waite_yugao_icon);
////
////                view.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        Toast.makeText(mContext, comingBean.getNm(), Toast.LENGTH_SHORT).show();
////                    }
////                });
////
////
////                //添加进去
////                ll_head_waite_yugao.addView(view, lineLp);
////            }
////        }
//
//        //预告
//        RecyclerView rcv_yugao = (RecyclerView) headView.findViewById(R.id.rcv_yugao);
//
//        waiteYuGaoAdapter = new WaiteYuGaoAdapter(mContext);
//
//        rcv_yugao.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false));
//
//        rcv_yugao.setAdapter(waiteYuGaoAdapter);
//
//
//        //最受期待
//        RecyclerView scrollViewPager_qidai = (RecyclerView) headView.findViewById(R.id.scrollViewPager_qidai);
//
//        LogUtil.e("进来2222222222");
//
//        waiteQiDaiAdapter = new WaiteQiDaiAdapter(mContext);
//
//        scrollViewPager_qidai.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false));
//
//        scrollViewPager_qidai.setAdapter(waiteQiDaiAdapter);
//
//
//        //添加头布局
//        listviewWaite.addHeaderView(headView);
//
//    }
//
//    private void initListener() {
//        //搜索框点击事件
//        tv_title_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
//
//                startActivity(new Intent(mContext, MoveSearchActivity.class));
//            }
//        });
//
//        //预告点击事件
//        if(waiteYuGaoAdapter!=null){
//            waiteYuGaoAdapter.setOnYuGaoItemClickListener(new WaiteYuGaoAdapter.OnYuGaoItemClickListener() {
//                @Override
//                public void onYuGaoItemClick(View v, WaiteYuGaoBean.DataBean dataBean) {
//                    Toast.makeText(mContext, dataBean.getMovieName(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//
//        //期待点击事件
//        if (waiteQiDaiAdapter != null) {
//            waiteQiDaiAdapter.setOnQiDaiItemClickListener(new WaiteQiDaiAdapter.OnQiDaiItemClickListener() {
//
//                @Override
//                public void onQiDaiItemClick(View v, WaiteZuiQiDaiBean.DataBean.ComingBean comingBean) {
//                    Toast.makeText(mContext, comingBean.getNm(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//
//        //下面listView的点击监听
//        if (waiteFragmentAdapter != null) {
//            waiteFragmentAdapter.setOnsetWaiteAdapterItemListener(new WaiteFragmentAdapter.OnsetWaiteAdapterItemListener() {
//
//                //图片的点击回调
//                @Override
//                public void onPictureClick(View v, WaiteBean.DataBean.ComingBean comingBean) {
//                    Toast.makeText(mContext, "图片：" + comingBean.getImg(), Toast.LENGTH_SHORT).show();
//                }
//
//                //预售按钮的点击回调
//                @Override
//                public void onButtonClick(View v, WaiteBean.DataBean.ComingBean comingBean) {
//                    Toast.makeText(mContext, "预售：" + comingBean.getNm(), Toast.LENGTH_SHORT).show();
//                }
//
//                //整条的点击回调
//                @Override
//                public void onItemClick(View v, WaiteBean.DataBean.ComingBean comingBean) {
//                    Toast.makeText(mContext, "整条：" + comingBean.getNm(), Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        }
//
//
//    }
//
//    @Override
//    protected void initTitle() {
//
//
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.fragment_waite1;
//    }
//
//
//    //加载头部两个数据集合
//    private void initHeadData() {
//        OkHttpUtils
//                .get()
//                .url(Constants.WAITE_YUGAO)
//                .id(100)//下面回调的id
//                .build()
//                .execute(new YuGaoCallbackListView());
//
//
//        OkHttpUtils
//                .get()
//                .url(Constants.WAITE_ZUIQIDAI)
//                .id(100)//下面回调的id
//                .build()
//                .execute(new ZuiQiDaiCallbackListView());
//
//
//    }
//
//    //待映预告
//    public class YuGaoCallbackListView extends StringCallback {
//
//        @Override
//        public void onError(Call call, Exception e, int id) {
//            LogUtil.e("联网失败" + e.toString());
//        }
//
//        @Override
//        public void onResponse(String response, int id) {
//            LogUtil.e("联网成功" + response);
//            if (!TextUtils.isEmpty(response)) {
//                praseWaiteYuGaoBean(response);
//            }
//
//        }
//    }
//
//    private void praseWaiteYuGaoBean(String json) {
//        JSONObject jsonObject = JSON.parseObject(json);
//        String data = jsonObject.getString("data");
//
//        dataYuGaoBeen = JSON.parseArray(data, WaiteYuGaoBean.DataBean.class);
//
//        LogUtil.e("555555555555" + dataYuGaoBeen.get(0).getMovieName());
//
//        if(dataYuGaoBeen!=null&&dataYuGaoBeen.size()>0){
//            waiteYuGaoAdapter.Refresh(dataYuGaoBeen);
//        }
//
//    }
//
//    //待映最期待
//    public class ZuiQiDaiCallbackListView extends StringCallback {
//
//        @Override
//        public void onError(Call call, Exception e, int id) {
//            LogUtil.e("联网失败" + e.toString());
//        }
//
//        @Override
//        public void onResponse(String response, int id) {
//            LogUtil.e("联网成功" + response);
//            if (!TextUtils.isEmpty(response)) {
//                praseWaiteZuiQiDaiBean(response);
//            }
//
//        }
//    }
//
//    private void praseWaiteZuiQiDaiBean(String json) {
//        JSONObject jsonObject = JSON.parseObject(json);
//        String data = jsonObject.getString("data");
//
//        WaiteZuiQiDaiBean.DataBean dataBean = JSON.parseObject(data, WaiteZuiQiDaiBean.DataBean.class);
//
//        //最期待数据
//        dataZuiQiDai = dataBean.getComing();
//        if(dataZuiQiDai!=null&&dataZuiQiDai.size()>0){
//            waiteQiDaiAdapter.Refresh(dataZuiQiDai);
//        }
//
//
//    }
//}
