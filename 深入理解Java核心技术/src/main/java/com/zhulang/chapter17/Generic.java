package com.zhulang.chapter17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-03-28
 **/
public class Generic {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> stringList = new ArrayList<String>();

        stringList.add("Hollis");
        stringList.add("HollisChuang");

        Method method = stringList.getClass().getMethod("add", Object.class);
        method.invoke(stringList, 128);
        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        List<Apple> apples = new ArrayList<>();
//        List<Fruit> fruits2 = apples; 这样不行
        List<? extends Fruit> fruits = apples;

        List<Fruit> fruits2 = new ArrayList<>();
        List<? super Apple> apples2 = fruits2;

        // List<?> 可以为任何泛型
        List<?> fruits3 = apples;
    }
}
