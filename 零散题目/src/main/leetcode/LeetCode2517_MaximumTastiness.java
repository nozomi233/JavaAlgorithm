package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-06-01
 **/
public class LeetCode2517_MaximumTastiness {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] price, int k, int tastiness) {
        int prev = Integer.MIN_VALUE / 2;
        int cnt = 0;
        // 贪心，如price = 1， 2， 3， 4， 7； 甜度 tastiness 要>=3，则选择1，4，7；不可能在1-4中间选，因为只要选了2/3，最小值就小于tastiness了，所以pre = p
        for (int p : price) {
            if (p - prev >= tastiness) {
                cnt++;
                prev = p;
            }
        }
        return cnt >= k;
    }



    public static void main(String[] args) {
        int[] price = new int[]{13,5,1,8,21,2};
        LeetCode2517_MaximumTastiness l = new LeetCode2517_MaximumTastiness();
        System.out.println(l.maximumTastiness(price, 3));
    }
}
