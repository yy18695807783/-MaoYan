package com.yanyin.maoyan.move.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.bean.JiangXiangPicBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 颜银 on 2016/12/6.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class JiangXiangPicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<JiangXiangPicBean.DataBean> mPicData;

    public JiangXiangPicAdapter(Context context) {
        this.mContext = context;
        mPicData = new ArrayList<>();
    }

    public void refresh(List<JiangXiangPicBean.DataBean> picData) {
        mPicData.removeAll(null);
        mPicData.addAll(picData);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_find_jiang, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setData(mPicData, position);
    }

    @Override
    public int getItemCount() {
        return mPicData == null ? 0 : mPicData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_find_festivalName)
        TextView tvFindFestivalName;
        @Bind(R.id.tv_find_heldDate)
        TextView tvFindHeldDate;
        @Bind(R.id.iv_find_img)
        ImageView ivFindImg;
        @Bind(R.id.tv_find_movieName)
        TextView tvFindMovieName;
        @Bind(R.id.tv_find_prizeName)
        TextView tvFindPrizeName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<JiangXiangPicBean.DataBean> mPicData, int position) {

            JiangXiangPicBean.DataBean dataBean = mPicData.get(position);
            tvFindFestivalName.setText(dataBean.getFestivalName());
            String substring = dataBean.getHeldDate().substring(5);
            tvFindHeldDate.setText(substring);

            tvFindPrizeName.setText(dataBean.getPrizeName());

            String imgUrl = dataBean.getImg();
            imgUrl = "http://p0.meituan.net/80.120" + imgUrl.substring(25);

            Picasso.with(mContext).load(imgUrl).into(ivFindImg);
            tvFindMovieName.setText(dataBean.getMovieName());

        }
    }
}
