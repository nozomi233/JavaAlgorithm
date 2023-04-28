package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer45_2 {
    public int findBottomLeftValue(TreeNode root) {
        List<List<TreeNode>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<TreeNode> list = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                list.add(cur);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }

            lists.add(list);
        }
        return lists.get(lists.size() - 1).get(0).val;
    }
}
