package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer48_2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "#_";
        }
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++){
            queue.add(values[i]);
        }

        return reconPreOrder(queue);

    }
    public TreeNode reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
