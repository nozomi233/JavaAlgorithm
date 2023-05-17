package offer;

/**
 * @Author zhulang
 * @Date 2023-05-16
 **/
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return ((A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
