package offer;

public class JZ23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        boolean hasLoop = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                hasLoop = true;
                break;
            }
        }
        if (!hasLoop){
            return null;
        }
        while (pHead != slow){
            pHead = pHead.next;
            slow = slow.next;
        }

        return pHead;

    }
}
