package main;

import java.util.Arrays;

/**
 * 在子数组array[0..i]中，以array[i]结尾的目标子序列（最长递增子序列）的长度是dp[i]。
 * @Author zhulang
 * @Date 2023-05-12
 **/
public class LeetCode0300_LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 子序列最小也要包括子集
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++){
            // 要处理堆扑克牌
            int poker = nums[i];

            /** 搜索左侧边界的二分查找 **/
            int left = 0;
            int right = piles;
            while (left < right){
                int mid = left + ((right - left) >> 1);
                if (top[mid] > poker){
                    right = mid;
                } else if (top[mid] < poker){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /***********************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles){
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是LIS长度
        return piles;
    }

}
