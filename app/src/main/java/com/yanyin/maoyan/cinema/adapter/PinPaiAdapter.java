package com.yanyin.maoyan.cinema.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanyin.maoyan.R;
import com.yanyin.maoyan.cinema.bean.PinPaiBean;
import com.yanyin.maoyan.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 颜银 on 2016/12/7.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class PinPaiAdapter extends BaseAdapter {

    private Context mContext;
    private List<PinPaiBean> mPinPaiBeen;

    public PinPaiAdapter(Context context) {
        this.mContext = context;

        mPinPaiBeen = new ArrayList<>();
    }

    public void refresh(String[] data) {
        ArrayList<PinPaiBean> pinPaiBean = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            String name = data[i];
            int size = new Random().nextInt(50);
            LogUtil.e("地址 :" + name + size);

            pinPaiBean.add(new PinPaiBean(name, size));
        }
        if (mPinPaiBeen != null && mPinPaiBeen.size() > 0) {
            mPinPaiBeen.removeAll(mPinPaiBeen);
        }
        mPinPaiBeen.addAll(0, pinPaiBean);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mPinPaiBeen == null ? 0 : mPinPaiBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mPinPaiBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_pinpai, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_pinpai_name = (TextView) convertView.findViewById(R.id.tv_pinpai_name);
            viewHolder.tv_pinpai_number = (TextView) convertView.findViewById(R.id.tv_pinpai_number);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PinPaiBean pinPaiBean = mPinPaiBeen.get(position);
        viewHolder.tv_pinpai_name.setText(pinPaiBean.getName());
        viewHolder.tv_pinpai_number.setText(pinPaiBean.getNumber() + "");

        return convertView;
    }

    class ViewHolder {
        TextView tv_pinpai_name;
        TextView tv_pinpai_number;
    }

}
