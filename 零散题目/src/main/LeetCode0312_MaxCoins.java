package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-05-29
 **/
public class LeetCode0312_MaxCoins {
    private Integer res = Integer.MIN_VALUE;

    public int maxCoins(int[] nums) {
        List<Integer> choice = new ArrayList<>();
        for (int i : nums) {
            choice.add(i);
        }
        backTrace(choice, 0);
        return res;
    }

    public void backTrace(List<Integer> choice, int score) {
        if (choice.size() == 0) {
            res = Math.max(score, res);
            return;
        }

        for (int i = 0; i < choice.size(); i++) {
            int point;
            if (choice.size() == 1) {
                point = choice.get(0);
            } else if (i - 1 < 0) {
                point = choice.get(i) * choice.get(i + 1);
            } else if (i + 1 == choice.size()) {
                point = choice.get(i - 1) * choice.get(i);
            } else {
                point = choice.get(i - 1) * choice.get(i) * choice.get(i + 1);
            }
            int temp = choice.get(i);
            choice.remove(i);
            backTrace(choice, score + point);
            choice.add(i, temp);
        }
    }

    public int maxCoinsDP(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = 1;
        points[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            points[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j <= n + 1; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i + 1; k < j; k++) {
                    // 择优做选择，使得 dp[i][j] 最大
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]
                    );
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        LeetCode0312_MaxCoins s = new LeetCode0312_MaxCoins();
        System.out.println(s.maxCoins(nums));
    }
}
