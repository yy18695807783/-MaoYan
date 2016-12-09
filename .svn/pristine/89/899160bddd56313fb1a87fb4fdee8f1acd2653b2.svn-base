package com.yanyin.maoyan.move.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.bean.FindHotBean;

import java.util.List;

/**
 * Created by 颜银 on 2016/12/7.
 * QQ:443098360
 * 微信：y443098360
 * 作用：热映口碑的适配器
 */

public class FindHotAdapter extends BaseAdapter {

    private Context mContext;
    private List<FindHotBean.DataBean.MoviesBean> movies;

    public FindHotAdapter(Context context, FindHotBean findHotBean) {
        this.mContext = context;
        movies = findHotBean.getData().getMovies();

    }

    @Override
    public int getCount() {
        return movies == null?0:movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_find_hot,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_hot_img = (ImageView) convertView.findViewById(R.id.iv_hot_img);
            viewHolder.tv_hot_nm = (TextView) convertView.findViewById(R.id.tv_hot_nm);
            viewHolder.tv_hot_sc = (TextView) convertView.findViewById(R.id.tv_hot_sc);
            viewHolder.tv_hot_star = (TextView) convertView.findViewById(R.id.tv_hot_star);
            viewHolder.tv_hot_pubDesc = (TextView) convertView.findViewById(R.id.tv_hot_pubDesc);
            viewHolder.cb_hot = (CheckBox) convertView.findViewById(R.id.cb_hot);
            viewHolder.tv_hot_number = (TextView) convertView.findViewById(R.id.tv_hot_number);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final FindHotBean.DataBean.MoviesBean moviesBean = movies.get(position);

        String imgUrl = moviesBean.getImg();
        imgUrl = "http://p0.meituan.net/80.120" + imgUrl.substring(25);
        Picasso.with(mContext).load(imgUrl).into(viewHolder.iv_hot_img);
        viewHolder.tv_hot_number.setText(position + "");
        viewHolder.tv_hot_nm.setText(moviesBean.getNm());
        viewHolder.tv_hot_sc.setText(moviesBean.getSc()+"");
        viewHolder.tv_hot_star.setText(moviesBean.getStar());
        viewHolder.tv_hot_pubDesc.setText(moviesBean.getPubDesc());

        viewHolder.iv_hot_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onMyItemClickListenerl!=null){
                    onMyItemClickListenerl.onItemClick(v,moviesBean);
                }
            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView iv_hot_img;
        TextView tv_hot_nm;
        TextView tv_hot_sc;
        TextView tv_hot_star;
        TextView tv_hot_pubDesc;
        CheckBox cb_hot;
        TextView tv_hot_number;

    }

    private OnMyItemClickListener onMyItemClickListenerl;

    public interface OnMyItemClickListener{
        void onItemClick(View v, FindHotBean.DataBean.MoviesBean moviesBean);
    }

    public void setOnMyItemClickListenerl(OnMyItemClickListener onMyItemClickListenerl) {
        this.onMyItemClickListenerl = onMyItemClickListenerl;
    }
}
