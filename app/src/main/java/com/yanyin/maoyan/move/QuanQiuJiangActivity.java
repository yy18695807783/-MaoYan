package com.yanyin.maoyan.move;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.adapter.QuanQiuJiangTextAdapter;
import com.yanyin.maoyan.move.bean.QuanQiuJiangBean;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class QuanQiuJiangActivity extends Activity {

    @Bind(R.id.iv_quanqiu_back)
    ImageView ivQuanqiuBack;
    @Bind(R.id.ll_jiang_type)
    LinearLayout llJiangType;

    @Bind(R.id.tv_jiang_title)
    TextView tvJiangTitle;
    @Bind(R.id.gridview_jiang)
    GridView gridviewJiang;


    private QuanQiuJiangBean quanQiuJiangBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_qiu_jiang);
        ButterKnife.bind(this);

        initData();

        setData();

        initListener();
    }


    private void initData() {
        OkHttpUtils
                .get()
                .url(Constants.FID_QUANQIUJIANG)
                .id(100)//下面回调的id
                .build()
                .execute(new JiangCallbackListView());
    }

    public class JiangCallbackListView extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.e("联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功" + response);
            if (!TextUtils.isEmpty(response)) {
                praseJiangData(response);
            }

        }
    }

    private void praseJiangData(String json) {
        Gson gson = new Gson();
        quanQiuJiangBean = gson.fromJson(json, QuanQiuJiangBean.class);

        LogUtil.e("quanQiuJiangBean" + quanQiuJiangBean.getData().size());

        setGlideViewData();

    }

    private void setGlideViewData() {
        List<QuanQiuJiangBean.DataBean.FestivalsBean> festivals = quanQiuJiangBean.getData().get(0).getFestivals();
        QuanQiuJiangTextAdapter adapter = new QuanQiuJiangTextAdapter(festivals, this);
        gridviewJiang.setAdapter(adapter);
//        GridLayoutManager gridLayoutManager =  new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false);


    }

    private void setData() {

//        int size = quanQiuJiangBean.getData().size();
//
//        for (int i = 0; i < size; i++) {
//
//            LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//
//            //布局
//            View inflate = View.inflate(this, R.layout.item_grild_view, null);
//            TextView textView = (TextView) inflate.findViewById(R.id.tv_jiang_title);
//            GridView gridview = (GridView) inflate.findViewById(R.id.gridview_jiang);
//
//            QuanQiuJiangBean.DataBean dataBean = quanQiuJiangBean.getData().get(i);
//
//            List<QuanQiuJiangBean.DataBean.FestivalsBean> festivals = dataBean.getFestivals();
//            String jiangName = dataBean.getRegion();
//
//
//            //设置title名字
//            textView.setText(jiangName);
//            //设置内容
//            QuanQiuJiangTextAdapter adapter = new QuanQiuJiangTextAdapter(festivals, this);
//            gridview.setAdapter(adapter);
//
//
//            llJiangType.addView(inflate, lineLp);
//
//        }


    }


    private void initListener() {
        ivQuanqiuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
