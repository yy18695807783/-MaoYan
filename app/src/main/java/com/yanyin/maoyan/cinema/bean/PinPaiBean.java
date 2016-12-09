package com.yanyin.maoyan.cinema.bean;

/**
 * Created by 颜银 on 2016/12/7.
 * QQ:443098360
 * 微信：y443098360
 * 作用：
 */

public class PinPaiBean {

    public String name;
    public int number;

    public PinPaiBean(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PinPaiBean{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
