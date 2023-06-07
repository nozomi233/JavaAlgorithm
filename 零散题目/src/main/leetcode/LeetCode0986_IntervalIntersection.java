package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-07
 **/
public class LeetCode0986_IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length){
            int a1 = firstList[i][0];
            int a2 = firstList[i][1];
            int b1 = secondList[j][0];
            int b2 = secondList[j][1];
            // 两个集合存在交集
            if (b2 >= a1 && a2 >= b1){
                // 计算出交集加入res
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (b2 < a2){
                j += 1;
            } else{
                i += 1;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

}
