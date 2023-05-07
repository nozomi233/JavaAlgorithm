package main;

/**
 * @Author zhulang
 * @Date 2023-05-07
 **/
public class LeetCode0121_MaxProfit {
    static class Solution {
        public int maxProfit(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;

        }
    }
}
