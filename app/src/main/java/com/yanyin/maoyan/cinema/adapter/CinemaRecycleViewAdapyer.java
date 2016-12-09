package com.yanyin.maoyan.cinema.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanyin.maoyan.R;
import com.yanyin.maoyan.cinema.bean.CinemaBean;

import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.yanyin.maoyan.R.id.tv_cinema_quyu;

/**
 * Created by 颜银 on 2016/12/5.
 * QQ:443098360
 * 微信：y443098360
 * 作用：影院界面的RecycleView适配器
 */

public class CinemaRecycleViewAdapyer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    //顶部长图
    private static final int STYLE_TOP = 0;

    //悬浮窗
    private static final int STYLE_FLOW = 1;

    //显示真正影院信息
    private static final int STYLE_BODAY = 2;

//    //当前状态
//    private static int cerrentItem = STYLE_BODAY;

    private Context mContext;
    private CinemaBean mCinemaBean;

    //默认先弄昌平区的
    private List<CinemaBean.DataBean.昌平区Bean> changping;


    public CinemaRecycleViewAdapyer(Context context, CinemaBean cinemaBean) {
        this.mContext = context;
        this.mCinemaBean = cinemaBean;
        this.changping = cinemaBean.getData().get昌平区();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == STYLE_TOP) {
            return new TopViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.item_cinema_top, parent, false));
        } else if (viewType == STYLE_FLOW) {
            return new ChooseViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.cinema_choose_by_type, parent, false));
        } else {//if(viewType == STYLE_BODAY)
            return new CinemaViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.item_cinema, parent, false));
        }

//        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == STYLE_TOP) {
            TopViewHolder topViewHolder = (TopViewHolder) holder;
            topViewHolder.setData();
        } else if (getItemViewType(position) == STYLE_FLOW) {
            ChooseViewHolder chooseViewHolder = (ChooseViewHolder) holder;

            chooseViewHolder.setData();
        } else if (getItemViewType(position) == STYLE_BODAY) {
            CinemaViewHolder cinemaViewHolder = (CinemaViewHolder) holder;
            cinemaViewHolder.setData(changping, position - 2);
        }
    }


    //顶部分类
    class TopViewHolder extends RecyclerView.ViewHolder {
        public TopViewHolder(Context mContext, View itemView) {
            super(itemView);
        }

        public void setData() {

        }
    }

    //中间悬浮的选择窗口
    class ChooseViewHolder extends RecyclerView.ViewHolder {

        @Bind(tv_cinema_quyu)
        TextView tvCinemaQuyu;
        @Bind(R.id.tv_cinema_zuijin)
        TextView tvCinemaZuijin;
        @Bind(R.id.tv_cinema_pinpai)
        TextView tvCinemaPinpai;
        @Bind(R.id.tv_cinema_fuwu)
        TextView tvCinemaFuwu;
        @Bind(R.id.ll_choose_addr)
        LinearLayout llChooseAddr;
//        @Bind(R.id.ll_cinema_xuanfuchuang)
        LinearLayout llCinemaXuanfuchuang;

//        @Bind(R.id.iv_cinema_quyu)
//        ImageView ivCinemaQuyu;
//        @Bind(R.id.ll_cinema_quyu)
//        LinearLayout llCinemaQuyu;
//        @Bind(R.id.iv_cinema_zuijin)
//        ImageView ivCinemaZuijin;
//        @Bind(R.id.ll_cinema_zuijin)
//        LinearLayout llCinemaZuijin;
//        @Bind(R.id.iv_cinema_pinpai)
//        ImageView ivCinemaPinpai;
//        @Bind(R.id.ll_cinema_pinpai)
//        LinearLayout llCinemaPinpai;
//        @Bind(R.id.iv_cinema_fuwu)
//        ImageView ivCinemaFuwu;
//        @Bind(R.id.ll_cinema_fuwu)
//        LinearLayout llCinemaFuwu;
//        @Bind(R.id.rb_quyu_shangquan)
//        RadioButton rbQuyuShangquan;
//        @Bind(R.id.rb_quyu_ditie)
//        RadioButton rbQuyuDitie;
//        @Bind(R.id.rg_quyu)
//        RadioGroup rgQuyu;
//        @Bind(R.id.listview_quyu)
//        ListView listviewQuyu;
//        @Bind(R.id.listview_quyu_content)
//        ListView listviewQuyuContent;
//        @Bind(R.id.ll_quyu_layout)
//        LinearLayout llQuyuLayout;

        public ChooseViewHolder(final Context mContext, View itemView) {
            super(itemView);

            llCinemaXuanfuchuang = (LinearLayout) itemView.findViewById(R.id.ll_cinema_xuanfuchuang);
//
//            llCinemaXuanfuchuang.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (onXuanFuZhuangClickListener != null) {
//                        onXuanFuZhuangClickListener.onXuanFuChuangClick(v);
//                    }
//
//
//                    Toast.makeText(mContext, "点击了", Toast.LENGTH_SHORT).show();
//                }
//            });

        }


        public void setData() {

        }
    }

    //影院
    class CinemaViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_cinema_nm)
        TextView tvCinemaNm;
        @Bind(R.id.tv_cinema_sellPrice)
        TextView tvCinemaSellPrice;
        @Bind(R.id.tv_cinema_addr)
        TextView tvCinemaAddr;
        @Bind(R.id.tv_cinema_distance)
        TextView tvCinemaDistance;

        public CinemaViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<CinemaBean.DataBean.昌平区Bean> changping, int rellPosition) {
            CinemaBean.DataBean.昌平区Bean changPingBean = changping.get(rellPosition);
            tvCinemaNm.setText(changPingBean.getNm());
            tvCinemaSellPrice.setText(changPingBean.getSellPrice() + "");
            tvCinemaAddr.setText(changPingBean.getAddr());
            tvCinemaDistance.setText(new Random().nextInt(50) + "km");

        }
    }


    @Override
    public int getItemCount() {
        return changping.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        int cerrentItem = -1;
        if (position == 0) {
            cerrentItem = STYLE_TOP;
        } else if (position == 1) {
            cerrentItem = STYLE_FLOW;
        } else {
            cerrentItem = STYLE_BODAY;
        }
        return cerrentItem;
    }


//    private OnXuanFuZhuangClickListener onXuanFuZhuangClickListener;
//
//    public interface OnXuanFuZhuangClickListener {
//        void onXuanFuChuangClick(View v);
//    }
//
//    public void setOnXuanFuZhuangClickListener(OnXuanFuZhuangClickListener onXuanFuZhuangClickListener) {
//        this.onXuanFuZhuangClickListener = onXuanFuZhuangClickListener;
//    }
}
