package main.leetcode;


import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode2352_EqualPairs {
    public int equalPairs(int[][] grid) {
        Map<String, List<Integer>> map = new HashMap<>();
        int n = grid.length;

        for (int i = 0; i < n; i++){
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < n; j++){
                col.append(grid[i][j]).append("_");
            }
            String key = col.toString();
            List<Integer> mapValue = map.getOrDefault(key, new ArrayList<>());
            mapValue.add(i);
            map.put(key, mapValue);
        }

        int res = 0;
        for (int j = 0; j < n; j++){
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++){
                row.append(grid[i][j]).append("_");
            }
            res += map.getOrDefault(row.toString(), new ArrayList<>()).size();
        }

        return res;
    }


    public int equalPairs1(int[][] grid) {
        int res = 0, n = grid.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (equal(row, col, n, grid)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean equal(int row, int col, int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] grid = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        LeetCode2352_EqualPairs l = new LeetCode2352_EqualPairs();
        System.out.println(l.equalPairs(grid));
    }
}
