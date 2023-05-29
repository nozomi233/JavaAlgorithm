package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-05-12
 **/
public class LeetCode0516_LongestPalindromeSubseq {
    /**
     * 这道题学习遍历顺序
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    dp[i][j] = 1;
                }
            }
        }
        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                if (str[i] == str[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 备忘录
     * @param s
     * @return
     */
    public static int longestPalindromeSubseqRecur(String s) {

        char[] str = s.toCharArray();
        int n = str.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    memo[i][j] = 1;
                } else if (i > j) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = -1;
                }
            }
        }
        return process(str, 0, str.length - 1, memo);
    }

    public static int process(char[] str, int i, int j, int[][] memo){
        if (i > j) {
            return 0;
        }
        if (i == j){
            return 1;
        }

        if (memo[i][j] != -1){
            return memo[i][j];
        }
        if (str[i] == str[j]){
            int res = process(str, i + 1, j - 1, memo) + 2;
            memo[i][j] = res;
            return res;
        }
        int res = Math.max(process(str, i + 1, j, memo), process(str, i, j - 1, memo));
        memo[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));

    }
}
