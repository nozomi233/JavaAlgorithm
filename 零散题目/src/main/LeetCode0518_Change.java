package main;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-05-10
 **/
public class LeetCode0518_Change {

    /**
     * 可以凑成amount的硬币组合数
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        return process(amount, coins);
    }

    public int process(int rest, int[] coins){
        if (rest == 0){
            return 1;
        }

        if (rest < 0){
            return -1;
        }

        int res = 0;
        for (int coin : coins){
            int subProblem = process(rest - coin, coins);
            if (subProblem == -1){
                continue;
            }
            res += subProblem;
        }
        return res;
    }

    /**
     * base case
     * dp[0][..] = 0 因为如果不使⽤任何硬币⾯值，就⽆法凑出任何⾦额；
     * dp[..][0] = 1 如果凑出的⽬标⾦额为 0，那么“⽆为⽽治”就是 唯⼀的⼀种凑法
     * @param amount
     * @param coins
     * @return
     */
    public int changeDP(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];

        for (int i = 1; i <= N; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= amount; j++){
                if(j - coins[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][amount];
    }

    /**
     * 状态压缩
     * @param amount
     * @param coins
     * @return
     */
    public int changeDP2(int amount, int[] coins) {
        int N = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++){
            for (int j = 1; j <= amount; j++){
                if(j - coins[i] >= 0){
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

}
