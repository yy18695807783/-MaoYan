package com.yanyin.maoyan.move.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.bean.QuanQiuJiangBean;

import java.util.List;

/**
 * Created by 颜银 on 2016/12/6.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class QuanQiuJiangTextAdapter extends BaseAdapter {

    private Context mContext;
    private List<QuanQiuJiangBean.DataBean.FestivalsBean> mFestivals;

    public QuanQiuJiangTextAdapter(List<QuanQiuJiangBean.DataBean.FestivalsBean> festivals, Context context) {
        this.mContext = context;
        this.mFestivals = festivals;


    }

    @Override
    public int getCount() {
        return mFestivals == null?0:mFestivals.size();
    }

    @Override
    public Object getItem(int position) {
        return mFestivals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_jiangname,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        QuanQiuJiangBean.DataBean.FestivalsBean festivalsBean = mFestivals.get(position);

        viewHolder.tv_name.setText(festivalsBean.getFestivalName());

        return convertView;
    }

    class ViewHolder{
        TextView tv_name;
    }
}
