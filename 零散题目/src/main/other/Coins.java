package main.other;

import java.util.ArrayList;
import java.util.List;

public class Coins {

    // LeetCode 322:可以凑成总金额所需的 最少的硬币个数
    public int coinChange(int[] coins, int amount) {
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


    // LeetCode 518:可以凑成总金额的硬币组合数
    // dp[i][j]:i个硬币凑成j元, dp[0][...] = 0;dp[..][0] = 1
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        for (int i = 1; i < N + 1; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= amount; j++){
                if (j - coins[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][amount];
    }

    // LeetCode 518:可以凑成总金额的硬币组合数
    // dp[x] 表示金额之和等于x的硬币组合数，目标是求 dp[amount]
    public int changeZip(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins){
            for (int i = c; i <= amount; i++){
                dp[i] = dp[i] + dp[i - c];
            }
        }

        return dp[amount];

    }
}
