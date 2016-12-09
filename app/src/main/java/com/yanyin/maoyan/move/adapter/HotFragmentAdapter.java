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
import com.yanyin.maoyan.move.bean.ListViewBean;
import com.yanyin.maoyan.utils.LogUtil;

import java.util.List;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class HotFragmentAdapter extends BaseAdapter {

    private List<ListViewBean.DataBean.MoviesBean> movies;
    private Context mContext;

    public HotFragmentAdapter(List<ListViewBean.DataBean.MoviesBean> movies, Context context) {
        this.movies = movies;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return movies == null ? 0 : movies.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_hot_move, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_hot_3d = (TextView) convertView.findViewById(R.id.tv_hot_3d);
            viewHolder.tv_hot_ver = (TextView) convertView.findViewById(R.id.tv_hot_ver);
            viewHolder.iv_hot_icon = (ImageView) convertView.findViewById(R.id.iv_hot_icon);
            viewHolder.tv_hot_nm = (TextView) convertView.findViewById(R.id.tv_hot_nm);
            viewHolder.tv_hot_scm = (TextView) convertView.findViewById(R.id.tv_hot_scm);
            viewHolder.tv_hot_showInfo = (TextView) convertView.findViewById(R.id.tv_hot_showInfo);
            viewHolder.tv_hot_guanzhong = (TextView) convertView.findViewById(R.id.tv_hot_guanzhong);
            viewHolder.tv_hot_guanzhong_number = (TextView) convertView.findViewById(R.id.tv_hot_guanzhong_number);
            viewHolder.btn_hot_yuding = (Button) convertView.findViewById(R.id.btn_hot_yuding);
            viewHolder.btn_hot_dinggou = (Button) convertView.findViewById(R.id.btn_hot_dinggou);
            viewHolder.v_hot_guanzhong = convertView.findViewById(R.id.v_hot_guanzhong);
            viewHolder.rl_hot_zhuanti1 = (RelativeLayout) convertView.findViewById(R.id.rl_hot_zhuanti1);
            viewHolder.rl_hot_zhuanti2 = (RelativeLayout) convertView.findViewById(R.id.rl_hot_zhuanti2);
            viewHolder.ll_hot_item = (LinearLayout) convertView.findViewById(R.id.ll_hot_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        final ListViewBean.DataBean.MoviesBean moviesBean = movies.get(position);


        if (position == 0) {
            viewHolder.rl_hot_zhuanti1.setVisibility(View.VISIBLE);
            viewHolder.rl_hot_zhuanti2.setVisibility(View.VISIBLE);
        } else {
            viewHolder.rl_hot_zhuanti1.setVisibility(View.GONE);
            viewHolder.rl_hot_zhuanti2.setVisibility(View.GONE);
        }

        LogUtil.e("5555555555:" + moviesBean.getImg() + ",moviesBean.getNm():" + moviesBean.getNm());
        viewHolder.tv_hot_nm.setText(moviesBean.getNm());
        viewHolder.tv_hot_scm.setText(moviesBean.getScm());
        viewHolder.tv_hot_showInfo.setText(moviesBean.getShowInfo());
        viewHolder.tv_hot_3d.setVisibility(moviesBean.isValue3d() == true ? View.VISIBLE : View.GONE);
        viewHolder.tv_hot_ver.setVisibility(moviesBean.isImax() == true ? View.VISIBLE : View.GONE);

        int preSale = moviesBean.getPreSale();
        if (preSale==1) {//预定
            viewHolder.btn_hot_yuding.setVisibility(View.VISIBLE);
            viewHolder.btn_hot_dinggou.setVisibility(View.GONE);
        } else {
            viewHolder.btn_hot_yuding.setVisibility(View.GONE);
            viewHolder.btn_hot_dinggou.setVisibility(View.VISIBLE);
        }
        int sc = moviesBean.getSc();
        if (sc == 0) {
            viewHolder.tv_hot_guanzhong.setVisibility(View.GONE);
            viewHolder.tv_hot_guanzhong_number.setVisibility(View.GONE);
            viewHolder.v_hot_guanzhong.setVisibility(View.GONE);
        } else {
            viewHolder.tv_hot_guanzhong.setVisibility(View.VISIBLE);
            viewHolder.tv_hot_guanzhong_number.setVisibility(View.VISIBLE);
            viewHolder.tv_hot_guanzhong_number.setText(moviesBean.getSc() + "");
            viewHolder.v_hot_guanzhong.setVisibility(View.VISIBLE);
        }

        Picasso.with(mContext).load(moviesBean.getImg()).into(viewHolder.iv_hot_icon);


        //整条
        viewHolder.ll_hot_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onListViewItemClickListener != null) {
                    onListViewItemClickListener.onItemClick(v, moviesBean);
                }
            }
        });

        //图片
        viewHolder.iv_hot_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onListViewItemClickListener != null) {
                    onListViewItemClickListener.onPictureClick(v, moviesBean);
                }
            }
        });

        //两个button
        //预定
        viewHolder.btn_hot_yuding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onListViewItemClickListener != null) {
                    onListViewItemClickListener.onYuDingBtn(v, moviesBean);
                }
            }
        });
        //购票
        viewHolder.btn_hot_dinggou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onListViewItemClickListener != null) {
                    onListViewItemClickListener.onDingGouBtn(v, moviesBean);
                }
            }
        });


//       convertView.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               if(onListViewItemClickListener!=null){
//                   onListViewItemClickListener.onItemClick(position,moviesBean);
//               }
//           }
//       });

        return convertView;
    }

    class ViewHolder {
        ImageView iv_hot_icon;
        TextView tv_hot_nm;
        TextView tv_hot_scm;
        TextView tv_hot_showInfo;
        TextView tv_hot_3d;
        TextView tv_hot_ver;
        TextView tv_hot_guanzhong;
        TextView tv_hot_guanzhong_number;
        Button btn_hot_yuding;
        Button btn_hot_dinggou;
        View v_hot_guanzhong;
        RelativeLayout rl_hot_zhuanti1;
        RelativeLayout rl_hot_zhuanti2;
        LinearLayout ll_hot_item;
    }

    private OnListViewItemClickListener onListViewItemClickListener;

    /**
     * 监听回调
     */
    public interface OnListViewItemClickListener {
        //整条
        void onItemClick(View v, ListViewBean.DataBean.MoviesBean moviesBean);

        //图片
        void onPictureClick(View v, ListViewBean.DataBean.MoviesBean moviesBean);

        //预定
        void onYuDingBtn(View v, ListViewBean.DataBean.MoviesBean moviesBean);

        //购票
        void onDingGouBtn(View v, ListViewBean.DataBean.MoviesBean moviesBean);
    }

    /**
     * 点击的设置方法
     *
     * @param onListViewItemClickListener
     */
    public void setOnListViewItemClickListener(OnListViewItemClickListener onListViewItemClickListener) {
        this.onListViewItemClickListener = onListViewItemClickListener;
    }
}
