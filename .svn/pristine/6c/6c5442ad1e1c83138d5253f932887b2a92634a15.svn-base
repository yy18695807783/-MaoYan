package com.yanyin.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.MainActivity;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.bean.WelcomeBean;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class WelcomeActivity extends Activity {

    @Bind(R.id.iv_welcome_loader)
    ImageView ivWelcomeLoader;
    @Bind(R.id.btn_welcome)
    Button btnWelcome;
    @Bind(R.id.iv_welcome)
    ImageView ivWelcome;
    @Bind(R.id.activity_welcome)
    FrameLayout activityWelcome;

    //欢迎界面持续时间
    private int duration;
    //欢迎界面图片url
    private String pic;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            switch (msg.what){
                case 0://加载图片完成

                    //隐藏欢迎界面
                    ivWelcome.setVisibility(View.GONE);
                    //显示网络加载的欢迎图片
                    ivWelcomeLoader.setVisibility(View.VISIBLE);
                    Picasso.with(WelcomeActivity.this).load(pic).into(ivWelcomeLoader);
                    //给Button设置监听
                    btnWelcome.setVisibility(View.VISIBLE);

                    //发送延迟消息，自动挑战到主页面
                    sendEmptyMessageDelayed(1,duration);
                    break;
                case 1:

                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    handler.removeCallbacksAndMessages(null);
                    finish();

                    break;
            }

        }
    };

    @OnClick(R.id.btn_welcome)
    public void setBtn(View view){
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        handler.removeCallbacksAndMessages(null);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.WELCOME_ICON)
                .id(100)//下面回调的id
                .build()
                .execute(new MyStringCallback());
    }

    public class MyStringCallback extends StringCallback {


        @Override
        public void onError(Call call, Exception e, int id) {
            Log.e("TAG", "联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功" + response);
            parseJson(response);
        }
    }

    private void parseJson(String json) {
        if(!TextUtils.isEmpty(json)){
            JSONObject jsonObject = JSON.parseObject(json);

            String posters = jsonObject.getString("posters");
            LogUtil.e("posters-->" + posters.toString());

            List<WelcomeBean.PostersBean> postersBeen = JSON.parseArray(posters, WelcomeBean.PostersBean.class);
            LogUtil.e("postersBeen-->" + postersBeen.toString());

            duration = postersBeen.get(0).getDuration();
            pic = postersBeen.get(0).getPic();

            //睡1秒显示主页
            SystemClock.sleep(1000);

            handler.sendEmptyMessage(0);

        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}

