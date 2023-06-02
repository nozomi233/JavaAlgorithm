package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-02
 **/
public class LeetCode0046_Permute {
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrace(nums, path);
        return res;
    }

    public void backTrace(int[] arr, List<Integer> path) {
        if (path.size() == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i : arr) {
            // 需要把已加入路径的排除掉
            if (!path.contains(i)) {
                path.add(i);
                backTrace(arr, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
