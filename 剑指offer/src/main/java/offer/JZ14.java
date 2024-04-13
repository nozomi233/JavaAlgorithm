package offer;

public class JZ14 {
    public int cutRope (int n) {
        // write code here

        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < n + 1; i++){
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }
}
