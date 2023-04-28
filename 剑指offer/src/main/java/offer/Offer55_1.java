package offer;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return process(root).height;
    }


    class ReturnType{
        int height;
        boolean isBalance;

        public ReturnType(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public ReturnType process(TreeNode root){
        if (root == null){
            return new ReturnType(0, true);
        }
        ReturnType left = process(root.left);
        ReturnType right = process(root.right);
        if (Math.abs(left.height - right.height) <= 1 && right.isBalance && left.isBalance){
            return new ReturnType(Math.max(left.height, right.height) + 1, true);
        }
        return new ReturnType(Math.max(left.height, right.height) + 1, false);
    }
}
