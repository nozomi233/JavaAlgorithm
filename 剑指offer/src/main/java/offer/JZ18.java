package offer;

public class JZ18 {
    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        if (head.val == val){
            return head.next;
        }
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        pre.next = cur;

        while (cur.next != null){

            if (cur.val == val){
                // 删除节点
                pre.next = cur.next;
                return head;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return head;
    }
}
