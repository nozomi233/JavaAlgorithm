package com.zhulang;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhulang
 * @Date 2023-04-26
 **/
public class LeetCode0003_LengthOfLongestSubstring {
    static class Solution{
        public static void main(String[] args) {
            String s = "abba";
            System.out.println(lengthOfLongestSubstring(s));
        }

        public static int lengthOfLongestSubstring(String s) {
            char[] str = s.toCharArray();
            int L = 0;
            int R = 0;
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (R < str.length){
                if (!map.containsKey(str[R])){
                    map.put(str[R], R);
                    max = Math.max(R - L + 1, max);
                    R++;
                    continue;
                }
                int i = map.get(str[R]);
                while (L <= i){
                    map.remove(str[L]);
                    L++;
                }
                map.put(str[R], R);
                R++;
            }
            return max;
        }
    }
}
