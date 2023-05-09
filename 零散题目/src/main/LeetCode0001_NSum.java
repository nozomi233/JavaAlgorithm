package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回所有和为sum的值（不是下标），可能有多组，去重
 *
 * @Author zhulang
 * @Date 2023-05-09
 **/
public class LeetCode0001_NSum {
    // O(N * logN)
    public static List<List<Integer>> twoSum1(int[] nums, int target) {
        Arrays.sort(nums);
        return twoSumTarget(nums, 0, target);
    }

    /**
     * 从nums的start下标开始，nums已排序
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    private static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int low = start;
        int high = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low];
            int right = nums[high];
            if (sum < target) {
                // 跳过重复值
                while (low < high && nums[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else {
                res.add(Arrays.asList(left, right));
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return res;
    }

    /**
     * 三数之和为0
     * O(N^2)
     * 关键点在于，不能让第一个数重复，至于后面的两个数，我们复用的 twoSum 函数会保证它们不重复。
     * 所以代码中必须用一个 while 循环来保证 3Sum 中第一个元素不重复。
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举
        for (int i = 0; i < n; i++) {
            // 对target - nums[i] 计算twoSum
            List<List<Integer>> tuples = twoSumTarget(nums, i, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /**
     * @param nums   有序数组
     * @param n      n数之和
     * @param start  数组开始位置
     * @param target 目标值
     * @return
     */
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || sz < n) {
            return res;
        }
        if (n == 2) {
            // 双指针
            return twoSumTarget(nums, start, target);
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = 0; i < sz; i++) {
                List<List<Integer>> tuples = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> tuple : tuples) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    tuple.add(nums[i]);
                    res.add(tuple);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }
}
