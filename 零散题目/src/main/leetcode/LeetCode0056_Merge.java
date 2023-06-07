package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-07
 **/
public class LeetCode0056_Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            // res中最后一个元素
            int[] last = res.get(res.size() - 1);
            if (cur[0] <= last[1]){
                // 找到最大end
                last[1] = Math.max(last[1], cur[1]);
            } else {
                // 处理下一个待合并区间
                res.add(cur);
            }
        }
        // 记住这个二维列表转数组的方式
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        LeetCode0056_Merge l = new LeetCode0056_Merge();
        int[][] merge = l.merge(ints);
        for (int[] i : merge){
            System.out.println(i[0] + "_" + i[1]);
        }
    }
}
