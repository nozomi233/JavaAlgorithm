package offer;

import offer2.TreeNode;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

}
