package main.leetcode;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-05-31
 **/
public class LeetCode0204_CountPrimes {
    // 超时
    public int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim(i)) count++;
        return count;
    }

    // 判断整数 n 是否是素数
    public boolean isPrim(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                // 有其他整除因子
                return false;
        return true;
    }

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
}
