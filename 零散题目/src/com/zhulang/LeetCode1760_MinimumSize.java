package com.zhulang;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2022-12-20
 **/
public class LeetCode1760_MinimumSize {
    static class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int left = 1;
            int right = Arrays.stream(nums).max().getAsInt();
            int ans = 0;
            while (left <= right){
                int y = (left + right) / 2;
                long ops = 0;
                for(int x : nums){
                    ops += (x - 1) / y;
                }
                if(ops <= maxOperations) {
                    ans = y;
                    right = y - 1;
                } else {
                    left = y + 1;
                }
            }
            return ans;
        }
    }
}
