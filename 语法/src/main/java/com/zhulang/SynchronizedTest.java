package com.zhulang;

import java.lang.String;

/**
 * @Author zhulang
 * @Date 2023-03-21
 **/
public class SynchronizedTest {
    public static void main(String[] args) {

        synchronized (SynchronizedTest.class){
            System.out.println("这是一个同步方法块");
        }

    }

    public synchronized void test(){
        System.out.println("这是一个同步方法，因为在方法上使用了synchronized关键字");
    }
}
