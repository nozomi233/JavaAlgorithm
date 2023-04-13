package com.offer.zl;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-03-04
 **/
public class Offer03 {
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
