package com.zhulang.chapter01;

/**
 * @Author zhulang
 * @Date 2023-06-09
 **/
public class Chapter01 {
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
