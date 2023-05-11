package main;

/**
 * @Author zhulang
 * @Date 2023-05-11
 **/
public class LeetCode1016_QueryString {

    // O(N)
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
//            String binaryString = Integer.toBinaryString(i);
            String binaryString = tenToBinary(i);
            if (getIndexOf(s, binaryString) == -1) {

                return false;
            }
        }
        return true;
    }

    // 正整数十进制转二进制
    public String tenToBinary(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.insert(0, n % 2);
            n = n / 2;
        }
        return s.toString();
    }

    // O(M+N)
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() < m.length() || m.length() < 1) {
            return -1;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int[] next = getNextArray(str2);
        int l1 = 0;
        int l2 = 0;
        while (l1 < str1.length && l2 < str2.length) {
            if (str1[l1] == str2[l2]) {
                l1++;
                l2++;
            } else if (next[l2] == -1) {
                l1++;
            } else {
                l2 = next[l2];
            }
        }

        return str2.length == l2 ? l1 - l2 : -1;
    }


    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
