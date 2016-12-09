package com.yanyin.maoyan.move.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.bean.WaiteZuiQiDaiBean;
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

public class WaiteQiDaiAdapter extends RecyclerView.Adapter<WaiteQiDaiAdapter.MyViewHolder> {

    private Context mContext;
    private List<WaiteZuiQiDaiBean.DataBean.ComingBean> mDataZuiQiDai;


    public WaiteQiDaiAdapter(Context context) {
        this.mContext = context;
        mDataZuiQiDai = new ArrayList<>();
    }


    public void Refresh(List<WaiteZuiQiDaiBean.DataBean.ComingBean> dataZuiQiDai){

        mDataZuiQiDai.removeAll(null);
        mDataZuiQiDai.addAll(dataZuiQiDai);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(mContext, R.layout.item_waite_qidai, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = holder;

        final WaiteZuiQiDaiBean.DataBean.ComingBean comingBean = mDataZuiQiDai.get(position);
        LogUtil.e("测试---->" + comingBean.getRt());
        //装配数据
        String substring = "";
        String comingTitle = comingBean.getComingTitle();

        boolean daiding = comingTitle.contains("待定");
        if(daiding){//包含

            substring = comingTitle.substring(2);

        }else {//不包含

            boolean isContains = comingTitle.contains("年");
            if(isContains){//包含
                int start = comingTitle.indexOf('年');
                int end = comingTitle.indexOf('日');
                substring = "17"+comingTitle.substring(start, end+1);

            }else {//不包含
                int start = 0;
                int end = comingTitle.indexOf('日');
                substring = comingTitle.substring(start, end+1);
            }

        }

        myViewHolder.tvWaiteQidaiTime.setText(substring);
        myViewHolder.tvWaiteQidaiName.setText(comingBean.getNm());
        myViewHolder.tvWaiteQidaiNumber.setText(comingBean.getWish() + "");

        String imgUrl = comingBean.getImg();
        imgUrl = "http://p0.meituan.net/80.120" + imgUrl.substring(25);
        Picasso.with(mContext).load(imgUrl).into(myViewHolder.ivWaiteQidaiIcon);

        //整条点击监听
        myViewHolder.llWaite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onQiDaiItemClickListener!=null){
                    onQiDaiItemClickListener.onQiDaiItemClick(v,comingBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataZuiQiDai == null ? 0 : mDataZuiQiDai.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_waite_qidai_time)
        TextView tvWaiteQidaiTime;
        @Bind(R.id.iv_waite_qidai_icon)
        ImageView ivWaiteQidaiIcon;
        @Bind(R.id.iv_waite_qidai_xinghuan)
        CheckBox ivWaiteQidaiXinghuan;
        @Bind(R.id.tv_waite_qidai_name)
        TextView tvWaiteQidaiName;
        @Bind(R.id.tv_waite_qidai_number)
        TextView tvWaiteQidaiNumber;

        @Bind(R.id.ll_waite)
        LinearLayout llWaite;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    private OnQiDaiItemClickListener onQiDaiItemClickListener;

    /**
     * 期待RecycleView的点击Item回调方法
     */
    public interface OnQiDaiItemClickListener {
        void onQiDaiItemClick(View v, WaiteZuiQiDaiBean.DataBean.ComingBean comingBean);
    }

    /**
     * RecycleView的item的点击事件设置方法
     *
     * @param onQiDaiItemClickListener
     */
    public void setOnQiDaiItemClickListener(OnQiDaiItemClickListener onQiDaiItemClickListener) {
        this.onQiDaiItemClickListener = onQiDaiItemClickListener;
    }
}
