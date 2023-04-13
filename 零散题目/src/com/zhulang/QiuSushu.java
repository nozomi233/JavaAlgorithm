package com.zhulang;

import java.util.ArrayList;

public class QiuSushu {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 2; i <= 100; i++){
            boolean n = false;
            for(int j = 2; j<i; j++){
                if(i % j == 0){
                    n = true;
                    break;
                }
            }
            if(!n){
                array.add(i);
            }
        }
        System.out.println(array);
    }
}
