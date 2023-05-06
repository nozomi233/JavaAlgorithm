package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-05-06
 **/
public class LeetCode0438_FindAnagrams {
    static class Solution {
        public static List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            List<Integer> res = new ArrayList<>();
            char[] ts = p.toCharArray();
            char[] ss = s.toCharArray();
            for (Character c : ts) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0;
            int right = 0;
            int valid = 0;
            while (right < ss.length) {
                char c = ss[right];
                right++;
                // todo 更新窗口
                if (need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))){
                        valid++;
                    }
                }

                while (right - left >= ts.length){
                    if (valid == need.size()){
                        res.add(left);
                    }
                    char d = ss[left];
                    left++;
                    // todo 更新窗口
                    if (need.containsKey(d)){
                        if (window.get(d).equals(need.get(d))){
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }

                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(Solution.findAnagrams(s, p));
    }
}
