package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer43_2 {
    static class CBTInserter {
        private final List<TreeNode> list = new ArrayList<>();

        public CBTInserter(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                list.add(cur);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
        }

        public int insert(int v) {
            TreeNode newNode = new TreeNode(v);
            list.add(newNode);
            // 当前节点下标为 index ，则父节点下标 = (index - 1) / 2
            int index = list.size() - 1;
            TreeNode parent = list.get((index - 1) / 2);
            if (index % 2 == 1) {
                // 新增节点后，index为奇数，则新增节点为左孩子
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return list.get(0);
        }
    }

}
