package com.zhulang.chapter11;

/**
 * @Author zhulang
 * @Date 2023-03-28
 **/
public class IocTest {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        Object bean = beanFactory.getBean("student");
        System.out.println(bean);
    }
}
