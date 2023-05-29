package main.leetcode;

/**
 * @Author zhulang
 * @Date 2022-12-28
 **/
public class LeetCode1750_MinimumLength {
    static class Solution {
        public int minimumLength(String s) {
            int n = s.length();
            int left = 0;
            int right = n - 1;
            while (left < right && s.charAt(left) == s.charAt(right)){
                char c = s.charAt(left);
                while (left <= right && s.charAt(left) == c){
                    left++;
                }
                while (left <= right && s.charAt(right) == c){
                    right--;
                }
            }
            return right - left + 1;
        }
    }
}
