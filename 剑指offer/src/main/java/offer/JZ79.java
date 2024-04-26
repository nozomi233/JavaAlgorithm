package offer;

/**
 * @Author Nozomi
 * @Date 2024/4/26 10:34
 */

public class JZ79 {
    // {1,2,#,3,#,4,#,5}
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
        if (pRoot == null){
            return true;
        }

        return (Math.abs(depth(pRoot.left) - depth(pRoot.right)) <= 1) && IsBalanced_Solution(pRoot.left) && IsBalanced_Solution(pRoot.right);

    }

    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(depth(root.left), depth(root.right))  + 1;
    }

}
