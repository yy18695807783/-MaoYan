package com.yanyin.maoyan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yanyin.maoyan.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class JieCaoActivity extends AppCompatActivity {

    @Bind(R.id.tv_url)
    TextView tvUrl;
    @Bind(R.id.videocontroller)
    JCVideoPlayerStandard jcVideoPlayerStandard;


    private String title;
    private String moveUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_cao);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        moveUrl = intent.getStringExtra("move");

        tvUrl.setText(title);

        initData();

    }

    private void initData() {
//        JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller);
//        videocontroller.setUp(moveUrl, title);
//        videocontroller.ivThumb.setThumbInCustomProject("视频/MP3缩略图地址");
//        videocontroller.ivThumb.set;

//        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videocontroller);
        jcVideoPlayerStandard.setUp(moveUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, title);
//        jcVideoPlayerStandard.thumbImageView.setThumbInCustomProject("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");


    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }
}
