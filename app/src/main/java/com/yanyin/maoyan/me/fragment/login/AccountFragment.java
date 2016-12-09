package com.yanyin.maoyan.me.fragment.login;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yanyin.maoyan.R;
import com.yanyin.maoyan.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements View.OnClickListener {


    @Bind(R.id.ib_login_visible)
    ImageButton ibLoginVisible;
    @Bind(R.id.et_login_name)
    EditText etLoginName;
    @Bind(R.id.et_login_pwd)
    EditText etLoginPwd;
    @Bind(R.id.btn_login_login)
    Button btnLoginLogin;
    @Bind(R.id.ib_login_arr)
    ImageButton ibLoginArr;
    @Bind(R.id.ll_login_more)
    LinearLayout llLoginMore;

    @Bind(R.id.ll_login_xinlang)
    LinearLayout llLoginXinlang;
    @Bind(R.id.ll_login_weichat)
    LinearLayout llLoginWeichat;
    @Bind(R.id.ll_login_qq)
    LinearLayout llLoginQq;
    @Bind(R.id.ll_login_baidu)
    LinearLayout llLoginBaidu;


    private int count;


    public AccountFragment() {
    }

    private void initFinds() {
        ibLoginVisible.setOnClickListener(this);
        llLoginXinlang.setOnClickListener(this);
        llLoginWeichat.setOnClickListener(this);
        llLoginQq.setOnClickListener(this);
        llLoginBaidu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ibLoginVisible) {

            count++;
            if (count % 2 == 0) {
                ibLoginVisible.setBackgroundResource(R.drawable.new_password_drawable_invisible);
                etLoginPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                ibLoginVisible.setBackgroundResource(R.drawable.new_password_drawable_visible);
                etLoginPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

            }
        }else if(v == llLoginXinlang){//新浪
            Toast.makeText(getContext(), "新浪登陆", Toast.LENGTH_SHORT).show();

        }else if(v == llLoginWeichat){//微信
            Toast.makeText(getContext(), "微信登陆", Toast.LENGTH_SHORT).show();

        }else if(v == llLoginQq){//qq
            Toast.makeText(getContext(), "QQ登陆", Toast.LENGTH_SHORT).show();

        }else if(v == llLoginBaidu){//百度
            Toast.makeText(getContext(), "百度登陆", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, view);

        initFinds();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initListener();
    }

    private boolean isShow = true;

    private void initListener() {

        ibLoginArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isShow) {
                    ibLoginArr.setBackgroundResource(R.drawable.xiangxia);
                    isShow = false;

                    RotateAnimation animation = new RotateAnimation(0,180, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                    animation.setDuration(400);
                    animation.setFillAfter(true);
                    ibLoginArr.startAnimation(animation);

                    ObjectAnimator.ofFloat(llLoginMore, "translationY", 0, UIUtils.dp2px(130))//
                            .setDuration(400)//
                            .start();

//                    TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0.6f);
//                    animation.setDuration(800); //持续2S
//                    animation.setFillAfter(true);
//                    llLoginMore.startAnimation(animation);
                } else {
                    ibLoginArr.setBackgroundResource(R.drawable.xiangxia);
                    isShow = true;

                    RotateAnimation animation = new RotateAnimation(180,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                    animation.setDuration(400);
                    animation.setFillAfter(true);
                    ibLoginArr.startAnimation(animation);


                    ObjectAnimator.ofFloat(llLoginMore, "translationY", UIUtils.dp2px(130), 0)//
                            .setDuration(400)//
                            .start();

//                    TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, -0.6f);
//                    animation.setDuration(800); //持续2S
//                    animation.setFillAfter(true);
//                    llLoginMore.startAnimation(animation);
                }


            }
        });


        llLoginMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
