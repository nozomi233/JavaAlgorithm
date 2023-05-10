package main;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 在模运算中，经常会用到两个等式
 *
 * (a+b)%m = (a%m+b%m)%m
 *
 * (a*b)%m = ((a%m)*(b%m))%m
 * @Author zhulang
 * @Date 2023-05-09
 **/
public class LeetCode1015_SmallestRepunitDivByK {
    public static int smallestRepunitDivByK(int k) {
        // 若 k 能被 2 或 5 整除，则无解，返回 -1
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        // 初始化余数为 1，表示一个数的最低位是 1
        int resid = 1 % k, len = 1;
        // 若余数不为 0，继续迭代，一定有解，所以循环一定会终止
        while (resid != 0) {
            // 计算下一个数的余数，下一个数在当前余数后加一个 1
            resid = (resid * 10 + 1) % k;
            len++;
        }
        // 返回数字 1 的最小重复次数
        return len;
    }

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(5));
    }
}
