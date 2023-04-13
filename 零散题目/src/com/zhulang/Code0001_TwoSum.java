package com.zhulang;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author zhulang
 * @Date 2022-01-27
 **/
public class Code0001_TwoSum {
    /**
     * 1，2方法有则返回，无则返回空列表[];3，4方法无则返回[0,0]
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for(int i = 0 ; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 无序数组此方法不行
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i != j){
            if(nums[i] + nums[j] == target){
                return new int[]{i,j};
            }
            else if(nums[i] + nums[j] < target){
                i += 1;
            }else {
                j -= 1;
            }
        }
        return new int[0];
    }

    public static int[] twoSum3(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0; i<nums.length - 1; i++){
            for(int j = i + 1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }

            }
        }
        return arr;
    }

    public static int[] twoSum4(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                arr[0] = map.get(tmp);
                arr[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints1 = twoSum1(nums, target);
        int[] ints2 = twoSum2(nums, target);
        int[] ints3 = twoSum3(nums, target);
        int[] ints4 = twoSum4(nums, target);
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
        System.out.println(Arrays.toString(ints4));
    }
}
