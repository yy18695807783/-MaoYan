package com.yanyin.maoyan.move.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.move.bean.WaiteBean;
import com.yanyin.maoyan.move.bean.WaiteYuGaoBean;
import com.yanyin.maoyan.move.bean.WaiteZuiQiDaiBean;
import com.yanyin.maoyan.utils.Constants;
import com.yanyin.maoyan.utils.LogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

import static com.yanyin.maoyan.R.id.rl_waite_zhuanti1;

/**
 * Created by 颜银 on 2016/12/2.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class WaiteRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;


    private Context mContext;
    private List<WaiteBean.DataBean.ComingBean> mComingBeanList;

    private WaiteYuGaoAdapter waiteYuGaoAdapter;

    private WaiteQiDaiAdapter waiteQiDaiAdapter;

    /**
     * 头部搜索
     */
    public static final int SOUSUOTOU = 0;

    /**
     * 预告片推存
     */
    public static final int YUGAO = 1;
    /**
     * 近期最受期待
     */
    public static final int ZUIQIDAI = 2;

    /**
     * listView
     */
    public static final int LISTVIEW = 3;

    //当前类型--默认第一种
    public int currentType = YUGAO;
    private LayoutInflater mLayoutInflater;


    public WaiteRecycleViewAdapter(Context context, List<WaiteBean.DataBean.ComingBean> comingBeanList) {
        this.mContext = context;
        this.mComingBeanList = comingBeanList;
        mLayoutInflater = LayoutInflater.from(mContext);
        initYuGaoData();
        initZuiQiDaiData();
    }


    //总共有多少个item
    @Override
    public int getItemCount() {
        return mComingBeanList.size() + 3;
    }

    /**
     * 得到类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (position) {

            case 0:
                currentType = SOUSUOTOU;
                break;
            case 1://预告片推存
                currentType = YUGAO;
                break;
            case 2://近期最受期待
                currentType = ZUIQIDAI;
                break;
            default: //listView
                currentType = LISTVIEW;
                break;
        }
        return currentType;
    }


    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType 当前类型
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SOUSUOTOU) {
            return new SouSuoViewHolder(mContext, mLayoutInflater.inflate(R.layout.title_search_normal, parent, false));
        } else if (viewType == YUGAO) {
            return new YuGaoViewHolder(mContext, mLayoutInflater.inflate(R.layout.yugao_waite_item, parent, false));
        } else if (viewType == ZUIQIDAI) {
            return new QiDaiViewHolder(mContext, mLayoutInflater.inflate(R.layout.qidai_waite_item, parent, false));
        } else if (viewType == LISTVIEW) {
            return new ShowLSViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_waite_listview, parent, false));
        }
        return null;
    }

    /**
     * 绑定数据的方法，相当于getView方法
     *
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == SOUSUOTOU) {
            SouSuoViewHolder souSuoViewHolder = (SouSuoViewHolder) holder;
            souSuoViewHolder.setData();

        } else if (getItemViewType(position) == YUGAO) {
            YuGaoViewHolder yuGaoViewHolder = (YuGaoViewHolder) holder;
            yuGaoViewHolder.setData();

            yuGaoViewHolder.itemView.setTag(HAS_STICKY_VIEW);

            yuGaoViewHolder.itemView.setContentDescription(yuGaoViewHolder.tvStickyHeaderView.getText());//设置顶部的一个itemm名字

        } else if (getItemViewType(position) == ZUIQIDAI) {
            QiDaiViewHolder qiDaiViewHolder = (QiDaiViewHolder) holder;
            qiDaiViewHolder.setData();

            qiDaiViewHolder.itemView.setTag(HAS_STICKY_VIEW);

            qiDaiViewHolder.itemView.setContentDescription(qiDaiViewHolder.tvStickyHeaderView.getText());//设置顶部的一个itemm名字

        } else if (getItemViewType(position) == LISTVIEW) {
            ShowLSViewHolder showLSViewHolder = (ShowLSViewHolder) holder;
            showLSViewHolder.setData(mComingBeanList, position - 3);



        }

    }


    //搜索头部
    class SouSuoViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.tv_title_search)
        TextView tvTitleSearch;

        public SouSuoViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setData() {

            //头部搜索点击监听
            tvTitleSearch.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (onsetWaiteAdapterItemListener != null) {
                        onsetWaiteAdapterItemListener.onTitleClick(v);
                    }
                }
            });
        }


    }

    //预售
    class YuGaoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_sticky_header_view)
        TextView tvStickyHeaderView;

        @Bind(R.id.rc_waite_yugao)
        RecyclerView rcWaiteYugao;

        private Context mContext;

        public YuGaoViewHolder(Context context, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mContext = context;

        }

        public void setData() {

            tvStickyHeaderView.setText("预告片推存");

            if (waiteYuGaoAdapter != null) {
                waiteYuGaoAdapter.notifyDataSetChanged();
            } else {
                waiteYuGaoAdapter = new WaiteYuGaoAdapter(mContext);
                rcWaiteYugao.setAdapter(waiteYuGaoAdapter);

                //设施RecycleView的管理器---横向  一排
                rcWaiteYugao.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

                //监听
                waiteYuGaoAdapter.setOnYuGaoItemClickListener(new WaiteYuGaoAdapter.OnYuGaoItemClickListener() {
                    @Override
                    public void onYuGaoItemClick(View v, WaiteYuGaoBean.DataBean dataBean) {
                        if (onsetWaiteAdapterItemListener != null) {
                            onsetWaiteAdapterItemListener.onYuGaoClick(v, dataBean);
                        }
                    }
                });
            }


        }
    }

    //期待
    class QiDaiViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_sticky_header_view)
        TextView tvStickyHeaderView;

        @Bind(R.id.rc_waite_qidai)
        RecyclerView rcWaiteQidai;

        private Context mContext;

        public QiDaiViewHolder(Context context, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mContext = context;
        }

        public void setData() {

            tvStickyHeaderView.setText("近期最受期待");

            if (waiteQiDaiAdapter != null) {
                waiteQiDaiAdapter.notifyDataSetChanged();
            } else {
                waiteQiDaiAdapter = new WaiteQiDaiAdapter(mContext);
                rcWaiteQidai.setAdapter(waiteQiDaiAdapter);

                //设施RecycleView的管理器---横向  一排
                rcWaiteQidai.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

                //没条监听
                waiteQiDaiAdapter.setOnQiDaiItemClickListener(new WaiteQiDaiAdapter.OnQiDaiItemClickListener() {
                    @Override
                    public void onQiDaiItemClick(View v, WaiteZuiQiDaiBean.DataBean.ComingBean comingBean) {
                        if (onsetWaiteAdapterItemListener != null) {
                            onsetWaiteAdapterItemListener.onQiDaiClick(v, comingBean);
                        }
                    }
                });
            }


        }
    }

    //本身
    class ShowLSViewHolder extends RecyclerView.ViewHolder {


//        @Bind(R.id.tv_waite_time)
//        TextView tvWaiteTime;
        @Bind(R.id.tv_sticky_header_view)
        TextView tvStickyHeaderView;


        @Bind(R.id.iv_waite_icon)
        ImageView ivWaiteIcon;
        @Bind(R.id.tv_waite_nm)
        TextView tvWaiteNm;
        @Bind(R.id.tv_waite_3d)
        TextView tvWaite3d;
        @Bind(R.id.tv_waite_ver)
        TextView tvWaiteVer;
        @Bind(R.id.tv_waite_xiangkan_number)
        TextView tvWaiteXiangkanNumber;
        @Bind(R.id.tv_waite_xiangkan)
        TextView tvWaiteXiangkan;
        @Bind(R.id.tv_waite_zhuanye)
        TextView tvWaiteZhuanye;
        @Bind(R.id.tv_waite_zhuanye_number)
        TextView tvWaiteZhuanyeNumber;
        @Bind(R.id.tv_waite_scm)
        TextView tvWaiteScm;
        @Bind(R.id.tv_waite_desc)
        TextView tvWaiteDesc;
        @Bind(R.id.btn_waite_yuding)
        Button btnWaiteYuding;
        @Bind(R.id.ll_waite_item)
        LinearLayout llWaiteItem;
        @Bind(R.id.btn_waite_zhuanti1)
        Button btnWaiteZhuanti1;
        @Bind(R.id.tv_waite_zhuanti1)
        TextView tvWaiteZhuanti1;
        @Bind(rl_waite_zhuanti1)
        RelativeLayout rlWaiteZhuanti1;
        @Bind(R.id.btn_waite_zhuanti2)
        Button btnWaiteZhuanti2;
        @Bind(R.id.tv_waite_zhuanti2)
        TextView tvWaiteZhuanti2;
        @Bind(R.id.rl_waite_zhuanti2)
        RelativeLayout rlWaiteZhuanti2;
        @Bind(R.id.ll_hot_item)
        LinearLayout llHotItem;

        private Context mContext;

        public ShowLSViewHolder(Context context, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mContext = context;

        }

        public void setData(List<WaiteBean.DataBean.ComingBean> comingBeanList, int position) {

            final WaiteBean.DataBean.ComingBean comingBean = comingBeanList.get(position);


            //设置监听---预售按钮
            btnWaiteYuding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onsetWaiteAdapterItemListener != null) {
                        onsetWaiteAdapterItemListener.onButtonClick(v, comingBean);
                    }
                }
            });

            //设置监听---整条按钮
            llWaiteItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onsetWaiteAdapterItemListener != null) {
                        onsetWaiteAdapterItemListener.onItemClick(v, comingBean);
                    }
                }
            });

            //设置监听---图片按钮
            ivWaiteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onsetWaiteAdapterItemListener != null) {
                        onsetWaiteAdapterItemListener.onPictureClick(v, comingBean);
                    }
                }
            });


            //播放时间
            tvStickyHeaderView.setText(comingBean.getComingTitle());
            //判断重复的不显示
            if (position > 0) {
                //上一个时间
                String perTime = mComingBeanList.get(position - 1).getComingTitle();
                //当前时间
                String nowTime = mComingBeanList.get(position).getComingTitle();
                if (perTime.equals(nowTime)) {//和上一个相等，隐藏
                    tvStickyHeaderView.setVisibility(View.GONE);
                    itemView.setTag(NONE_STICKY_VIEW);
                } else {
                    tvStickyHeaderView.setVisibility(View.VISIBLE);
                    itemView.setTag(HAS_STICKY_VIEW);
                }

            }

            //专题
            if (position == 0) {
                tvStickyHeaderView.setVisibility(View.VISIBLE);
//                itemView.setTag(FIRST_STICKY_VIEW);//写这个到下面的时候会不是往上推的显示
                itemView.setTag(HAS_STICKY_VIEW);

//            viewHolder.rl_waite_zhuanti1.setVisibility(View.VISIBLE);
//            viewHolder.rl_waite_zhuanti2.setVisibility(View.VISIBLE);
//
//            viewHolder.tv_waite_zhuanti1.setText(comingBean.getHeadLinesVO().get(0).getTitle());
//            viewHolder.tv_waite_zhuanti2.setText(comingBean.getHeadLinesVO().get(1).getTitle());

                //先影藏
                rlWaiteZhuanti1.setVisibility(View.GONE);
                rlWaiteZhuanti2.setVisibility(View.GONE);
            } else {
                rlWaiteZhuanti1.setVisibility(View.GONE);
                rlWaiteZhuanti2.setVisibility(View.GONE);
            }

            //------------------------------------------------悬浮窗
            itemView.setContentDescription(tvStickyHeaderView.getText());

            //显示描述
            tvWaiteDesc.setText(comingBean.getDesc());

            //显示主演
            tvWaiteScm.setText(comingBean.getScm());

            //判断是显示专业还是多少人看
            double proScore = comingBean.getProScore();
            if (proScore == 0) {//显示多少人看
                tvWaiteXiangkanNumber.setVisibility(View.VISIBLE);
                tvWaiteXiangkanNumber.setText(comingBean.getWish() + "");
                tvWaiteXiangkan.setVisibility(View.VISIBLE);
                tvWaiteZhuanye.setVisibility(View.GONE);
                tvWaiteZhuanyeNumber.setVisibility(View.GONE);
            } else {
                tvWaiteZhuanye.setVisibility(View.VISIBLE);
                tvWaiteZhuanyeNumber.setVisibility(View.VISIBLE);
                tvWaiteZhuanyeNumber.setText(comingBean.getProScore() + "");
                tvWaiteXiangkanNumber.setVisibility(View.GONE);
                tvWaiteXiangkan.setVisibility(View.GONE);
            }

            //判断是否是3D
            boolean contains = comingBean.getVer().contains("3D");
            if (contains) {
                tvWaite3d.setVisibility(View.VISIBLE);
            } else {
                tvWaite3d.setVisibility(View.GONE);
            }

            //名字
            tvWaiteNm.setText(comingBean.getNm());

            //图片
            String imgUrl = comingBean.getImg();
            LogUtil.e("111---------------" + imgUrl.substring(25));
            imgUrl = "http://p0.meituan.net/80.120" + imgUrl.substring(25);
            Picasso.with(mContext).load(imgUrl).into(ivWaiteIcon);

        }

    }


    private void initZuiQiDaiData() {
        OkHttpUtils
                .get()
                .url(Constants.WAITE_YUGAO)
                .id(100)//下面回调的id
                .build()
                .execute(new YuGaoCallbackListView());
    }

    //待映预告
    public class YuGaoCallbackListView extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.e("联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功" + response);
            if (!TextUtils.isEmpty(response)) {
                praseWaiteYuGaoBean(response);
            }

        }
    }

    private void praseWaiteYuGaoBean(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String data = jsonObject.getString("data");

        List<WaiteYuGaoBean.DataBean> dataYuGaoBeen = JSON.parseArray(data, WaiteYuGaoBean.DataBean.class);

        LogUtil.e("555555555555-----" + dataYuGaoBeen.size());

        if (dataYuGaoBeen != null && dataYuGaoBeen.size() > 0) {
            if (waiteYuGaoAdapter != null) {
                waiteYuGaoAdapter.Refresh(dataYuGaoBeen);
            }
        }
    }

    private void initYuGaoData() {
        OkHttpUtils
                .get()
                .url(Constants.WAITE_ZUIQIDAI)
                .id(100)//下面回调的id
                .build()
                .execute(new ZuiQiDaiCallbackListView());
    }


    //待映最期待
    public class ZuiQiDaiCallbackListView extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.e("联网失败" + e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("联网成功" + response);
            if (!TextUtils.isEmpty(response)) {
                praseWaiteZuiQiDaiBean(response);
            }

        }
    }

    private void praseWaiteZuiQiDaiBean(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String data = jsonObject.getString("data");

        WaiteZuiQiDaiBean.DataBean dataBean = JSON.parseObject(data, WaiteZuiQiDaiBean.DataBean.class);

        //最期待数据
        List<WaiteZuiQiDaiBean.DataBean.ComingBean> dataZuiQiDai = dataBean.getComing();
        if (dataZuiQiDai != null && dataZuiQiDai.size() > 0) {
            if (waiteQiDaiAdapter != null) {
                waiteQiDaiAdapter.Refresh(dataZuiQiDai);
            }
        }

    }


    /**
     * 接口的生明
     */
    private OnsetWaiteAdapterItemListener onsetWaiteAdapterItemListener;

    /**
     * 接口的回调方法
     */
    public interface OnsetWaiteAdapterItemListener {


        //预告点击回调方法
        void onYuGaoClick(View v, WaiteYuGaoBean.DataBean dataBean);

        //最期待
        void onQiDaiClick(View v, WaiteZuiQiDaiBean.DataBean.ComingBean comingBean);

        //图片的点击回调方法
        void onPictureClick(View v, WaiteBean.DataBean.ComingBean comingBean);

        //预售点击监听
        void onButtonClick(View v, WaiteBean.DataBean.ComingBean comingBean);

        //整条的点击监听
        void onItemClick(View v, WaiteBean.DataBean.ComingBean comingBean);

        //头部搜索点击监听
        void onTitleClick(View v);
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
