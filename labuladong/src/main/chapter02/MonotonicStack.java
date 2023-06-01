package main.chapter02;

import java.util.List;
import java.util.Stack;

/**
 * @Author zhulang
 * @Date 2023-06-01
 **/
public class MonotonicStack {
    public int[] nextGreaterElement(int[] nums){
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // 这个元素身后的第一个高个
            ans[i] = s.empty() ? -1 : s.peek();
            // 进队，接受之后的身高判定吧！
            s.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,1,2,4,3};
        MonotonicStack m = new MonotonicStack();
        int[] res = m.nextGreaterElement(nums);
        for (int i : res){
            System.out.println(i);
        }
    }
}
