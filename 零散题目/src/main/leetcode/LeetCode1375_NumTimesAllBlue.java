package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-14
 **/
public class LeetCode1375_NumTimesAllBlue {


    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int ans = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, flips[i]);
            if (right == i + 1) {
                ++ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] flips = new int[]{3,2,4,1,5};
        LeetCode1375_NumTimesAllBlue l = new LeetCode1375_NumTimesAllBlue();
        System.out.println(l.numTimesAllBlue(flips));
    }
}
