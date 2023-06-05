package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-05
 **/
public class LeetCode0733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        floodFill(image, sr, sc, originColor, color, visited);
        return image;
    }

    public void floodFill(int[][] image, int x, int y, int originColor, int newColor, boolean[][] visited) {
        if (!inArea(image, x, y)) {
            return;
        }

        if (image[x][y] != originColor) {
            return;
        }

        if (visited[x][y]) {
            return;
        }


        image[x][y] = newColor;
        visited[x][y] = true;

        floodFill(image, x, y + 1, originColor, newColor, visited);

        floodFill(image, x, y - 1, originColor, newColor, visited);

        floodFill(image, x + 1, y, originColor, newColor, visited);

        floodFill(image, x - 1, y, originColor, newColor, visited);
    }

    public boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }

    // 回溯
    void fill(int[][] image, int x, int y, int origColor, int newColor) {
        // 出界：超出数组边界
        if (!inArea(image, x, y)) return;
        // 碰壁：遇到其他颜⾊，超出 origColor 区域
        if (image[x][y] != origColor) return;
        // 已探索过的 origColor 区域
        if (image[x][y] == -1) return;
        image[x][y] = -1;
        fill(image, x, y + 1, origColor, newColor);
        fill(image, x, y - 1, origColor, newColor);
        fill(image, x - 1, y, origColor, newColor);
        fill(image, x + 1, y, origColor, newColor);
        // unchoose：将标记替换为 newColor
        image[x][y] = newColor;
    }
}
