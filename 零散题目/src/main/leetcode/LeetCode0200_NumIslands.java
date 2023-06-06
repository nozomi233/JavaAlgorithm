package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode0200_NumIslands {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int res = 0;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < m; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    res += 1;
                }
                dfs(grid, i, j, visited);
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (!isValid(grid, i, j)){
            return;
        }
        if (visited[i][j]){
            return;
        }

        if (grid[i][j] == '1' && !visited[i][j]){
            visited[i][j] = true;
            // 递归遍历上下左右的节点
            for (int[] d : dirs) {
                int next_i = i + d[0];
                int next_j = j + d[1];
                dfs(grid, next_i, next_j, visited);
            }
        }

    }

    public boolean isValid(char[][] grid, int x, int y){
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
            return true;
        }
        return false;
    }

    public int numIslandsUnionFind(char[][] grid) {
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
        char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        LeetCode0200_NumIslands l = new LeetCode0200_NumIslands();
//        System.out.println(l.numIslands(grid));
        System.out.println(l.numIslandsUnionFind(grid));
    }



}
