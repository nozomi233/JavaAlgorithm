package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-05-15
 **/
public class Offer53_2 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        List<TreeNode> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        int i = inorderList.indexOf(p);
        if (i == inorderList.size()){
            return null;
        }
        return inorderList.get(i + 1);
    }

    public void inorder(TreeNode root, List<TreeNode> inorderList){
        if (root == null){
            return;
        }

        inorder(root.left, inorderList);

        inorderList.add(root);

        inorder(root.right, inorderList);
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }


}
