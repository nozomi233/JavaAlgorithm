package main.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-05-29
 **/
public class LeetCode0877_StoneGame {
    public boolean stoneGame(int[] piles) {
        int my = firstHand(piles, 0, piles.length - 1);
        int sum = 0;
        for (int i : piles){
            sum += i;
        }
        return my > (sum / 2);
    }

    public int secondHand(int[] piles, int start, int end){
        if (start == end){
            return 0;
        }
        return Math.min(firstHand(piles, start, end - 1), firstHand(piles, start + 1, end));
    }

    public int firstHand(int[] piles, int start, int end){
        if (start == end){
            return piles[start];
        }
        return Math.max(piles[start] + secondHand(piles, start + 1, end), piles[end] + secondHand(piles, start, end - 1));
    }

    public static void main(String[] args) {
        int[] piles = new int[]{2, 1, 9, 5};
        LeetCode0877_StoneGame s = new LeetCode0877_StoneGame();
        System.out.println(s.stoneGame(piles));
    }
}
