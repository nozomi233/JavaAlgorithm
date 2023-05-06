package main;

import java.util.HashMap;

/**
 * @Author zhulang
 * @Date 2023-05-06
 **/
public class LeetCode0567_CheckInclusion {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            char[] ts = s1.toCharArray();
            char[] ss = s2.toCharArray();
            for (Character c : ts) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int valid = 0;
            while (right < ss.length) {
                // c 是将移入窗口的字符
                char c = ss[right];
                // 右移窗口
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))){
                        valid++;
                    }
                }


                // 判断左侧窗口是否要收缩 window needs shrink
                // 1、本题移动left缩小窗口的时机是窗口大小大于t.size()时，因为排列嘛，显然长度应该是一样的。
                // 2、当发现valid == need.size()时，就说明窗口中就是一个合法的排列，所以立即返回true。
                while (right - left >= ts.length) {
                    if (valid == need.size()){
                        return true;
                    }
                    // d 是将移出窗口的字符
                    char d = ss[left];
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)){
                        if (window.get(d).equals(need.get(d))){
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false;
        }
    }
}
