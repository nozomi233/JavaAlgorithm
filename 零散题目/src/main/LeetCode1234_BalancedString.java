package main;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhulang
 * @Date 2023-02-13
 **/
public class LeetCode1234_BalancedString {
    static class Solution {
        public int balancedString(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            map.put('Q',0);
            map.put('W',0);
            map.put('E',0);
            map.put('R',0);
            for (char c : chars){
                map.put(c, map.get(c) + 1);
            }
            int n = chars.length;
            int m = n / 4;
            if(map.get('Q') == m && map.get('W') == m && map.get('E') == m && map.get('R') == m){
                return 0;
            }
            int ans = n;
            int left = 0;
            for(int right = 0; right < n; right++){
                map.put(chars[right], map.get(chars[right]) - 1);
                while (map.get('Q') <= m && map.get('W') <= m && map.get('E') <= m && map.get('R') <= m){
                    ans = Math.min(ans, right-left+1);
                    map.put(chars[left], map.get(chars[left]) + 1);
                    left++;
                }
            }
            return ans;
        }
    }
}
