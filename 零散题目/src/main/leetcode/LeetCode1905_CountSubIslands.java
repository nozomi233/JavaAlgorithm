package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode1905_CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j ++){
                if (grid1[i][j] == 1 && grid2[i][j] == 1){
                    grid2[i][j] = 2;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j ++){
                if (grid2[i][j] == 2){
                    int i_j = dfs(grid2, i, j);
                    res = res + (i_j  == 0 ? 1 : 0);
                }
            }
        }
        return res;

    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public int dfs(int[][] grid, int i, int j) {
        if (!isValid(grid, i, j)){
            return 0;
        }
        if (grid[i][j] == 0){
            return 0;
        }

        if (grid[i][j] == 1){
            return -1;
        }
        int res = 0;

        if (grid[i][j] == 2){
            grid[i][j] = 0;
            // 递归遍历上下左右的节点
            for (int[] d : dirs) {
                int next_i = i + d[0];
                int next_j = j + d[1];
                res += dfs(grid, next_i, next_j);
            }
        }
        return res;
    }


    public boolean isValid(int[][] grid, int x, int y){
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        LeetCode1905_CountSubIslands l = new LeetCode1905_CountSubIslands();
//        System.out.println(l.numIslands(grid));
        System.out.println(l.countSubIslands(grid1, grid2));
    }
}
