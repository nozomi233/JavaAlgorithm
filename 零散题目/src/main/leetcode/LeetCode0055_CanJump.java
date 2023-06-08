package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-08
 **/
public class LeetCode0055_CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到了 0，卡住跳不动了
            if (farthest <= i) return false;
        }
        return farthest >= n - 1;
    }
}
