package main.leetcode;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-05-18
 **/
public class LeetCode0031_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        int n = nums.length;
        int i;
        int j = Integer.MIN_VALUE;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                j = i + 1;
                break;
            }
        }

        if (j == Integer.MIN_VALUE){
            reverse(nums, 0, n - 1);
            return;
        }

        for (int k = n - 1; k >= j; k--){
            if (nums[k] > nums[i]){
                swap(nums, i, k);
                break;
            }
        }
        reverse(nums, j, n - 1);
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i] ;
        arr[i] = tmp;
    }


    public static void reverse(int[] arr, int start, int end){
        while (start < end){
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        nextPermutation(nums);
        for (int i : nums){
            System.out.println(i);
        }
    }
}
