package nc;

import java.util.*;

public class LC_137 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        // write code here
        char[] chars = s.toCharArray();
        int n = chars.length;

        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++){
            if(chars[i]=='('){
                int parCount = 1;
                int j = i + 1;
            }
        }
    }
}
