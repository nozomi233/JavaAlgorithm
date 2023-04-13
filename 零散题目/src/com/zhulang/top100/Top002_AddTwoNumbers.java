package com.zhulang.top100;

/**
 * @Author zhulang
 * @Date 2023-04-09
 **/
public class Top002_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;
        int nextBit = 0;
        while (l1 != null && l2 != null){
            ListNode cur = new ListNode();
            pre.next = cur;
            int sum = l1.val + l2.val + nextBit;
            cur.val = sum % 10;
            nextBit = sum / 10;
            pre  = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            ListNode cur = new ListNode();
            pre.next = cur;
            int sum = l1.val + nextBit;
            cur.val = sum % 10;
            pre  = pre.next;
            nextBit = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode cur = new ListNode();
            pre.next = cur;
            int sum = l2.val + nextBit;
            cur.val = sum % 10;
            pre  = pre.next;
            nextBit = sum / 10;
            l2 = l2.next;
        }
        if (nextBit != 0){
            ListNode cur = new ListNode();
            pre.next = cur;
            cur.val = nextBit;
        }
        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
