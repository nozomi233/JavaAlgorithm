package offer;

public class JZ25 {
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        // 1-3-5 2-4-6-8
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }

        if (pHead1 != null){
            cur.next = pHead1;
        }

        if (pHead2 != null){
            cur.next = pHead2;
        }

        return head.next;
    }


}
