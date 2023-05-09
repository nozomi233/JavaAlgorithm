package main;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于dp(k,n)，枚举第一个鸡蛋扔在x层，由于我们并不知道真正的f值，因而我们必须保证 鸡蛋碎了之后接下来需要的步数 和 鸡蛋没碎之后接下来需要的步数 二者的 最大值 最小，这样就保证了在 最坏的情况下（也就是无论f的值如何），dp(k,n)的值最小
 * @Author zhulang
 * @Date 2023-05-09
 **/
public class LeetCode0887_SuperEggDrop {
    /**
     * 状态转移方程 dp[k][n] = Math.min(res, Math.max(dp[k - 1][i - 1], dp[k][n - i]) + 1);
     * base case
     *
     * 一个鸡蛋，只能线性扫描所有楼层；楼层N = 0时，不需要扔鸡蛋
     * if K == 1: return N
     * if N == 0: return 0
     */
    static class Solution {
        private static Map<String, Integer> memo = new HashMap<>();;

        /**
         * 带备忘录递归，超时
         * O(KN^2)
         * @param k 鸡蛋数
         * @param n 楼高
         * @return
         */
        public int superEggDropRecur(int k, int n) {
            return dpBinarySearch(k, n);
        }

        public static int dpRecur(int k, int n){
            if (k == 1){
                return n;
            }
            if (n == 0){
                return 0;
            }
            String key = k + "_" + n;
            if (memo.containsKey(key)){
                return memo.get(key);
            }

            int res = Integer.MAX_VALUE;

            /**
             * for 从1 --> n 线性查找，可优化为二分查找
             */
            for (int i = 1; i < n + 1; i++){
                res = Math.min(res, Math.max(dpRecur(k - 1,i - 1), dpRecur(k, n - i)) + 1);
            }
            memo.put(key, res);
            return res;
        }

        /**
         * 二分+备忘录，不超时
         * 时间复杂度是 O(K*N*logN), 空间复杂度 O(KN)
         * @param k
         * @param n
         * @return
         */
        public static int dpBinarySearch(int k, int n){
            if (k == 1){
                return n;
            }
            if (n == 0){
                return 0;
            }
            String key = k + "_" + n;
            if (memo.containsKey(key)){
                return memo.get(key);
            }

            int res = Integer.MAX_VALUE;

            int L = 1;
            int R = n;
            while (L <= R){
                // 从mid层扔
                int mid = L + ((R - L) / 2);
                int broke = dpBinarySearch(k - 1, mid - 1);
                int notBroke = dpBinarySearch(k, n - mid);
                // res = min(max(碎，没碎) + 1)
                if (broke > notBroke){
                    R = mid - 1;
                    res = Math.min(res, broke + 1);
                } else {
                    L = mid + 1;
                    res = Math.min(res, notBroke + 1);
                }
            }
            memo.put(key, res);
            return res;
        }



    }

}
