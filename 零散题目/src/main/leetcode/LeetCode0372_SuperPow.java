package main.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-07
 **/
public class LeetCode0372_SuperPow {
    int base = 1337;
    public int superPow(int a, int[] b) {
        if (b.length == 0) {
            return 1;
        }
        Deque<Integer> r = new LinkedList<>();
        for (int i = 0; i < b.length; i++){
            r.add(b[i]);
        }
        return superPow(a, r);

    }

    public int superPow(int a, Deque<Integer> r) {
        if (r.size() == 0) {
            return 1;
        }
        int last = r.getLast();
        r.removeLast();
        int part1 = mypow(a, last);
        int part2 = mypow(superPow(a, r), 10);
        // 每次乘法都要求模
        return (part1 * part2) % base;
    }


    // 计算 a 的 k 次方然后与 base 求模的结果
    public int mypow(int a, int k) {
        // 对因子求模
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            // 这里有乘法，是潜在的溢出点
            res *= a;
            // 对乘法结果求模
            res %= base;
        }
        return res;
    }

}
