package offer;

/**
 * @Author Nozomi
 * @Date 2024/4/26 10:46
 */

public class JZ76 {
    public ListNode deleteDuplication(ListNode pHead) {
        //空链表
        if (pHead == null)
            return null;
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = pHead;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            //遇到相邻两个节点值相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                //将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp)
                    cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        //返回时去掉表头
        return res.next;
    }

}
