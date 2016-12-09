package com.yanyin.maoyan.cinema.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanyin.maoyan.R;

import java.util.ArrayList;

/**
 * Created by 颜银 on 2016/12/7.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class QuYuRightAdapter extends BaseAdapter {

    private Context mContent;

    private ArrayList<String> mDiTie;


    public QuYuRightAdapter(Context context){
        this.mContent = context;
        mDiTie = new ArrayList<>();
    }

//    public QuYuRightAdapter(Context context, String[] ditie) {
//        this.mContent = context;
//        mDiTie = new ArrayList<>();
//        for (int i = 0; i < ditie.length; i++) {
//            mDiTie.add(ditie[i]);
//        }
//
//    }

    public void refresh(String[] ditie1){

        ArrayList<String> diTies = new ArrayList<>();
        for (int i = 0; i < ditie1.length; i++) {
            diTies.add(ditie1[i]);
        }
        if(mDiTie!=null&&mDiTie.size()>0){
            mDiTie.removeAll(mDiTie);
        }
        mDiTie.addAll(0,diTies);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mDiTie == null ? 0 : mDiTie.size();
    }

    @Override
    public Object getItem(int position) {
        return mDiTie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(mContent, R.layout.item_ditie, null);
        TextView quyu_right_ditie = (TextView) convertView.findViewById(R.id.quyu_right_ditie);

        quyu_right_ditie.setText(mDiTie.get(position));

        return convertView;
    }


}
