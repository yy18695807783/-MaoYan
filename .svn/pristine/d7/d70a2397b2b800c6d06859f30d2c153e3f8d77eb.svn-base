package com.yanyin.maoyan.move.fragment.viewpager;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.activity.FindHotActivity;
import com.yanyin.maoyan.activity.MoveSearchActivity;
import com.yanyin.maoyan.base.BaseFragment;
import com.yanyin.maoyan.move.QuanQiuJiangActivity;
import com.yanyin.maoyan.move.adapter.JiangXiangPicAdapter;
import com.yanyin.maoyan.move.bean.JiangXiangPicBean;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.yanyin.maoyan.utils.UIUtils;

import java.util.List;

import butterknife.Bind;


/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：电影-找片
 */
public class FindmovesFragment extends BaseFragment {

    @Bind(R.id.recycleview_jiang)
    RecyclerView recycleviewJiang;

    private String[] type = new String[]{"爱情", "喜剧", "动画", "剧情", "恐怖", "惊悚", "科幻", "动作", "悬疑", "犯罪", "冒险", "战争", "奇幻", "运动", "家庭", "古装", "武侠", "西部", "历史", "传记", "情色", "歌舞", "黑色电影", "短片", "纪录片", "其他"};
    private String[] address = new String[]{"大陆", "美国", "韩国", "日本", "中国香港", "中国台湾", "泰国", "印度", "法国", "英国", "俄罗斯", "意大利", "西班牙", "德国", "波兰", "澳大利亚", "伊朗", "其他"};
    private String[] year = new String[]{"2017以后", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2000-2010", "90年代", "80年代", "70年代", "更早"};

    @Bind(R.id.ll_find_type)
    LinearLayout llFindType;
    @Bind(R.id.ll_find_address)
    LinearLayout llFindAddress;
    @Bind(R.id.ll_find_year)
    LinearLayout llFindYear;
    @Bind(R.id.tv_title_search)
    TextView tvTitleSearch;

    @Bind(R.id.tv_find_reying)
    TextView tvFindReying;
    @Bind(R.id.tv_find_reying_name)
    TextView tvFindReyingName;
    @Bind(R.id.iv_find_reying_icon2)
    ImageView ivFindReyingIcon2;
    @Bind(R.id.iv_find_reying_icon)
    ImageView ivFindReyingIcon;
    @Bind(R.id.tv_find_qidai)
    TextView tvFindQidai;
    @Bind(R.id.tv_find_qidai_name)
    TextView tvFindQidaiName;
    @Bind(R.id.iv_find_qidai_icon2)
    ImageView ivFindQidaiIcon2;
    @Bind(R.id.iv_find_qidai_icon)
    ImageView ivFindQidaiIcon;
    @Bind(R.id.tv_find_haiwai)
    TextView tvFindHaiwai;
    @Bind(R.id.tv_find_haiwai_name)
    TextView tvFindHaiwaiName;
    @Bind(R.id.iv_find_haiwai_icon2)
    ImageView ivFindHaiwaiIcon2;
    @Bind(R.id.iv_find_haiwai_icon)
    ImageView ivFindHaiwaiIcon;
    @Bind(R.id.tv_find_top)
    TextView tvFindTop;
    @Bind(R.id.tv_find_top_name)
    TextView tvFindTopName;
    @Bind(R.id.iv_find_top_icon2)
    ImageView ivFindTopIcon2;
    @Bind(R.id.iv_find_top_icon)
    ImageView ivFindTopIcon;
//    @Bind(R.id.ll_find_jiangxiang)
//    LinearLayout llFindJiangxiang;

    @Bind(R.id.rl_find_reying)
    RelativeLayout rlFindReying;
    @Bind(R.id.rl_find_qidai)
    RelativeLayout rlFindQidai;
    @Bind(R.id.rl_find_haiwai)
    RelativeLayout rlFindHaiwai;
    @Bind(R.id.rl_find_TOP)
    RelativeLayout rlFindTOP;
    @Bind(R.id.ll_find_quanqiujiam)
    LinearLayout llFindQuanqiujiam;

    private List<JiangXiangPicBean.DataBean> picData;

    private JiangXiangPicAdapter picAdapter;

    //加载全球将的数据
//    private QuanQiuJiangBean quanQiuJiangBean;


    //    private List<FindTopButtonBean.DataBean.TagListBean> typeList;
//    private List<FindTopButtonBean.DataBean.TagListBean> cityList;
//    private List<FindTopButtonBean.DataBean.TagListBean> yearList;


    @Override
    protected RequestParams getParams() {
        return null;
    }

    @Override
    protected String getUrl() {
        return Constants.FIND_JIANG_PIC;
    }

    @Override
    protected void initData(String content) {

//        initMoreData();

        //recycleView
        picAdapter = new JiangXiangPicAdapter(mContext);
        recycleviewJiang.setAdapter(picAdapter);
        recycleviewJiang.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        LogUtil.e("button" + content);
        prassJangPic(content);

    }

//    private void initMoreData() {
//        OkHttpUtils
//                .get()
//                .url(Constants.FID_QUANQIUJIANG)
//                .id(100)//下面回调的id
//                .build()
//                .execute(new JiangCallbackListView());
//    }

//    public class JiangCallbackListView extends StringCallback {
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
//                praseJiangData(response);
//            }
//
//        }
//    }

//    private void praseJiangData(String json) {
//        Gson gson = new Gson();
//        quanQiuJiangBean = gson.fromJson(json, QuanQiuJiangBean.class);
//
//    }

    private void prassJangPic(String json) {
        Gson gson = new Gson();
        JiangXiangPicBean jiangXiangPicBean = gson.fromJson(json, JiangXiangPicBean.class);

        picData = jiangXiangPicBean.getData();

        LogUtil.e("解析完成" + picData.toString());

        //刷新输配器
        if(picAdapter!=null){
            picAdapter.refresh(picData);
        }


    }

//    private void prassTopButton(String json) {
//        JSONObject jsonObject = JSON.parseObject(json);
//
//        //http://api.maoyan.com/mmdb/search/movie/tag/types.json?token=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome
//        String data = jsonObject.getString("data");
//
//        List<FindTopButtonBean.DataBean> dataBeen = JSON.parseArray(data, FindTopButtonBean.DataBean.class);
//
//        typeList = dataBeen.get(0).getTagList();
//        cityList = dataBeen.get(1).getTagList();
//        yearList = dataBeen.get(2).getTagList();
//
//
//    }

    @Override
    protected void initTitle() {

        //类型
        for (int i = 0; i < type.length; i++) {
            LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lineLp.setMargins(UIUtils.dp2px(10), 0, 0, 0);

            TextView textView = (TextView) View.inflate(mContext, R.layout.tv_find_mode, null);
            textView.setText(type[i]);
            llFindType.addView(textView, lineLp);
        }

        //地区
        for (int i = 0; i < address.length; i++) {
            LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lineLp.setMargins(UIUtils.dp2px(10), 0, 0, 0);

            TextView textView = (TextView) View.inflate(mContext, R.layout.tv_find_mode, null);
            textView.setText(address[i]);
            llFindAddress.addView(textView, lineLp);
        }

        //年份
        for (int i = 0; i < year.length; i++) {
            LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lineLp.setMargins(UIUtils.dp2px(10), 0, 0, 0);

            TextView textView = (TextView) View.inflate(mContext, R.layout.tv_find_mode, null);
            textView.setText(year[i]);
            llFindYear.addView(textView, lineLp);
        }


        initListener();

    }

    private void initListener() {

        //搜索框
        tvTitleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(mContext, MoveSearchActivity.class));
            }
        });

        //热映口碑
        rlFindReying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "热映口碑", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, FindHotActivity.class);
                intent.putExtra("title","热映口碑榜单");
                intent.putExtra("json_url",Constants.FIND_HOT_KOUBEI);
                getActivity().startActivity(intent);

            }
        });

        //最受期待
        rlFindQidai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "最受期待", Toast.LENGTH_SHORT).show();
            }
        });

        //海外电影
        rlFindHaiwai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "海外电影", Toast.LENGTH_SHORT).show();
            }
        });

        //top100
        rlFindTOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "top100", Toast.LENGTH_SHORT).show();
            }
        });

        //最后的全球电影奖

        llFindQuanqiujiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, QuanQiuJiangActivity.class);
//                if(quanQiuJiangBean!=null){
//                    intent.putExtra("dataJiang",quanQiuJiangBean);
//                }
                startActivity(intent);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_findmoves;
    }


}
