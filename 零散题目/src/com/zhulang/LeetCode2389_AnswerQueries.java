package com.zhulang;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-03-17
 **/
public class LeetCode2389_AnswerQueries {
    static class Solution {
        public static int[] answerQueries(int[] nums, int[] queries) {
            if(queries == null || nums == null) {
                return new int[]{0};
            }

            Arrays.sort(nums);
            int[] sum1 = new int[nums.length];
            sum1[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                sum1[i] = sum1[i - 1] + nums[i];
            }

            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++){
                int j;
                for(j = 0; j < nums.length; j++){
                    if(sum1[j] > queries[i]){
                        break;
                    }
                }
                res[i] = j;
            }

            return res;
        }


        public int[] answerQueries1(int[] nums, int[] queries) {
            int n = nums.length, m = queries.length;
            Arrays.sort(nums);
            int[] f = new int[n + 1];
            for (int i = 0; i < n; i++) {
                f[i + 1] = f[i] + nums[i];
            }
            int[] answer = new int[m];
            for (int i = 0; i < m; i++) {
                answer[i] = binarySearch(f, queries[i]) - 1;
            }
            return answer;
        }

        public int binarySearch(int[] f, int target) {
            int low = 1, high = f.length;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (f[mid] > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public static void main(String[] args) {
            int[] nums = new int[]{4,5,2,1};
            int[] queries = new int[]{3,10,21};
            answerQueries(nums, queries);
        }

    }

}
