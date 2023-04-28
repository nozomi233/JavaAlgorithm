package offer;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val == q.val && check(p.left, q.right) && check(p.right, q.left)){
            return true;
        }
        return false;
    }
}
