package main.chapter00;

/**
 * 递归方法--(从上至下，增加备忘录记录子问题解)-->备忘录方法--(找到初始值，从下至上记录解)-->DP
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class CoinsAmount {
    /**
     * 凑零钱问题递归方法：
     * 给你 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，
     * 每种硬币的数量⽆限，给⼀个总⾦额 amount ，问你最少需要⼏枚硬币凑出这个⾦额，
     * 如果不可能凑出，算法返回 -1 。
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeRecur(int[] coins, int amount){
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            int subProblem = coinChangeRecur(coins, amount - coin);
            if (subProblem == -1){
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int coinChangeDp(int[] coins, int amount){

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++){
//            此处不能等于最大正数，下面dp[i - coin] + 1会溢出
//            为啥 dp 数组初始化为 amount + 1 呢，因为凑成 amount ⾦额的硬币数最多只可能等于 amount
//            （全⽤ 1 元⾯值的硬币），所以初始化为 amount + 1
//            dp[i] = Integer.MAX_VALUE;
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        for (int i = 0; i <= amount; i++){
            for (int coin : coins){
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]) ;
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        System.out.println(coinChangeRecur(new int[]{1, 2, 5}, 11));
        // 如有{1, 2, 5}三种硬币的话，对于dp[5]，为1 + min(d[4],d[3],d[0]);
        // dp[11]，为1 + min(d[10],d[9],d[6])
        System.out.println(coinChangeDp(new int[]{1, 2, 5}, 11));

    }
}
