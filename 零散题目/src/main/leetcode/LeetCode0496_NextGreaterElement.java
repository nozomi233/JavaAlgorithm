package main.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author zhulang
 * @Date 2023-06-01
 **/
public class LeetCode0496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = nextGreaterElement(nums2);
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public Map<Integer, Integer> nextGreaterElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // 这个元素身后的第一个高个
            map.put(nums[i], s.empty() ? -1 : s.peek());
            // 进队，接受之后的身高判定吧！
            s.push(nums[i]);
        }
        return map;
    }
}
