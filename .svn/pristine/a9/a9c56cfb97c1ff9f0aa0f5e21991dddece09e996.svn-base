package com.yanyin.maoyan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yanyin.maoyan.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FindCinemaActivity extends Activity {

    @Bind(R.id.tv_title_search_cinema)
    EditText tvTitleSearchCinema;
    @Bind(R.id.tv_search_cancel)
    TextView tvSearchCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_cinema);
        ButterKnife.bind(this);



        initListener();
    }

    private void initListener() {

        tvSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
