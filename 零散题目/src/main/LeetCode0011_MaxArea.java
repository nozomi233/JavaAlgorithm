package main;

/**
 * @Author zhulang
 * @Date 2023-04-10
 **/
public class LeetCode0011_MaxArea {
    // 暴力，超时
    public int maxArea1(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[j], height[i]));
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {

        int n = height.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                dp[i][j] = Math.max(dp[i][j - 1], maxA(height, j)) ;
            }

        }


        return dp[0][n - 1];
    }

    private int maxA(int[] height, int j){
        if (j <= 0){
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < j; i++){
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[j], height[i]));
        }
        return maxArea;
    }

    // area = (j - i) * Math.min(height[j], height[i])
    // 从两边开始移动，底一定是减小的；
    // 移动短板，面积可能变大可能变小；
    // 移动长板，因为短板是固定的，面积取决于短板，所以要么不变，要么跳到比短板更短的地方，面积变小；
    // 所以，要每次移动短板，从初始面积找更大的面积
    public int maxArea3(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int maxArea = 0;
        while (L < R){
            maxArea = Math.max(maxArea, (R - L) * Math.min(height[R], height[L]));
            if (height[R] > height[L]) {
                L++;
            } else {
                R--;
            }
        }
        return maxArea;
    }
}
