package main;

/**
 * ⼀次交易由买⼊和卖出构成，⾄少需要两天。所以说有效的限制 k 应该不超 过 n/2，如果超过，就没有约束作⽤了，
 * 相当于 k = Integer.MAX_VALUE。这种情况是之122题解决过的。
 * @Author zhulang
 * @Date 2023-05-06
 **/
public class LeetCode0188_MaxProfit {
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++){
                for (int j = k; j >= 1; j--){
                    if (i - 1 == -1) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][k][0];
        }
    }
}
