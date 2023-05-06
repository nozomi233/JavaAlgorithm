package main;

import java.util.HashMap;

/**
 * @Author zhulang
 * @Date 2023-05-05
 **/
public class LeetCode0076_MinWindow {
    static class Solution {
        public String minWindow(String s, String t) {
            // 初始化need 和 window两个哈希表，分别记录T中字符出现次数和「窗口」中的相应字符的出现次数。
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            char[] ts = t.toCharArray();
            char[] ss = s.toCharArray();

            // t 中字符及其出现次数存入hash表need
            for (Character c : ts) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            // valid变量表示窗口中满足need条件的字符个数，如果valid和need.size的大小相同，
            // 则说明窗口已满足条件，已经完全覆盖了串T。
            int valid = 0;
            // 记录最小覆盖子串的起始索引及长度
            int start = 0;
            int len = Integer.MAX_VALUE;
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
                while (valid == need.size()) {
                    // 在这里更新最小覆盖子串
                    if (right - left < len){
                        start = left;
                        len = right - left;
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

            // 返回最小覆盖子串
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }

    }
}
