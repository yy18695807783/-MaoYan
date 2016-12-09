package com.yanyin.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.adapter.FindHotAdapter;
import com.yanyin.maoyan.move.bean.FindHotBean;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class FindHotActivity extends Activity {

    @Bind(R.id.iv_leftarr_back)
    ImageView ivLeftarrBack;
    @Bind(R.id.title_name)
    TextView titleName;
    @Bind(R.id.listView_find_hot)
    ListView listViewFindHot;
    private String json_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hot);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        json_url = intent.getStringExtra("json_url");
        titleName.setText(title);

        initData();
        initListener();
    }


    private void initData() {
        if(!TextUtils.isEmpty(json_url)){
           OkHttpUtils
                .get()
                .url(json_url)
                .id(100)//下面回调的id
                .build()
                .execute(new MyCallbackListView());
        }

    }

        public class MyCallbackListView extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.e("联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功---" + response);
            if (!TextUtils.isEmpty(response)) {
                praseData(response);
            }

        }
    }

    private void praseData(String json) {
        Gson gson = new Gson();
        final FindHotBean findHotBean = gson.fromJson(json, FindHotBean.class);
        String content = findHotBean.getData().getContent();
        String created = findHotBean.getData().getCreated();

        View inflate = View.inflate(this, R.layout.hot_list_head, null);
        TextView tv_head_created = (TextView) inflate.findViewById(R.id.tv_head_created);
        TextView tv_head_content = (TextView) inflate.findViewById(R.id.tv_head_content);
        tv_head_content.setText(content);
        tv_head_created.setText(created);

        listViewFindHot.addHeaderView(inflate);

        FindHotAdapter adapter = new FindHotAdapter(this,findHotBean);
        listViewFindHot.setAdapter(adapter);

        //listView的监听
//        listViewFindHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                FindHotBean.DataBean.MoviesBean moviesBean = findHotBean.getData().getMovies().get(position);
//
//                Intent intent = new Intent(FindHotActivity.this, WebViewActivity.class);
//                intent.putExtra("title",moviesBean.getNm());
//                intent.putExtra("web", Constants.MOVE_LISEVIEW_CLICK + moviesBean.getId() + Constants.MOVE_LISTVIEW_CLICK_LAST);
//                startActivity(intent);
//            }
//        });

        adapter.setOnMyItemClickListenerl(new FindHotAdapter.OnMyItemClickListener() {
            @Override
            public void onItemClick(View v, FindHotBean.DataBean.MoviesBean moviesBean) {
                Intent intent = new Intent(FindHotActivity.this, WebViewActivity.class);
                intent.putExtra("title",moviesBean.getNm());
                intent.putExtra("web", Constants.MOVE_LISEVIEW_CLICK + moviesBean.getId() + Constants.MOVE_LISTVIEW_CLICK_LAST);
                startActivity(intent);
            }
        });

    }


    private void initListener() {

        //返回
        ivLeftarrBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
