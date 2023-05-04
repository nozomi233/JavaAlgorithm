package offer;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-05-04
 **/
public class Offer32_3 {
    static class Solution {
        /**
         * 也可以用双端队列，略
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null){
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int flag = 1;
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if (flag == 1){
                        list.add(cur.val);
                    } else {
                        list.add(0,cur.val);
                    }

                    if (cur.left != null){
                        queue.offer(cur.left);
                    }
                    if (cur.right != null){
                        queue.offer(cur.right);
                    }
                }
                res.add(list);
                flag = -flag;
            }
            return res;
        }
    }
}
