package main.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author zhulang
 * @Date 2023-06-01
 **/
public class LeetCode0503_NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--){
            while (!s.isEmpty() && s.peek() <= nums[i % n]){
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 :  s.peek();
            s.push(nums[i % n]);
        }

        return res;
    }

    public int[] nextGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,1,2,4,3}; // {4,2,4,-1,-1}
        LeetCode0503_NextGreaterElements m = new LeetCode0503_NextGreaterElements();
        int[] res = m.nextGreaterElements(nums);
        for (int i : res){
            System.out.println(i);
        }
    }
}
