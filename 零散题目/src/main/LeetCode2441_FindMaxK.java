package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhulang
 * @Date 2023-05-13
 **/
public class LeetCode2441_FindMaxK {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // 先排序保证如果有正值时其负值都已经进入set;
        Arrays.sort(nums);
        int maxK = -1;
        for (int num : nums){
            set.add(num);
            if (set.contains(-num)){
                maxK = Math.max(maxK, num);
            }
        }

        return maxK;
    }

    public int findMaxK1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; j--) {
            while (i < j && nums[i] < -nums[j]) {
                i++;
            }
            if (nums[i] == -nums[j]) {
                return nums[j];
            }
        }
        return -1;
    }
}
