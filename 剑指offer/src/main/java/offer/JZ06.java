package offer;

import java.util.ArrayList;
import java.util.List;

public class JZ06 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode pre = null;
        ListNode head = listNode;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (pre != null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }

    public ListNode reverseList(ListNode listNode){
        ListNode pre = null;
        ListNode head = listNode;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
