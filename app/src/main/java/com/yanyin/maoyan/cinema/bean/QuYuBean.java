package com.yanyin.maoyan.cinema.bean;

/**
 * Created by 颜银 on 2016/12/6.
 * QQ:443098360
 * 微信：y443098360
 * 作用：地区的Bean类
 */

public class QuYuBean  {
    public String name;
    public int size;

    public QuYuBean(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "QuYuBean{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
