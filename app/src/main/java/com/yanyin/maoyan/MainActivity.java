package com.yanyin.maoyan;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yanyin.maoyan.cinema.fragment.CinemaFragment;
import com.yanyin.maoyan.find.fragment.FindFragment;
import com.yanyin.maoyan.me.fragment.MeFragment;
import com.yanyin.maoyan.move.fragment.MoveFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    private MoveFragment moveFragment;
    private CinemaFragment cinemaFragment;
    private FindFragment findFragment;
    private MeFragment meFragment;
    //事务
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListener();
    }

    //初始化监听
    private void initListener() {
        //RadioGroup的点击监听
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_main_move ://电影
                        setSelect(0);
                        break;
                    case R.id.rb_main_cinema ://影院
                        setSelect(1);
                        break;
                    case R.id.rb_main_find ://发现
                        setSelect(2);
                        break;
                    case R.id.rb_main_me ://我的
                        setSelect(3);
                        break;
                }
            }
        });
        //默认选择电影界面
        rgMain.check(R.id.rb_main_move);
    }

    //选择回调
    private void setSelect(int i) {
        FragmentManager manager = this.getSupportFragmentManager();
        transaction = manager.beginTransaction();

        hideFragment();

        if(i == 0){
            if(moveFragment == null){
                moveFragment = new MoveFragment();
                transaction.add(R.id.fl_main,moveFragment);
            }
            transaction.show(moveFragment);
        }else if(i == 1){
            if(cinemaFragment == null){
                cinemaFragment = new CinemaFragment();
                transaction.add(R.id.fl_main,cinemaFragment);
            }
            transaction.show(cinemaFragment);
        }else if(i == 2){
            if(findFragment == null){
                findFragment = new FindFragment();
                transaction.add(R.id.fl_main,findFragment);
            }
            transaction.show(findFragment);
        }else if(i == 3){
            if(meFragment == null){
                meFragment = new MeFragment();
                transaction.add(R.id.fl_main,meFragment);
            }
            transaction.show(meFragment);
        }

        //提交事务
        transaction.commit();

    }

    //隐藏所有Fragment
    private void hideFragment() {
        if(moveFragment!= null){
            transaction.hide(moveFragment);
        }
        if(cinemaFragment!= null){
            transaction.hide(cinemaFragment);
        }
        if(findFragment!= null){
            transaction.hide(findFragment);
        }
        if(meFragment!= null){
            transaction.hide(meFragment);
        }
    }


    private Handler handler = new Handler();
    private boolean isOut = true;

    /**
     * 实现2s内点击两次退出键才退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK&&isOut){
            Toast.makeText(MainActivity.this, "再点击一次就退出哦", Toast.LENGTH_SHORT).show();
            isOut = false;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isOut = true;//2s后初始化isOut为原来状态
                }
            },2000);

            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    //结束程序就移除所有消息
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

}
