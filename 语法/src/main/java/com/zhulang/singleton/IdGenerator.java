package com.zhulang.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author zhulang
 * @Date 2023-04-06
 **/
public class IdGenerator {
    // 饿汉式
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();
    private IdGenerator(){}
    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }

}
