package main.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author zhulang
 * @Date 2023-06-02
 **/
public class LeetCode0077_Combine {
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        backTrace(n ,k ,1, path);
        return res;
    }

    public void backTrace(int n, int k, int start, List<Integer> path) {
        if (path.size() == k) {
            if (!res.contains(path)){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            // 需要把已加入路径的排除掉
            if (!path.contains(i)) {
                path.add(i);
                backTrace(n, k, i + 1,  path);
                path.remove(path.size() - 1);
            }
        }
    }
}
