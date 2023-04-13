package com.zhulang.singleton;

/**
 * @Author zhulang
 * @Date 2023-04-06
 **/
public class Test {
    public static void main(String[] args) {
        IdGenerator instance = IdGenerator.getInstance();
        IdGenerator instance2 = IdGenerator.getInstance();
        IdGenerator instance3 = IdGenerator.getInstance();
        IdGenerator instance4 = IdGenerator.getInstance();
        System.out.println(instance.getId());
        System.out.println(instance2.getId());
        System.out.println(instance3.getId());
        System.out.println(instance4.getId());
        System.out.println(instance == instance2);
        System.out.println(instance.equals(instance2));
    }
}
