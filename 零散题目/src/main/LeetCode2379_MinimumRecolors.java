package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-03-09
 **/
public class LeetCode2379_MinimumRecolors {
    static class Solution {
        public int minimumRecolors(String blocks, int k) {
            char[] chars = blocks.toCharArray();
            Integer win = Integer.MAX_VALUE;
            for(int i = 0; i <= chars.length - k; i++){
                win = findBCount(chars,i,k) < win ? findBCount(chars,i,k) : win;

            }
            return win;
        }

        int findBCount(char[] chars, int i, int k){
            int res = 0;
            for(int j = i; j < i + k; j++){
                if(chars[j] == 'W'){
                    res += 1;
                }
            }
            return res;
        }

        public int minimumRecolors2(String blocks, int k) {
            int l = 0, r = 0, cnt = 0;
            while (r < k) {
                cnt += blocks.charAt(r) == 'W' ? 1 : 0;
                r++;
            }
            int res = cnt;
            while (r < blocks.length()) {
                cnt += blocks.charAt(r) == 'W' ? 1 : 0;
                cnt -= blocks.charAt(l) == 'W' ? 1 : 0;
                res = Math.min(res, cnt);
                l++;
                r++;
            }
            return res;
        }
    }
}
