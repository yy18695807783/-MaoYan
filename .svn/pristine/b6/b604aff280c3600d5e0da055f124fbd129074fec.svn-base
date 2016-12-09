package com.yanyin.maoyan.cinema.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanyin.maoyan.R;
import com.yanyin.maoyan.cinema.bean.QuYuBean;
import com.yanyin.maoyan.utils.LogUtil;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 颜银 on 2016/12/6.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class QuYuAdater extends BaseAdapter {

    private Context mContext;
//    private CinemaBean.DataBean mData;
    private ArrayList<QuYuBean> quYuBeanList;

    public QuYuAdater(Context context){
        this.mContext = context;
        quYuBeanList = new ArrayList<>();
    }

//    public QuYuAdater(Context context,String[] diqu) {
//        this.mContext = context;
////        this.mData = data;
//        quYuBeanList = new ArrayList<>();
//
//        //组装数据
//        for (int i = 0; i < diqu.length; i++) {
//            String name = diqu[i];
//            int size = new Random().nextInt(50);
//            LogUtil.e("地址 :" +  name + size);
//
//            quYuBeanList.add(new QuYuBean(name, size));
//        }
//
//
//    }


    public void refresh(String[] diqu1){
        ArrayList<QuYuBean> quYuBeanLists = new ArrayList<>();

        for (int i = 0; i < diqu1.length; i++) {
            String name = diqu1[i];
            int size = new Random().nextInt(50);
            LogUtil.e("地址 :" +  name + size);

            quYuBeanLists.add(new QuYuBean(name, size));
        }
        if(quYuBeanList!=null&&quYuBeanList.size()>0){
            quYuBeanList.removeAll(quYuBeanList);
        }

        quYuBeanList.addAll(0,quYuBeanLists);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return quYuBeanList == null ? 0 : quYuBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return quYuBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public int selectIndex;



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
//            convertView = View.inflate(mContext, R.layout.item_quyu, null);
            convertView = LayoutInflater.from(mContext).inflate( R.layout.item_quyu,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.quyu_diqu = (TextView) convertView.findViewById(R.id.quyu_diqu);
            viewHolder.quyu_size = (TextView) convertView.findViewById(R.id.quyu_size);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        QuYuBean quYuBean = quYuBeanList.get(position);

        viewHolder.quyu_diqu.setText(quYuBean.name);
        viewHolder.quyu_size.setText(quYuBean.size + "");


        if(selectIndex == position){
            convertView.setBackgroundColor(Color.argb(255,255,204,255));
        }else{
            convertView.setBackgroundColor(Color.argb(255,242,242,242));
        }



        return convertView;
    }

    class ViewHolder {
        TextView quyu_diqu;
        TextView quyu_size;

    }
}
