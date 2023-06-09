package offer;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer47_2 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left != null || right != null || root.val == 1) {
            root.left = left;
            root.right = right;
            return root;
        }
        return null;
    }
}


