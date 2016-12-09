package com.yanyin.maoyan.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyin.maoyan.R;
import com.yanyin.maoyan.find.bean.FindBean;

import java.util.List;

/**
 * Created by 颜银 on 2016/12/5.
 * QQ:443098360
 * 微信：y443098360
 * 作用：发现界面的Adapter
 */

public class FindFragmentRecycleviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 样式分类头部
     */
    private static final int STYLE_TITLE = 0;


    /**
     * 样式分类主体  根据数据类型分类
     */
    private static final int STYLE_1 = 1;
    private static final int STYLE_2 = 2;
    private static final int STYLE_3 = 3;
    private static final int STYLE_4 = 4;
    private static final int STYLE_7 = 7;

    private Context mContext;
    private List<FindBean.DataBean.FeedsBean> mFeeds ;

    public FindFragmentRecycleviewAdapter(Context context, List<FindBean.DataBean.FeedsBean> feeds) {
        this.mContext = context;
        this.mFeeds = feeds;
    }

    //下拉刷新
    public void refresh(List<FindBean.DataBean.FeedsBean> feeds){
        if(mFeeds!=null&&mFeeds.size()>0){
            mFeeds.removeAll(null);
            mFeeds.addAll(feeds);
        }

        notifyDataSetChanged();
    }

    //加载更多
    public void addMoreData(List<FindBean.DataBean.FeedsBean> feeds){

        int po = mFeeds.size();

        mFeeds.addAll(po,feeds);
        notifyItemChanged(po);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int itemViewType = viewType;//当前itme是什么类型
        View convertView = null;

        switch (itemViewType) {
            case STYLE_TITLE://头部
//                convertView = View.inflate(mContext, R.layout.item_top, null);
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_top, parent, false);
                break;
            case STYLE_1://
//                convertView = View.inflate(mContext, R.layout.item_style1, null);
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_style1, parent, false);
                break;
            case STYLE_2://
//                convertView = View.inflate(mContext, R.layout.item_style2, null);
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_style2, parent, false);
                break;
            case STYLE_3://
//                convertView = View.inflate(mContext, R.layout.item_style3, null);
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_style3, parent, false);
                break;
            case STYLE_4://
//                convertView = View.inflate(mContext, R.layout.item_style4, null);
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_style4, parent, false);
                break;
            case STYLE_7://
//                convertView = View.inflate(mContext, R.layout.item_style7, null);
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_style7, parent, false);
                break;
        }

        return new MyViewHolder(convertView, itemViewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        bindShowData(position, getItemViewType(position), holder);
    }

    //绑定数据
    private void bindShowData(int position, int itemViewType, RecyclerView.ViewHolder holder) {
        MyViewHolder viewHolder = (MyViewHolder) holder;

        FindBean.DataBean.FeedsBean feedsBean = null;

        if (position > 0) {
            feedsBean = mFeeds.get(position - 1);
        }
        switch (itemViewType) {
            case STYLE_TITLE://头部4个
                Picasso.with(mContext).load("http://p0.meituan.net/movie/5acd468360744ef1358d2e7276e5c5504617.png").into(viewHolder.ivTopIcon1);
                Picasso.with(mContext).load("http://p1.meituan.net/movie/ba7ce8110dafc249dcd3db2978d96c032811.png").into(viewHolder.ivTopIcon2);
                Picasso.with(mContext).load("http://p1.meituan.net/movie/3596742a83baf834a80dcd86ae8749fe3356.png").into(viewHolder.ivTopIcon3);
                Picasso.with(mContext).load("http://p0.meituan.net/movie/91619295e2c79bc3cd755cec0ceaf47c3921.png").into(viewHolder.ivTopIcon4);
                break;

            case STYLE_1://
                viewHolder.tvStyle1Title.setText(feedsBean.getTitle());
                if (feedsBean.getUser() != null) {
                    viewHolder.tvStyle1NickName.setText(feedsBean.getUser().getNickName());
                } else {
                    viewHolder.tvStyle1NickName.setVisibility(View.INVISIBLE);
                }
                viewHolder.tvStyle1ViewCount.setText(feedsBean.getViewCount() + "");
                viewHolder.tvStyle1CommentCount.setText(feedsBean.getCommentCount() + "");

                break;
            case STYLE_2://
                viewHolder.tvStyle2Title.setText(feedsBean.getTitle());
                Picasso.with(mContext).load(feedsBean.getImages().get(0).getUrl()).into(viewHolder.ivStyle2Icon);
                if (feedsBean.getUser() != null) {
                    viewHolder.tvStyle2NickName.setText(feedsBean.getUser().getNickName());
                } else {
                    viewHolder.tvStyle2NickName.setVisibility(View.INVISIBLE);
                }
                viewHolder.tvStyle2ViewCount.setText(feedsBean.getViewCount() + "");
                viewHolder.tvStyle2CommentCount.setText(feedsBean.getCommentCount() + "");
                break;
            case STYLE_3://
                viewHolder.tvStyle3Title.setText(feedsBean.getTitle());
                Picasso.with(mContext).load(feedsBean.getImages().get(0).getUrl()).into(viewHolder.ivStyle3Icon1);
                Picasso.with(mContext).load(feedsBean.getImages().get(1).getUrl()).into(viewHolder.ivStyle3Icon2);
                Picasso.with(mContext).load(feedsBean.getImages().get(2).getUrl()).into(viewHolder.ivStyle3Icon3);
                if (feedsBean.getUser() != null) {
                    viewHolder.tvStyle3NickName.setText(feedsBean.getUser().getNickName());
                } else {
                    viewHolder.tvStyle3NickName.setVisibility(View.INVISIBLE);
                }
                viewHolder.tvStyle3ViewCount.setText(feedsBean.getViewCount() + "");
                viewHolder.tvStyle3CommentCount.setText(feedsBean.getCommentCount() + "");
                break;
            case STYLE_4://
                viewHolder.tvStyle4Title.setText(feedsBean.getTitle());
                if (feedsBean.getImages().get(0).getUrl() != null) {
                    Picasso.with(mContext).load(feedsBean.getImages().get(0).getUrl()).into(viewHolder.ivStyle4Icon1);
                }
                if (feedsBean.getImages().get(1).getUrl() != null) {
                    Picasso.with(mContext).load(feedsBean.getImages().get(1).getUrl()).into(viewHolder.ivStyle4Icon2);
                }
                if (feedsBean.getImages().get(2).getUrl() != null) {
                    Picasso.with(mContext).load(feedsBean.getImages().get(2).getUrl()).into(viewHolder.ivStyle4Icon3);
                }

                if (feedsBean.getUser() != null) {
                    viewHolder.tvStyle4NickName.setText(feedsBean.getUser().getNickName());
                } else {
                    viewHolder.tvStyle4NickName.setVisibility(View.INVISIBLE);
                }
                viewHolder.tvStyle4ViewCount.setText(feedsBean.getViewCount() + "");
                viewHolder.tvStyle4CommentCount.setText(feedsBean.getCommentCount() + "");
                break;
            case STYLE_7://
                viewHolder.tvStyle7Title.setText(feedsBean.getTitle());

                if(feedsBean.getImages().get(0).getUrl()!=null){
                    Picasso.with(mContext).load(feedsBean.getImages().get(0).getUrl()).into(viewHolder.ivStyle7Icon);
                }else {
                    viewHolder.ivStyle7Icon.setVisibility(View.GONE);
                }

                break;
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        //style3的
//        @Bind(R.id.tv_style1_title)
        TextView tvStyle1Title;
        //        @Bind(R.id.tv_style1_nickName)
        TextView tvStyle1NickName;
        //        @Bind(R.id.tv_style1_viewCount)
        TextView tvStyle1ViewCount;
        //        @Bind(R.id.tv_style1_commentCount)
        TextView tvStyle1CommentCount;

        //style2的
//        @Bind(R.id.iv_style2_icon)
        ImageView ivStyle2Icon;
        //        @Bind(R.id.tv_style2_title)
        TextView tvStyle2Title;
        //        @Bind(R.id.tv_style2_nickName)
        TextView tvStyle2NickName;
        //        @Bind(R.id.tv_style2_viewCount)
        TextView tvStyle2ViewCount;
        //        @Bind(R.id.tv_style2_commentCount)
        TextView tvStyle2CommentCount;

        //style3的
//        @Bind(R.id.tv_style3_title)
        TextView tvStyle3Title;
        //        @Bind(R.id.iv_style3_icon1)
        ImageView ivStyle3Icon1;
        //        @Bind(R.id.iv_style3_icon2)
        ImageView ivStyle3Icon2;
        //        @Bind(R.id.iv_style3_icon3)
        ImageView ivStyle3Icon3;
        //        @Bind(R.id.tv_style3_nickName)
        TextView tvStyle3NickName;
        //        @Bind(R.id.tv_style3_viewCount)
        TextView tvStyle3ViewCount;
        //        @Bind(R.id.tv_style3_commentCount)
        TextView tvStyle3CommentCount;

        //style4的
//        @Bind(R.id.tv_style4_title)
        TextView tvStyle4Title;
        //        @Bind(R.id.iv_style4_icon1)
        ImageView ivStyle4Icon1;
        //        @Bind(R.id.iv_style4_icon2)
        ImageView ivStyle4Icon2;
        //        @Bind(R.id.iv_style4_icon3)
        ImageView ivStyle4Icon3;
        //        @Bind(R.id.tv_style4_nickName)
        TextView tvStyle4NickName;
        //        @Bind(R.id.tv_style4_viewCount)
        TextView tvStyle4ViewCount;
        //        @Bind(R.id.tv_style4_commentCount)
        TextView tvStyle4CommentCount;

        //style7的
//        @Bind(R.id.tv_style7_title)
        TextView tvStyle7Title;
        //        @Bind(R.id.iv_style7_icon)
        ImageView ivStyle7Icon;

        //top
        ImageView ivTopIcon1;
        ImageView ivTopIcon2;
        ImageView ivTopIcon3;
        ImageView ivTopIcon4;
//        @Bind(R.id.ll_f_top10)
        LinearLayout llFTop10;
//        @Bind(R.id.ll_f_kuaixun)
        LinearLayout llFKuaixun;
//        @Bind(R.id.ll_f_zhoubian)
        LinearLayout llFZhoubian;
//        @Bind(R.id.ll_f_piaofang)
        LinearLayout llFPiaofang;


        public MyViewHolder(View convertView, int itemViewType) {
            super(convertView);

            switch (itemViewType) {

                case STYLE_TITLE://头部4个
                    ivTopIcon1 = (ImageView) convertView.findViewById(R.id.iv_top_icon1);
                    ivTopIcon2 = (ImageView) convertView.findViewById(R.id.iv_top_icon2);
                    ivTopIcon3 = (ImageView) convertView.findViewById(R.id.iv_top_icon3);
                    ivTopIcon4 = (ImageView) convertView.findViewById(R.id.iv_top_icon4);

                    llFTop10 = (LinearLayout) convertView.findViewById(R.id.ll_f_top10);
                    llFKuaixun = (LinearLayout) convertView.findViewById(R.id.ll_f_kuaixun);
                    llFZhoubian = (LinearLayout) convertView.findViewById(R.id.ll_f_zhoubian);
                    llFPiaofang = (LinearLayout) convertView.findViewById(R.id.ll_f_piaofang);


                    //监听回调
                    llFTop10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(onTopClickListener!=null){
                                onTopClickListener.onTopClick(v);
                            }
                        }
                    });
                    llFKuaixun.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(onTopClickListener!=null){
                                onTopClickListener.onKuaiXunClick(v);
                            }
                        }
                    });
                    llFZhoubian.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(onTopClickListener!=null){
                                onTopClickListener.onZhouBianClick(v);
                            }
                        }
                    });
                    llFPiaofang.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(onTopClickListener!=null){
                                onTopClickListener.onShiShiClick(v);
                            }
                        }
                    });

                    break;
                case STYLE_1://
                    tvStyle1Title = (TextView) convertView.findViewById(R.id.tv_style1_title);
                    tvStyle1NickName = (TextView) convertView.findViewById(R.id.tv_style1_nickName);
                    tvStyle1ViewCount = (TextView) convertView.findViewById(R.id.tv_style1_viewCount);
                    tvStyle1CommentCount = (TextView) convertView.findViewById(R.id.tv_style1_commentCount);
                    break;
                case STYLE_2://
                    ivStyle2Icon = (ImageView) convertView.findViewById(R.id.iv_style2_icon);
                    tvStyle2Title = (TextView) convertView.findViewById(R.id.tv_style2_title);
                    tvStyle2NickName = (TextView) convertView.findViewById(R.id.tv_style2_nickName);
                    tvStyle2ViewCount = (TextView) convertView.findViewById(R.id.tv_style2_viewCount);
                    tvStyle2CommentCount = (TextView) convertView.findViewById(R.id.tv_style2_commentCount);
                    break;
                case STYLE_3://
                    tvStyle3Title = (TextView) convertView.findViewById(R.id.tv_style3_title);
                    ivStyle3Icon1 = (ImageView) convertView.findViewById(R.id.iv_style3_icon1);
                    ivStyle3Icon2 = (ImageView) convertView.findViewById(R.id.iv_style3_icon2);
                    ivStyle3Icon3 = (ImageView) convertView.findViewById(R.id.iv_style3_icon3);
                    tvStyle3NickName = (TextView) convertView.findViewById(R.id.tv_style3_nickName);
                    tvStyle3ViewCount = (TextView) convertView.findViewById(R.id.tv_style3_viewCount);
                    tvStyle3CommentCount = (TextView) convertView.findViewById(R.id.tv_style3_commentCount);
                    break;
                case STYLE_4://
                    tvStyle4Title = (TextView) convertView.findViewById(R.id.tv_style4_title);
                    ivStyle4Icon1 = (ImageView) convertView.findViewById(R.id.iv_style4_icon1);
                    ivStyle4Icon2 = (ImageView) convertView.findViewById(R.id.iv_style4_icon2);
                    ivStyle4Icon3 = (ImageView) convertView.findViewById(R.id.iv_style4_icon3);
                    tvStyle4NickName = (TextView) convertView.findViewById(R.id.tv_style4_nickName);
                    tvStyle4ViewCount = (TextView) convertView.findViewById(R.id.tv_style4_viewCount);
                    tvStyle4CommentCount = (TextView) convertView.findViewById(R.id.tv_style4_commentCount);
                    break;
                case STYLE_7://
                    tvStyle7Title = (TextView) convertView.findViewById(R.id.tv_style7_title);
                    ivStyle7Icon = (ImageView) convertView.findViewById(R.id.iv_style7_icon);
                    break;
            }



        }
    }


    @Override
    public int getItemCount() {
        return mFeeds==null?0:mFeeds.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        int itemViewType = -1;
        //根据位置，从列表中得到一个数据对象
        int style = -1;
        if (position > 0) {
            style = mFeeds.get(position - 1).getStyle();
        }
        if (position == 0) {//头部4个图片
            itemViewType = STYLE_TITLE;
        } else {//其余的部分

            if(style == 1){
                itemViewType = STYLE_1;
            }else if (style == 2||style == 5) {
                itemViewType = STYLE_2;
            } else if (style == 3) {
                itemViewType = STYLE_3;
            } else if (style == 4) {
                itemViewType = STYLE_4;
            } else {
                itemViewType = STYLE_7;
            }

        }

        return itemViewType;
    }


    private OnTopClickListener onTopClickListener;

    public interface OnTopClickListener{
        //top10jianting
        void onTopClick(View v);

        //影视快讯
        void onKuaiXunClick(View v);

        //周边商城
        void onZhouBianClick(View v);

        //实施票房
        void  onShiShiClick(View v);

    }


    public void setOnTopClickListener(OnTopClickListener onTopClickListener) {
        this.onTopClickListener = onTopClickListener;
    }
}
