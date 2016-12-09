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
import com.yanyin.maoyan.move.bean.WaiteYuGaoBean;
import com.yanyin.maoyan.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 颜银 on 2016/12/1.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class WaiteYuGaoAdapter extends RecyclerView.Adapter<WaiteYuGaoAdapter.MyViewHolder> {

    private Context mContext;
    private List<WaiteYuGaoBean.DataBean> mDataZuiQiDai;


    public WaiteYuGaoAdapter(Context context) {
        this.mContext = context;
        mDataZuiQiDai = new ArrayList<>();
    }


    public void Refresh(List<WaiteYuGaoBean.DataBean> dataZuiQiDai) {

        mDataZuiQiDai.removeAll(null);
        mDataZuiQiDai.addAll(dataZuiQiDai);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(mContext, R.layout.item_waite_yushou, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = holder;

        final WaiteYuGaoBean.DataBean dataBean = mDataZuiQiDai.get(position);
        LogUtil.e("测试---->" + dataBean.getMovieName());
        //装配数据


        myViewHolder.tvWaiteYugaoDesc.setText(dataBean.getOriginName());
        myViewHolder.tvWaiteYugaoName.setText(dataBean.getMovieName());


        Picasso.with(mContext).load(dataBean.getImg()).into(myViewHolder.ivWaiteYugaoIcon);

        //整条点击监听
        myViewHolder.itemWrateYugao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onYuGaoItemClickListener != null) {
                    onYuGaoItemClickListener.onYuGaoItemClick(v, dataBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataZuiQiDai == null ? 0 : mDataZuiQiDai.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_waite_yugao_icon)
        ImageView ivWaiteYugaoIcon;
        @Bind(R.id.tv_waite_yugao_name)
        TextView tvWaiteYugaoName;
        @Bind(R.id.tv_waite_yugao_desc)
        TextView tvWaiteYugaoDesc;
        @Bind(R.id.item_wrate_yugao)
        RelativeLayout itemWrateYugao;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    private OnYuGaoItemClickListener onYuGaoItemClickListener;

    /**
     * 期待RecycleView的点击Item回调方法
     */
    public interface OnYuGaoItemClickListener {
        void onYuGaoItemClick(View v, WaiteYuGaoBean.DataBean dataBean);
    }

    /**
     * RecycleView的item的点击事件设置方法
     *
     * @param onYuGaoItemClickListener
     */
    public void setOnYuGaoItemClickListener(OnYuGaoItemClickListener onYuGaoItemClickListener) {
        this.onYuGaoItemClickListener = onYuGaoItemClickListener;
    }
}
