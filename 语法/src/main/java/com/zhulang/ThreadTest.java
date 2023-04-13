package com.zhulang;

import java.lang.String;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhulang
 * @Date 2023-03-20
 **/
class ThreadTest implements Runnable {

    static int i = 0;
    @Override
    public void run() {
        for (int m = 0; m < 1000000; m++) {
            i++;
        }
    }
};

class ThreadTest2 implements Runnable {

    static AtomicInteger i = new AtomicInteger(0);

    @Override
    public void run() {
        for (int m = 0; m < 1000000; m++) {
            i.getAndIncrement();
        }
    }
};

class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest2 mt = new ThreadTest2();

        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();
        // 休眠一下，让线程执行完毕。
        Thread.sleep(500);
        System.out.println(ThreadTest2.i);
    }
}