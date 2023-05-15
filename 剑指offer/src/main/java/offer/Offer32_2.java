package offer;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-05-15
 **/
public class Offer32_2 {
    // 层序，bfs
    public List<List<Integer>> levelOrderBfs(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                sub.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(sub);
        }
        return res;
    }


    // 层序 dfs
    public static List<List<Integer>> levelOrderDfs(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> resLevelZl = new ArrayList<>();

        List<Integer> sub = new ArrayList<>();
        sub.add(root.val);
        resLevelZl.add(sub);

        if (root.left != null){
            backTrace(root.left, 1, resLevelZl);
        }

        if (root.right != null){
            backTrace(root.right, 1, resLevelZl);
        }
        return resLevelZl;
    }

    public static void backTrace(TreeNode root, int height, List<List<Integer>> resLevelZl){

        if (resLevelZl.size() == height){
            List<Integer> sub = new ArrayList<>();
            sub.add(root.val);
            resLevelZl.add(sub);
        } else {
            resLevelZl.get(height).add(root.val);
        }


        if (root.left != null){
            backTrace(root.left, height + 1, resLevelZl);
        }

        if (root.right != null){
            backTrace(root.right, height + 1, resLevelZl);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);

        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        levelOrderDfs(head);

        // recursive

    }


}
