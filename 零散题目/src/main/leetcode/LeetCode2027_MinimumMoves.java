package main.leetcode;

/**
 * @Author zhulang
 * @Date 2022-12-27
 **/
public class LeetCode2027_MinimumMoves {
    static class Solution {
        public int minimumMoves(String s) {
            int ans = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'X'){
                    ans++;
                    i += 2;
                }
            }
            return ans;
        }
    }
}
