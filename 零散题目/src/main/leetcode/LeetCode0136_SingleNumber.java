package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-05
 **/
public class LeetCode0136_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums){
            res ^= num;
        }
        return res;
    }
}
