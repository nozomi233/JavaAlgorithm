package com.zhulang;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-04-15
 **/
public class LeetCode1042_GardenNoAdj {
    static class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] path : paths) {
                adj[path[0] - 1].add(path[1] - 1);
                adj[path[1] - 1].add(path[0] - 1);
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                boolean[] colored = new boolean[5];
                // 邻点点颜色都设置为true,剩下的为false的自己可选
                for (int vertex : adj[i]) {
                    colored[ans[vertex]] = true;
                }
                for (int j = 1; j <= 4; j++) {
                    if (!colored[j]) {
                        ans[i] = j;
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
