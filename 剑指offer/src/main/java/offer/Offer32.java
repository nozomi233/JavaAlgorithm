package offer;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
