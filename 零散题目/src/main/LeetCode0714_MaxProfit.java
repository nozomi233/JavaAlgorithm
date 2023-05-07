package main;

/**
 * @Author zhulang
 * @Date 2023-05-07
 **/

/**
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]);
 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
 * 解释：相当于买⼊股票的价格升⾼了。
 */
public class LeetCode0714_MaxProfit {
    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++){
                int tmp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
            }

            return dp_i_0;
        }
    }
}
