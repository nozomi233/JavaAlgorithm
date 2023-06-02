package main.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhulang
 * @Date 2023-06-02
 **/
public class LeetCode2559_VowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            prefix[i + 1] = isVowelString(words[i]) ? prefix[i] + 1 : prefix[i];
        }

        int [] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            // 注意前缀和的right - left 边界，有边界要 + 1
            res[i] = prefix[r + 1] - prefix[l];
        }

        return res;
    }


    public boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    public boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aba","bcb","ece","aa","e"};
        int[][] q = new int[][]{{0,2},{1,4},{1,1}};
        LeetCode2559_VowelStrings l = new LeetCode2559_VowelStrings();
        int[] res = l.vowelStrings(words, q);
        for (int i : res){
            System.out.println(i);
        }

    }
}
