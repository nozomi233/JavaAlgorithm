package com.zhulang;

import java.lang.String;

/**
 * @Author zhulang
 * @Date 2023-03-19
 **/
public class ThreadArryList {

    static final Object object = new Object();
    static private boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            String[] arr = {"a","b","c","d"};
            @Override
            public void run() {
                for(int i=0; i<4 ;i++){
                    synchronized (object){
                        if(flag){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(arr[i]+ " ");
                        flag = true;
                        object.notify();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            int[] arr = {1,2,3,4};
            @Override
            public void run() {
                for(int i=0; i<4; i++){
                    synchronized (object){
                        if(!flag){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(arr[i]+ " ");
                        flag = false;
                        object.notify();
                    }
                }

            }
        }).start();
    }


}
