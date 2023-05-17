package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author zhulang
 * @Date 2023-05-18
 **/
public class LeetCode0022_GenerateParenthesis {
    // 回溯算法
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int[] resCount = new int[]{n, n};
        StringBuilder path = new StringBuilder();
        backTrace(path, resCount, res);
        return res;
    }

    public static void backTrace(StringBuilder path, int[] resCount, List<String> res) {
        if (resCount[0] == 0 && resCount[1] == 0) {
            String s = path.toString();
//            if (isValid(s)) {
            res.add(s);
//            }
            return;
        }

        if (resCount[0] > 0){
            path.append('(');
            resCount[0]--;
            backTrace(path, resCount, res);
            path.deleteCharAt(path.length() - 1);
            resCount[0]++;
        }

        // 只要加了resCount[1] > resCount[0] 这个限制，就一定有效，如果不加这个限制，上面要判断isValid才add到res里

        if (resCount[1] > 0 && resCount[1] > resCount[0]){
            path.append(')');
            resCount[1]--;
            backTrace(path, resCount, res);
            path.deleteCharAt(path.length() - 1);
            resCount[1]++;
        }

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (top != '(') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
