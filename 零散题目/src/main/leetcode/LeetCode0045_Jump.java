package main.leetcode;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-06-08
 **/
public class LeetCode0045_Jump {
    int[] memo;
    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);
        return dp(nums, 0);
    }

    public int dp(int[] nums, int p){
        int n = nums.length;
        // base case
        if (p >= n - 1) {
            return 0;
        }
        // 子问题已经计算过
        if (memo[p] != n) {
            return memo[p];
        }
        int steps = nums[p];
        // 你可以选择跳 1 步，2 步...
        for (int i = 1; i <= steps; i++) {
            // 穷举每一个选择
            // 计算每一个子问题的结果
            int subProblem = dp(nums, p + i);
            // 取其中最小的作为最终结果
            memo[p] = Math.min(memo[p], subProblem + 1);
        }
        return memo[p];
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }


}
