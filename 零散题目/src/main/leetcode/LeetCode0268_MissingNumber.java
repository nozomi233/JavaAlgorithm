package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode0268_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
}
