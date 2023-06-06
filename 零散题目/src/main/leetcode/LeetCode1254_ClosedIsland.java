package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode1254_ClosedIsland {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid)  {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int j = 0; j < m; j++){
            dfs(grid, 0, j);
            dfs(grid, n - 1, j);
        }

        for (int i = 0; i < n; i++){
            dfs(grid, i, 0);
            dfs(grid, i, m - 1);
        }

        for (int i = 1; i < n - 1; i++){
            for (int j = 1; j < m - 1; j++){
                if (grid[i][j] == 0){
                    res += 1;
                }
                dfs(grid, i, j);
            }
        }

        return res;
    }


    public void dfs(int[][] grid, int i, int j) {
        if (!isValid(grid, i, j)){
            return;
        }
        if (grid[i][j] == 1){
            return;
        }

        if (grid[i][j] == 0){
            grid[i][j] = 1;
            // 递归遍历上下左右的节点
            for (int[] d : dirs) {
                int next_i = i + d[0];
                int next_j = j + d[1];
                dfs(grid, next_i, next_j);
            }
        }
    }


    public boolean isValid(int[][] grid, int x, int y){
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
            return true;
        }
        return false;
    }
    public int closedIslandUnion(int[][] grid)  {
        List<String> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < m; j++){
                if (grid[i][j] == '1'){
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

        return set.sizeMap.size();
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        LeetCode1254_ClosedIsland l = new LeetCode1254_ClosedIsland();
//        System.out.println(l.numIslands(grid));
        System.out.println(l.closedIsland(grid));
    }


}
