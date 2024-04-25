package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-05-10
 **/
public class LeetCode0322_CoinChange {

    // method1------------------------------------------------------------------------------------

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

    // method2------------------------------------------------------------------------------------

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

    // method3:回溯------------------------------------------------------------------------------------
    private int minLen = Integer.MAX_VALUE;
    private List<Integer> path;

    public int coinChangeRecur(int[] coins, int amount) {
        // 列表
        path = new ArrayList<>();
        process(coins, amount);
        return minLen == Integer.MAX_VALUE? -1 : minLen;
    }
    private void process(int[] coins, int rest){
        if (rest < 0){
            return;
        }
        if (rest == 0){
            minLen = Math.min(minLen, path.size());
            return;
        }
        for (int coin : coins){
            path.add(coin);
            process(coins, rest - coin);
            path.remove(path.size() - 1);
        }
    }
}
