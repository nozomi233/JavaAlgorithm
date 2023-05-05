package main;

/**
 * @Author zhulang
 * @Date 2023-05-05
 **/
public class LeetCode2432_HardestWorker {
    static class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int res = logs[0][0];
            int time = logs[0][1];

            for (int i = 1; i < logs.length; i++){
                if (logs[i][1] - logs[i - 1][1] > time){
                    time = logs[i][1] - logs[i - 1][1];
                    res = logs[i][0];
                }
                if (logs[i][1] - logs[i - 1][1] == time){
                    res = Math.min(res, logs[i][0]);
                }
            }
            return res;
        }
    }
}
