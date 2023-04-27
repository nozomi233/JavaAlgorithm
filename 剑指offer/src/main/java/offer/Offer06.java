package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author zhulang
 * @Date 2023-03-04
 **/
public class Offer06 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static class Solution {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        public int[] reversePrint2(ListNode head) {
            recur(head);
            int[] res = new int[tmp.size()];
            for(int i = 0; i < res.length; i++) {
                res[i] = tmp.get(i);
            }
            return res;
        }
        void recur(ListNode head) {
            if(head == null) {
                return;
            }
            recur(head.next);
            tmp.add(head.val);
        }


        public int[] reversePrint(ListNode head) {
            List<Integer> ls = new ArrayList();
            if(Objects.isNull(head)) {
                return ls.stream().mapToInt(Integer::intValue).toArray();
            }
            ls.add(0,head.val);
            while (Objects.nonNull(head.next)){
                head = head.next;
                ls.add(0,head.val);
            }
            return ls.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
