package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-05-25
 **/
public class LeetCode2451_OddString {
    public String oddString(String[] words) {
        int[] diff0 = get(words[0]);
        int[] diff1 = get(words[1]);
        if (Arrays.equals(diff0, diff1)){
            for (int i = 2; i < words.length; i++){
                if (!Arrays.equals(diff0, get(words[i]))){
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
    }

    public int[] get(String word){
        int[] diff = new int[word.length()];
        for (int i = 0; i + 1 < word.length(); i++){
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }
}
