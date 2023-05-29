package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-05-18
 **/
public class LeetCode0019_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;

        while (n != 0){
            fast = fast.next;
            n--;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return pre.next;
    }
}
