package main.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-05-29
 **/
public class LeetCode0877_StoneGame {
    // 返回先手是否能赢
    public boolean stoneGame(int[] piles) {
        int my = firstHand(piles, 0, piles.length - 1);
        int sum = 0;
        for (int i : piles){
            sum += i;
        }
        return my > (sum / 2);
    }

    // 返回先手与后手的差值
    public int stoneGame2(int[] piles) {
        int firstHand = firstHand(piles, 0, piles.length - 1);
        int sum = 0;
        for (int i : piles){
            sum += i;
        }
        return 2 * firstHand - sum;
    }

    public int secondHand(int[] piles, int start, int end){
        if (start == end){
            return 0;
        }
        return Math.min(firstHand(piles, start, end - 1), firstHand(piles, start + 1, end));
    }

    public int firstHand(int[] piles, int start, int end){
        if (start == end){
            return piles[start];
        }
        return Math.max(piles[start] + secondHand(piles, start + 1, end), piles[end] + secondHand(piles, start, end - 1));
    }

    class Pair {
        int fir, sec;
        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

    public int stoneGame3(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                dp[i][j] = new Pair(0, 0);
            }
        }

        // 填入base case
        for (int i = 0; i < n; i++){
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        // todo zl 斜着遍历数组，有问题，有空研究下
        for (int l = 2; l <= n; l++){
            for (int i = 0; i <= n - 1; i++){
                int j = l + i - 1;
                // 先手选择最左边或最右边的分数
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                // 状态转移方程
                if (left > right){
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.fir - res.sec;
    }



    public static void main(String[] args) {
        int[] piles = new int[]{2, 1, 9, 5};
        LeetCode0877_StoneGame s = new LeetCode0877_StoneGame();
        System.out.println(s.stoneGame(piles));
        System.out.println(s.stoneGame2(piles));
        System.out.println(s.stoneGame3(piles));
    }
}
