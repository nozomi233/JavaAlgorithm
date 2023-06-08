package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-08
 **/
public class LeetCode0026_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 长度为索引+1
        return slow + 1;
    }
}
