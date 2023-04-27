package main;

/**
 * @Author zhulang
 * @Date 2023-04-24
 **/
public class LeetCode1163_LastSubstring {
    static class Solution {
        public String lastSubstring(String s) {
            int i = 0, j = 1, n = s.length();
            while (j < n) {
                int k = 0;
                while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                }
                if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                    int t = i;
                    i = j;
                    j = Math.max(j + 1, t + k + 1);
                } else {
                    j = j + k + 1;
                }
            }
            return s.substring(i);
        }

        /**
         * 超时
         * @param s
         * @return
         */

        public static String lastSubstring2(String s) {
            String max = s;
            for (int i = s.length() - 1; i >= 0; i--){
                String substring = s.substring(i);
                if (max.compareTo(substring) < 0){
                    max = substring;
                }
            }
            return max;
        }
    }
}
