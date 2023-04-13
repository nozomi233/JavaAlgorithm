package com.zhulang.chapter11;

/**
 * @Author zhulang
 * @Date 2023-03-28
 **/
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton(){
//        加入下面代码，则不会被反射创建，因为反射调用的默认构造来创建对象的
//        if (singleton != null){
//            throw new RuntimeException("单例对象只能创建一次。。。");
//        }
    }

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
