package offer;

public class JZ24 {
    public ListNode reverseList (ListNode head) {
        // 1-2-3-4
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
