package com.yanyin.maoyan.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yanyin.maoyan.R;
import com.yanyin.maoyan.ui.FlowLayout;
import com.yanyin.maoyan.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MoveSearchActivity extends Activity {

    @Bind(R.id.tv_title_search)
    EditText tvTitleSearch;
    @Bind(R.id.tv_search_cancel)
    TextView tvSearchCancel;
    @Bind(R.id.activity_move_search)
    LinearLayout activityMoveSearch;
    @Bind(R.id.flow_search)
    FlowLayout flowSearch;

    @Bind(R.id.search_zhaopian)
    TextView searchZhaopian;
    @Bind(R.id.search_yingren)
    TextView searchYingren;
    @Bind(R.id.search_yingyuan)
    TextView searchYingyuan;
    @Bind(R.id.search_news)
    TextView searchNews;

    private String[] datas = new String[]{"新木乃伊", "银河护卫队", "你的名字", "摆渡人", "奇异博士", "纯洁心灵·逐梦演艺圈"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_search);
        ButterKnife.bind(this);


        initData();

        initListener();
    }

    private void initData() {


        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for (int i = 0; i < datas.length; i++) {
            TextView view = new TextView(this);
            view.setText(datas[i]);
            view.setTextSize(UIUtils.dp2px(7));
            view.setTextColor(Color.BLACK);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.flow_text_style));
            flowSearch.addView(view, lp);
        }


    }

    private void initListener() {
        //取消按钮
        tvSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //分类照片
        searchZhaopian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoveSearchActivity.this, "分类照片", Toast.LENGTH_SHORT).show();
            }
        })
        ;

        //找影人
        searchYingren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoveSearchActivity.this, "找影人", Toast.LENGTH_SHORT).show();
            }
        });

        //找影院
        searchYingyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoveSearchActivity.this, "找影院", Toast.LENGTH_SHORT).show();
            }
        });

        //新闻
        searchNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoveSearchActivity.this, "新闻", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
