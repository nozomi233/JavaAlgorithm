package main;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-04-10
 **/
public class LeetCode1019_NextLargerNodes {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> ans = new ArrayList<Integer>();
            Deque<int[]> stack = new ArrayDeque<int[]>();

            ListNode cur = head;
            int idx = -1;
            while (cur != null) {
                ++idx;
                ans.add(0);
                while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                    ans.set(stack.pop()[1], cur.val);
                }
                stack.push(new int[]{cur.val, idx});
                cur = cur.next;
            }

            int size = ans.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; ++i) {
                arr[i] = ans.get(i);
            }
            return arr;
        }
    }
}
