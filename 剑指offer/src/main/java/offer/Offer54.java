package offer;

/**
 * @Author zhulang
 * @Date 2023-05-15
 **/
public class Offer54 {
    int res;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;

        reInorder(root);
        return res;
    }

    public void reInorder(TreeNode root){
        if (root == null){
            return;
        }

        reInorder(root.right);

//        if (k == 0){
//            return;
//        }
        if (--k == 0){
            res = root.val;
            return;
        }

        reInorder(root.left);
    }
}
