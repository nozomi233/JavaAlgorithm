package com.zhulang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhulang
 * @Date 2023-02-16
 **/
public class LeetCode2341_NumberOfPairs {
    static class Solution {
        public int[] numberOfPairs(int[] nums) {
            Map<Integer, Boolean> cnt = new HashMap<>();
            int res = 0;
            for (int num : nums){
                cnt.put(num, !cnt.getOrDefault(num, false));
                if(!cnt.get(num)){
                    res++;
                }
            }

            return new int[]{res, nums.length - 2 * res};
        }
    }
}
