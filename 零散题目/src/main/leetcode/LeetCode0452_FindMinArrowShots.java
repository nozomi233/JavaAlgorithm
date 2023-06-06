package main.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode0452_FindMinArrowShots {
    public int findMinArrowShots(int[][] ints) {
        if (ints.length == 0) {
            return 0;
        }

        // 按end升序排列
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        // 至少应该有一个区间不想交
        int count = 1;
        int x_end = ints[0][1];
        for (int[] interval : ints) {
            int start = interval[0];
            if (start > x_end) {
                // 更新 x
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
