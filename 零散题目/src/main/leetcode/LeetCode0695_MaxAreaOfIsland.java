package main.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode0695_MaxAreaOfIsland {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        List<String> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < m; j++){
                if (grid[i][j] == 1){
                    list.add(i + "_" + j);
                }
            }
        }

        UnionFindSet<String> set = new UnionFindSet<>(list);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] d : dirs) {
                    int next_i = i + d[0];
                    int next_j = j + d[1];
                    if (next_i >= 0 && next_j >= 0 && next_i < n && next_j < m){
                        String a = i + "_" + j;
                        String b = next_i + "_" + next_j;
                        set.union(a, b);
                    }
                }
            }
        }

        List<Integer> collect = new ArrayList<>(set.sizeMap.values());

//        System.out.println(set.sizeMap.values());
        return Collections.max(collect);
    }

    public static void main(String[] args) {
        LeetCode0695_MaxAreaOfIsland l = new LeetCode0695_MaxAreaOfIsland();
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(l.maxAreaOfIsland(grid));
    }

}
