package com.zhulang;

import java.lang.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-03-19
 **/
public class ThreadArrayListSync {
    static final Object object = new Object();
    static private boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                res.add(7);
                res.set(0,999);
                for(Integer r : res){
                    System.out.println(r);
                }
            }
        }).start();
        List<Integer> res2 = new ArrayList<>();
        res2.add(111);
        res2.add(222);
        res2.add(533);
        new Thread(new Runnable() {
            @Override
            public void run() {
                res.addAll(res2);
                for(Integer r : res){
                    System.out.println(r);
                }
            }
        }).start();

    }

}
