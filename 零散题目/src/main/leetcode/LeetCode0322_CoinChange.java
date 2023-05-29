package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-05-10
 **/
public class LeetCode0322_CoinChange {
    /**
     * 最少几枚硬币凑成amount
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int n = coins.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int subProblem = coinChange(coins, amount - coins[i]);
            if (subProblem == -1){
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i <= amount; i++){
            for (int coin : coins){
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]) ;
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
