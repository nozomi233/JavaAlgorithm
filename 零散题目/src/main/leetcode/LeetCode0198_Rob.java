package main.leetcode;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-05-08
 **/
public class LeetCode0198_Rob {
    static class Solution {
        /**
         * 状态转移方程
         * dp[n] = Math.max(dp[n - 1], dp[n - 2] + nums[n]);
         */
        public int rob(int[] nums) {
            int n = nums.length;
            // 记录 dp[i+1] 和 dp[i+2]
            int dp_i_1 = 0, dp_i_2 = 0;
            // 记录 dp[i]
            int dp_i = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i;
        }

        /**
         * 暴力递归
         */
        public int robRecur(int[] nums) {
            return dpRecur(nums, 0);
        }

        private int dpRecur(int[] nums, int start){
            if (start >= nums.length){
                return 0;
            }
            int res = Math.max(
                    // 不抢，去下家
                    dpRecur(nums, start + 1),
                    // 抢，去下下家
                    dpRecur(nums, start + 2) + nums[start]);
            return res;
        }

        private int[] memo;

        /**
         * 带备忘录的自顶向下递归
         */
        public int robDPTable(int[] nums) {
            // 初始化备忘录
            memo = new int[nums.length];
            Arrays.fill(memo, -1);
            // 强盗从第 0 间房子开始抢劫
            return dpTable(nums, 0);
        }

        private int dpTable(int[] nums, int start){
            if (start >= nums.length) {
                return 0;
            }
            // 避免重复计算
            if (memo[start] != -1){
                return memo[start];
            }

            int res = Math.max(
                    // 不抢，去下家
                    dpTable(nums, start + 1),
                    // 抢，去下下家
                    dpTable(nums, start + 2) + nums[start]);

            // 记入备忘录
            memo[start] = res;
            return res;
        }

        /**
         * 自底向上的DP解法
         */
        public int rob2(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            dp[n] = 0;
            dp[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--){
                dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            }

            return dp[0];
        }

    }

}
