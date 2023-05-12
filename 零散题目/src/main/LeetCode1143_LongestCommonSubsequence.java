package main;

import java.util.HashMap;

/**
 * @Author zhulang
 * @Date 2023-05-12
 **/
public class LeetCode1143_LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        int n = str1.length;
        int m = str2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (str1[i - 1] == str2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];


    }

    /**
     * 递归
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequenceRecur(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        int n = str1.length;
        int m = str2.length;

        return process(str1, str2, n - 1, m - 1);
    }

    public static int process(char[] str1, char[] str2, int i, int j){
        if (i == -1 || j == -1){
            return 0;
        }

        if (str1[i] == str2[j]){
            return process(str1, str2, i - 1, j - 1) + 1;
        }

        return Math.max(process(str1, str2, i, j - 1), process(str1, str2, i - 1, j));
    }


    /**
     * 备忘录
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequenceRecurMemo(String text1, String text2) {
        HashMap<String, Integer> memo = new HashMap<>();
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        int n = str1.length;
        int m = str2.length;

        return processMemo(str1, str2, n - 1, m - 1, memo);
    }

    public static int processMemo(char[] str1, char[] str2, int i, int j, HashMap<String, Integer> memo){
        if (i == -1 || j == -1){
            return 0;
        }

        if (memo.containsKey(i + "_" + j)) {
            return memo.get(i + "_" + j);
        }

        if (str1[i] == str2[j]){
            int res = processMemo(str1, str2, i - 1, j - 1, memo) + 1;
            memo.put(i + "_" + j, res);
            return res;
        }

        int res = Math.max(processMemo(str1, str2, i, j - 1, memo), processMemo(str1, str2, i - 1, j, memo));
        memo.put(i + "_" + j, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequenceRecur("abc", "def"));
        System.out.println(longestCommonSubsequenceRecurMemo("abc", "def"));
    }
}
