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

    /**
     * 计算平方根（牛顿迭代法）
     *
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(1e-100));
        System.out.println(Double.compare(-100.0, Double.NaN)); // -1
        System.out.println(Double.compare(100.0, Double.NaN)); // -1
        System.out.println(Double.compare(Double.NaN, 100.0)); // 1
        System.out.println(Double.compare(Double.NaN, -100.0)); // 1
        System.out.println(Double.compare(Double.NaN, Double.NaN)); // 0
        System.out.println(Double.NaN == Double.NaN); // false, Double.NaN 不能用==、<、>这些比较符号去比较，结果一律为false


    }
}
