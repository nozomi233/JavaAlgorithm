package main;

/**
 * @Author zhulang
 * @Date 2023-05-09
 **/
public class LeetCode0416_CanPartiton {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }

        int W = sum / 2;
        return knapsackDP(W, nums);
    }

    /**
     * dp[..][0] = true 和 dp[0][..] = false
     * 背包没有空间的时候，就相当于装满了，⽽当没有物品可选择的时候，肯定没办法装满背包
     * @param W
     * @param wt
     * @return
     */
    public static boolean knapsackDP(int W, int[] wt){
        int N = wt.length;
        boolean[][] dp = new boolean[N + 1][W + 1];
        for (int i = 0; i < N; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++){
            for (int w = 0; w <= W; w++){
                if (w - wt[i - 1] < 0){
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i-1][w] | dp[i-1][w - wt[i-1]];
                }
            }
        }
        return dp[N][W];
    }

    public static boolean knapsackDP2(int W, int[] wt){
        int N = wt.length;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;


        for (int i = 0; i < N; i++){
            for (int w = W; w >= 0; w--){
                if (w - wt[i] >= 0){
                    dp[w] = dp[w] || dp[w - wt[i]];
                }
            }
        }
        return dp[W];
    }


}
