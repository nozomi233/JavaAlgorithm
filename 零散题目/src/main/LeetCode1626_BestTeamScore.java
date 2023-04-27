package main;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-03-20
 **/
public class LeetCode1626_BestTeamScore {
    static class Solution {
        public static int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length;
            int[][] people = new int[n][2];
            for (int i = 0; i < n; ++i){
                people[i] = new int[]{scores[i], ages[i]};
            }

            Arrays.sort(people, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            int[] dp = new int[n];
            int res = 0;
            for (int i = 0; i < n; ++i){
                for (int j = i - 1; j >= 0; --j){
                    if(people[j][1] <= people[i][1]){
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += people[i][0];
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        public static void main(String[] args) {
            int[] scores = new int[]{1,3,5,10,15};
            int[] ages = new int[]{1,2,3,4,5};
            bestTeamScore(scores, ages);

        }
    }

}
