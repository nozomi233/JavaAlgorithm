package com.zhulang;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2022-12-21
 **/
public class LeetCode1753_MaximumScore {
    static class Solution {
        // 数学
        // 1.若a + b < c, 那么答案为c,将a和b依次与c进行配对，分数为a+b
        // 2.若a+b>c，在这种情况下将 c 中的所有石子与 a 或 b 中的石子配对，
        // 配对过程中总是优先匹配a 和 b 中较大的那一个，最终 a 和 b 大小相等或相差 1,然后 a 和 b 中剩下的两两配对即可。
        // 为了表示结果，我们设 a 与 c 配对了k1次，b 与 c 配对了k2次，且k1+k2=c，因此答案为
        // （k1+k2）+((a-k1)+(b-k2)) / 2 化简后为(a+b+c) / 2 (均为向下取整)
        public int maximumScore(int a, int b, int c) {
            int sum = a + b + c;
            int maxValue = Math.max(Math.max(a, b),c);
            return Math.min(sum - maxValue, sum / 2);
        }

        // 贪心
        public int maximumScore2(int a, int b, int c) {
            int ans = 0;
            int[] rec = new int[]{a, b, c};
            Arrays.sort(rec);
            while (rec[0] != 0 || rec[1] != 0) {
                ans++;
                rec[1]--; rec[2]--;
                Arrays.sort(rec);
            }
            return ans;
        }
    }
}
