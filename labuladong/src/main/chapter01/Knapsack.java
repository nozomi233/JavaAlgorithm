package main.chapter01;

/**
 * @Author zhulang
 * @Date 2023-05-09
 **/
public class Knapsack {


    /**
     * 0 - 1 背包
     * @param bag
     * @param wt
     * @param val
     * @return
     */
    public static int knapsack(int bag, int[] wt, int[] val){
        return process(wt, val, 0, 0, bag);
    }

    private static int process(int[] wt, int[] val, int index, int alreadyWt, int bag){
        if (alreadyWt > bag){
            return -1;
        }

        if (index == wt.length){
            return 0;
        }

        // index 不放入袋子
        int p1 = process(wt, val, index + 1, alreadyWt ,bag);

        int p2next = process(wt, val, index + 1, alreadyWt + wt[index] ,bag);
        int p2 = -1;
        if (p2next != -1){
            p2 = p2next + val[index];
        }
        return Math.max(p1, p2);
    }

    /**
     * base case 就是dp[0][..] = dp[..][0] = 0，因为没有物品或者背包没有空间的时候，能装的最大价值就是 0。
     * @param W
     * @param wt
     * @param val
     * @return
     */
    public static int knapsackDP(int W, int[] wt, int[] val){
        int N = wt.length;
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++){
            for (int w = 0; w <= W; w++){
                if (w - wt[i - 1] < 0){
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - wt[i-1]] + val[i-1]);
                }

            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int bag = 4;
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        System.out.println(knapsack(bag, wt, val));
        System.out.println(knapsackDP(bag,wt, val));
    }
}
