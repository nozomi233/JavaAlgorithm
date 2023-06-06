package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode1020_NumEnclaves {
    public int numEnclaves(int[][] grid) {
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
        int res = 0;
        for (int i = 1; i < n - 1; i++){
            for (int j = 1; j < m - 1; j++){
                if (grid[i][j] == 1){
                    res += 1;
                }
            }
        }

        return res;
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};



    public void dfs(int[][] grid, int i, int j) {
        if (!isValid(grid, i, j)){
            return;
        }
        if (grid[i][j] == 0){
            return;
        }

        if (grid[i][j] == 1){
            grid[i][j] = 0;
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

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        LeetCode1020_NumEnclaves l = new LeetCode1020_NumEnclaves();
//        System.out.println(l.numIslands(grid));
        System.out.println(l.numEnclaves(grid));
    }
}
