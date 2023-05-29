package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-03-31
 **/
public class LeetCode2367_ArithmeticTriplets {
    static class Solution {
        public static int arithmeticTriplets(int[] nums, int diff) {
            int count = 0;
            for (int i = 0; i < nums.length; i++){
                if (binSearch(nums, nums[i] + diff) && binSearch(nums,nums[i] + 2 * diff)){
                    count += 1;
                }
            }
            return count;
        }

        public static boolean binSearch(int[] arr, int num){
            if (arr == null || arr.length < 1){
                return false;
            }
            int L = 0;
            int R = arr.length - 1;

            while (L < R){
                int m = L + ((R - L ) >> 1);
                if (arr[m] < num){
                    L = m + 1;
                } else if (arr[m] > num){
                    R = m - 1;
                } else {
                    return true;
                }
            }
            return arr[L] == num;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,4,6,7,10};
        int diff = 3;
        System.out.println(Solution.arithmeticTriplets(nums, diff));
    }


}
