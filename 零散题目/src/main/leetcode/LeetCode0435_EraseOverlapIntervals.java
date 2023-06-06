package main.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode0435_EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalScheduling(intervals);
    }

    public int intervalScheduling(int[][] ints) {
        if (ints.length == 0){
            return 0;
        }

        // 按end升序排列
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 至少应该有一个区间不想交
        int count = 1;
        int x_end = ints[0][1];
        for (int[] interval : ints){
            int start = interval[0];
            if (start >= x_end){
                // 更新 x
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
