package main.top100;

/**
 * @Author zhulang
 * @Date 2023-04-09
 **/
public class Top005_LongestPalindrome {

    // 动态规划：dp[i,j] = dp[i+1,j-1] & s[i] == s[j]
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    // 递归方法
    public String longestPalindrome2(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int begin = 0;
        int maxLen = 0;


        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){

                if (process(str, i, j)){
                    begin = j - i + 1 > maxLen ? i : begin;
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public boolean process(char[] s, int i, int j){
        if (i > j){
            return false;
        }
        if (i == j){
            return true;
        }
        if ((j == i + 1) && s[i] == s[j]){
            return true;
        }
        return process(s, i + 1, j - 1) & s[i] == s[j];
    }

    // 中心扩散法
    public static String longestPalindrome3(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int end = 0;
        int start = 0;

        for (int i = 0; i < n; i++){
            int len1 = processCenter(str, i, i);
            int len2 = processCenter(str, i, i + 1);

            int len = Math.max(len2, len1);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }


        }

        return s.substring(start, end + 1);
    }

    private static int processCenter(char[] s, int left, int right){
        while (left >= 0 && right < s.length && s[left] == s[right]){
            left -= 1;
            right += 1;
        }
        return (--right) - (++left) + 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        longestPalindrome(s);
    }

}
