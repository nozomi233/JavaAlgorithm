package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-02
 **/
public class LeetCode0078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(nums, 0, path,  res);
        return res;
    }

    public void backTrace(int[] nums, int i, List<Integer> path, List<List<Integer>> res){
        if (i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        // 选num[i]入path
        path.add(nums[i]);
        backTrace(nums, i + 1, path,  res);
        path.remove(path.size() - 1);

        // 不选num[i]入path
        backTrace(nums, i + 1, path,  res);
    }

    public static void main(String[] args) {
        LeetCode0078_Subsets l = new LeetCode0078_Subsets();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = l.subsets(nums);
        System.out.println(res);
    }
}
