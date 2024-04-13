package offer;

public class JZ13 {
    //记录遍历的四个方向
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //记录答案
    int res = 0;


    //深度优先搜索dfs
    void dfs(int i, int j, int rows, int cols, int threshold, boolean[][] vis){
        if (i < 0 || j < 0 || i >= rows || j >= cols || vis[i][j]){
            return;
        }

        if (bitSum(i) + bitSum(j) > threshold){
            return;
        }

        res += 1;
        vis[i][j] = true;

        for (int k = 0; k < 4; k++){
            dfs(i + dir[k][0], j + dir[k][1], rows, cols, threshold, vis);
        }
    }
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0){
            return 1;
        }
        boolean[][] vis = new boolean[rows][cols];
        dfs(0, 0, rows, cols, threshold, vis);
        return res;
    }

    //计算一个数字的每个数之和
    public int bitSum(int i){
        int res = 0;
        while (i != 0){
            res += i % 10;
            i = i / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        JZ13 j = new JZ13();
        System.out.println(j.bitSum(4321));
        System.out.println(j.movingCount(
                10,1,100));
    }
}
