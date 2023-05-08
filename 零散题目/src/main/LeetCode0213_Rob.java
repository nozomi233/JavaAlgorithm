package main;

/**
 * @Author zhulang
 * @Date 2023-05-08
 **/
public class LeetCode0213_Rob {
    static class Solution {
        /**
         * res = Math.max(nums(0,n - 1), nums(1,n));
         * 即抢第一间则不抢最后一间 或 抢最后一间不抢第一间
         */
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1){
                return nums[0];
            }
            return Math.max(rob(nums, 1, n - 1), rob(nums, 0, n - 2));
        }

        private int rob(int[] nums, int start, int end){
            int n = nums.length;
            // 记录 dp[i+1] 和 dp[i+2]
            int dp_i_1 = 0, dp_i_2 = 0;
            // 记录 dp[i]
            int dp_i = 0;
            for (int i = end; i >= start; i--) {
                dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i;
        }
    }
}
