package offer;

import java.util.Arrays;

public class JZ85 {
    public int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int n = array.length;
        // 以下标i为终点的最大连续子数组和
        int[] dp = new int[n];
        dp[0] = array[0];
        int maxsum = dp[0];
        int left = 0;
        int right = 0;
        int resl = 0;
        int resr = 0;
        for (int i = 1; i < n; i++) {
            right++;
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i - 1] + array[i] < array[i]){
                left = right;
            }
            if (dp[i] > maxsum || (dp[i] == maxsum &&
                    (right - left + 1) > (resr - resl + 1))){
                maxsum = dp[i];
                resl = left;
                resr = right;
            }
        }
        return Arrays.copyOfRange(array, resl, resr + 1);
        // dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
    }

    /**
     * 返回最大子数组的和
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArraySum (int[] array) {
        // write code here
        int n = array.length;
        int[] prefix = new int[n];
        // 记录前N个前缀和中最小的那个
        int[] prefixMin = new int[n];
        prefix[0] = array[0];
        prefixMin[0] = prefix[0];
        // O(n)
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + array[i];
            // 记录下最小的前缀和
            prefixMin[i] = Math.min(prefix[i], prefixMin[i - 1]);
        }

        // dp代表到长度为n时，子数组的最大和
        int[] dp = new int[n];
        dp[0] = array[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prefix[i] - prefixMin[i]);
        }
        return dp[n - 1];


    }

    public static void main(String[] args) {
        JZ85 j = new JZ85();
        System.out.println(j.FindGreatestSumOfSubArraySum(new int[]{-1,-2,-3,-4,5}));
        System.out.println(Arrays.toString(j.FindGreatestSumOfSubArray(new int[]{-1,-2,-3,-4,5})));
    }
}
