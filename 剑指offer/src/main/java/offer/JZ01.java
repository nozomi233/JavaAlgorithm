package offer;

import java.util.ArrayList;

public class JZ01 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = listNode;
        ListNode pre = null;
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
}
