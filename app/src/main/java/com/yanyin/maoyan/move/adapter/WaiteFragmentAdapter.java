package com.yanyin.maoyan.move.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.bean.WaiteBean;
import com.yanyin.maoyan.utils.LogUtil;

import java.util.List;

/**
 * Created by 颜银 on 2016/12/1.
 * QQ:443098360
 * 微信：y443098360
 * 作用：待映界面的Adapter
 */

public class WaiteFragmentAdapter extends BaseAdapter {

    private Context mContext;
    private List<WaiteBean.DataBean.ComingBean> mComingBeanList;

    public WaiteFragmentAdapter(Context context, List<WaiteBean.DataBean.ComingBean> comingBeanList) {
        this.mContext = context;
        this.mComingBeanList = comingBeanList;
    }

    @Override
    public int getCount() {
        return mComingBeanList == null ? 0 : mComingBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mComingBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_waite_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_waite_icon = (ImageView) convertView.findViewById(R.id.iv_waite_icon);
            viewHolder.tv_waite_nm = (TextView) convertView.findViewById(R.id.tv_waite_nm);
            viewHolder.tv_waite_time = (TextView) convertView.findViewById(R.id.tv_sticky_header_view);
            viewHolder.tv_waite_3d = (TextView) convertView.findViewById(R.id.tv_waite_3d);
            viewHolder.tv_waite_xiangkan_number = (TextView) convertView.findViewById(R.id.tv_waite_xiangkan_number);
            viewHolder.tv_waite_xiangkan = (TextView) convertView.findViewById(R.id.tv_waite_xiangkan);
            viewHolder.tv_waite_zhuanye = (TextView) convertView.findViewById(R.id.tv_waite_zhuanye);
            viewHolder.tv_waite_zhuanye_number = (TextView) convertView.findViewById(R.id.tv_waite_zhuanye_number);
            viewHolder.tv_waite_scm = (TextView) convertView.findViewById(R.id.tv_waite_scm);
            viewHolder.tv_waite_desc = (TextView) convertView.findViewById(R.id.tv_waite_desc);
            viewHolder.btn_waite_yuding = (Button) convertView.findViewById(R.id.btn_waite_yuding);
            viewHolder.tv_waite_zhuanti1 = (TextView) convertView.findViewById(R.id.tv_waite_zhuanti1);
            viewHolder.tv_waite_zhuanti2 = (TextView) convertView.findViewById(R.id.tv_waite_zhuanti2);
            viewHolder.rl_waite_zhuanti1 = (RelativeLayout) convertView.findViewById(R.id.rl_waite_zhuanti1);
            viewHolder.rl_waite_zhuanti2 = (RelativeLayout) convertView.findViewById(R.id.rl_waite_zhuanti2);
            viewHolder.ll_waite_item = (LinearLayout) convertView.findViewById(R.id.ll_waite_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final WaiteBean.DataBean.ComingBean comingBean = mComingBeanList.get(position);

        //设置监听---预售按钮
        viewHolder.btn_waite_yuding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onsetWaiteAdapterItemListener!=null){
                    onsetWaiteAdapterItemListener.onButtonClick(v,comingBean);
                }
            }
        });

        //设置监听---整条按钮
        viewHolder.ll_waite_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onsetWaiteAdapterItemListener!=null){
                    onsetWaiteAdapterItemListener.onItemClick(v,comingBean);
                }
            }
        });

        //设置监听---图片按钮
        viewHolder.iv_waite_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onsetWaiteAdapterItemListener!=null){
                    onsetWaiteAdapterItemListener.onPictureClick(v,comingBean);
                }
            }
        });


        //播放时间
        viewHolder.tv_waite_time.setText(comingBean.getComingTitle());
        //判断重复的不显示
        if (position > 0) {
            //上一个时间
            String perTime = mComingBeanList.get(position - 1).getComingTitle();
            //当前时间
            String nowTime = mComingBeanList.get(position).getComingTitle();
            if (perTime.equals(nowTime)) {//和上一个相等，隐藏
                viewHolder.tv_waite_time.setVisibility(View.GONE);
            } else {
                viewHolder.tv_waite_time.setVisibility(View.VISIBLE);
            }

        }

        //专题
        if (position == 0) {
            viewHolder.tv_waite_time.setVisibility(View.VISIBLE);
//            viewHolder.rl_waite_zhuanti1.setVisibility(View.VISIBLE);
//            viewHolder.rl_waite_zhuanti2.setVisibility(View.VISIBLE);
//
//            viewHolder.tv_waite_zhuanti1.setText(comingBean.getHeadLinesVO().get(0).getTitle());
//            viewHolder.tv_waite_zhuanti2.setText(comingBean.getHeadLinesVO().get(1).getTitle());

            //先影藏
            viewHolder.rl_waite_zhuanti1.setVisibility(View.GONE);
            viewHolder.rl_waite_zhuanti2.setVisibility(View.GONE);
        } else {
            viewHolder.rl_waite_zhuanti1.setVisibility(View.GONE);
            viewHolder.rl_waite_zhuanti2.setVisibility(View.GONE);
        }

        //显示描述
        viewHolder.tv_waite_desc.setText(comingBean.getDesc());

        //显示主演
        viewHolder.tv_waite_scm.setText(comingBean.getScm());

        //判断是显示专业还是多少人看
        double proScore = comingBean.getProScore();
        if (proScore == 0) {//显示多少人看
            viewHolder.tv_waite_xiangkan_number.setVisibility(View.VISIBLE);
            viewHolder.tv_waite_xiangkan_number.setText(comingBean.getWish() + "");
            viewHolder.tv_waite_xiangkan.setVisibility(View.VISIBLE);
            viewHolder.tv_waite_zhuanye.setVisibility(View.GONE);
            viewHolder.tv_waite_zhuanye_number.setVisibility(View.GONE);
        } else {
            viewHolder.tv_waite_zhuanye.setVisibility(View.VISIBLE);
            viewHolder.tv_waite_zhuanye_number.setVisibility(View.VISIBLE);
            viewHolder.tv_waite_zhuanye_number.setText(comingBean.getProScore() + "");
            viewHolder.tv_waite_xiangkan_number.setVisibility(View.GONE);
            viewHolder.tv_waite_xiangkan.setVisibility(View.GONE);
        }

        //判断是否是3D
        boolean contains = comingBean.getVer().contains("3D");
        if (contains) {
            viewHolder.tv_waite_3d.setVisibility(View.VISIBLE);
        } else {
            viewHolder.tv_waite_3d.setVisibility(View.GONE);
        }

        //名字
        viewHolder.tv_waite_nm.setText(comingBean.getNm());

        //图片
        String imgUrl = comingBean.getImg();
        LogUtil.e("111---------------" + imgUrl.substring(25));
        imgUrl = "http://p0.meituan.net/80.120" + imgUrl.substring(25);
        Picasso.with(mContext).load(imgUrl).into(viewHolder.iv_waite_icon);


        return convertView;
    }

    class ViewHolder {
        TextView tv_waite_time;
        ImageView iv_waite_icon;
        TextView tv_waite_nm;
        TextView tv_waite_3d;
        TextView tv_waite_xiangkan_number;
        TextView tv_waite_xiangkan;
        TextView tv_waite_zhuanye;
        TextView tv_waite_zhuanye_number;
        TextView tv_waite_scm;
        TextView tv_waite_desc;
        Button btn_waite_yuding;
        TextView tv_waite_zhuanti1;
        TextView tv_waite_zhuanti2;
        RelativeLayout rl_waite_zhuanti1;
        RelativeLayout rl_waite_zhuanti2;
        LinearLayout ll_waite_item;

    }

    /**
     * 接口的生明
     */
    private OnsetWaiteAdapterItemListener onsetWaiteAdapterItemListener;

    /**
     * 接口的回调方法
     */
    public interface OnsetWaiteAdapterItemListener {


        //图片的点击回调方法
        void onPictureClick(View v, WaiteBean.DataBean.ComingBean comingBean);

        //预售点击监听
        void onButtonClick(View v, WaiteBean.DataBean.ComingBean comingBean);

        //整条的点击监听
        void onItemClick(View v, WaiteBean.DataBean.ComingBean comingBean);

    }

    /**
     * 设置监听的方法
     *
     * @param onsetWaiteAdapterItemListener
     */
    public void setOnsetWaiteAdapterItemListener(OnsetWaiteAdapterItemListener onsetWaiteAdapterItemListener) {
        this.onsetWaiteAdapterItemListener = onsetWaiteAdapterItemListener;
    }
}
