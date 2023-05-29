package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-05-29
 **/
public class LeetCode0319_BulbSwitch {
    public int bulbSwitch(int n) {
        int[] bulb = new int[n + 1];

        for (int j = 1; j <= n; j++){
            for (int m = 0; m <= n; m += j){
                bulb[m] = bulb[m] == 0 ? 1 : 0;
            }
        }

        int res = 0;
        for (int i : bulb){
            res += i;
        }
        return res - bulb[0];
    }

    public static void main(String[] args) {
        LeetCode0319_BulbSwitch s = new LeetCode0319_BulbSwitch();
        System.out.println(s.bulbSwitch(3));
    }
}
