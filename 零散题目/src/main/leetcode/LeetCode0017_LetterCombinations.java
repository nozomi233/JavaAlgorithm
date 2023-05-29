package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-05-17
 **/
public class LeetCode0017_LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return Collections.emptyList();
        }
        char[][] charMap = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<String> res = new ArrayList<>();
        char[] digitsStr = digits.toCharArray();
        List<Integer> digitsToInt = new ArrayList<>();
        for (char c : digitsStr){
            digitsToInt.add(c - '2');
        }
        StringBuilder path = new StringBuilder();
        backTrace(0, path, digitsToInt, res, charMap);


        return res;
    }

    public static void backTrace(int i, StringBuilder path, List<Integer> digitsToInt ,List<String> res, char[][] charMap){
        if (path.length() == digitsToInt.size()){
            res.add(path.toString());
            return;
        }

        char[] choice = charMap[digitsToInt.get(i)];

        for (char c : choice){
            path.append(c);
            backTrace(i + 1, path, digitsToInt, res, charMap);
            path.deleteCharAt(i);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

}
