package com.zhulang;

/**
 * @Author zhulang
 * @Date 2023-03-27
 **/
/**
 * 给你两个字符串s 和t，请你找出 s中的非空子串的数目，这些子串满足替换 一个不同字符以后，是 t串的子串。换言之，请你找到 s和 t串中 恰好只有一个字符不同的子字符串对的数目。
 *
 * 比方说，"computer"and"computation"只有一个字符不同：'e'/'a'，所以这一对子字符串会给答案加 1 。
 *
 * 请你返回满足上述条件的不同子字符串对数目。
 *
 * 一个 子字符串是一个字符串中连续的字符。
 *
 * 输入：s = "aba", t = "baba"
 * 输出：6
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 *
 *
 * 输入：s = "ab", t = "bb"
 * 输出：3
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 *
 * 输入：s = "a", t = "a"
 * 输出：0
 *
 * 输入：s = "abe", t = "bbc"
 * 输出：10
 *
 */

public class LeetCode1638_CountSubstrings {
    static class Solution {
        public int countSubstrings(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] dpl = new int[m + 1][n + 1];
            int[][] dpr = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (s.charAt(i) != t.charAt(j)) {
                        ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                    }
                }
            }
            return ans;
        }
    }
}
