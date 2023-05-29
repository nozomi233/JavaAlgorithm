package main.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author zhulang
 * @Date 2023-03-30
 **/
public class LeetCode1637_MaxWidthOfVerticalArea {
    static class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int max = 0;
            for (int i = 1; i < points.length; i++){
                max = Math.max(max,points[i][0] - points[i - 1][0]) ;
            }
            return max;
        }

        public int maxWidthOfVerticalArea2(int[][] points) {
            Arrays.sort(points, (a, b) -> a[0] - b[0]);
            int max = 0;
            for (int i = 1; i < points.length; i++){
                max = Math.max(max,points[i][0] - points[i - 1][0]) ;
            }
            return max;
        }
    }
}
