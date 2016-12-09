package com.yanyin.maoyan.activity.adapter;

import android.content.Context;

import com.yanyin.maoyan.bean.MeiTuanBean;
import com.yanyin.maoyan.utils.CommonAdapter;
import com.yanyin.maoyan.utils.ViewHolder;

import java.util.List;

/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class MeituanAdapter extends CommonAdapter<MeiTuanBean> {
    public MeituanAdapter(Context context, int layoutId, List<MeiTuanBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, final MeiTuanBean cityBean) {
        holder.setText(com.yanyin.maoyan.R.id.tvCity, cityBean.getCity());
    }
}