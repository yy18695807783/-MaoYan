package com.yanyin.maoyan.move.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.bean.WaiteBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.yanyin.maoyan.R.id.tv_waite_yugao_desc;
import static com.yanyin.maoyan.R.id.tv_waite_yugao_name;

/**
 * Created by 颜银 on 2016/12/2.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class YuGaoRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<WaiteBean.DataBean.ComingBean> mComingBeanList;

    public YuGaoRecycleViewAdapter(Context context, List<WaiteBean.DataBean.ComingBean> comingBeanList) {
        this.mContext = context;
        this.mComingBeanList = comingBeanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(mContext, R.layout.item_waite_yushou, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        WaiteBean.DataBean.ComingBean comingBean = mComingBeanList.get(position);

        //装配数据
        myViewHolder.tvWaiteYugaoDesc.setText(comingBean.getVideoName() + comingBean.getPubDesc());
        myViewHolder.tvWaiteYugaoName.setText(comingBean.getNm());

        String imgUrl = comingBean.getImg();
        imgUrl = "http://p0.meituan.net/80.120" + imgUrl.substring(25);
        Picasso.with(mContext).load(imgUrl).into(myViewHolder.ivWaiteYugaoIcon);

    }

    @Override
    public int getItemCount() {
        return mComingBeanList == null ? 0 : mComingBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_waite_yugao_icon)
        ImageView ivWaiteYugaoIcon;
        @Bind(tv_waite_yugao_name)
        TextView tvWaiteYugaoName;
        @Bind(tv_waite_yugao_desc)
        TextView tvWaiteYugaoDesc;
        @Bind(R.id.item_wrate_yugao)
        RelativeLayout itemWrateYugao;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
