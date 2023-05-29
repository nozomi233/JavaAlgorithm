package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-04-18
 **/
public class LeetCode1026_MaxAncestorDiff {

    public static class ReturnData {
        public int max;
        public int min;
        public int absGap;


        public ReturnData(int max, int min, int absGap) {
            this.max = max;
            this.min = min;
            this.absGap = absGap;
        }
    }

    static class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return process(root).absGap;
        }

        public static ReturnData process(TreeNode x) {
            if (x.left == null && x.right == null){
                return new ReturnData(x.val,x.val, 0);
            }
            if (x.right == null){
                ReturnData leftData = process(x.left);
                int max = Math.max(x.val, leftData.max);
                int min = Math.min(x.val, leftData.min);
                int a = Math.abs(x.val - leftData.max);
                int b = Math.abs(x.val - leftData.min);
                int absGapFather = Math.max(a,b);
                int absGap = Math.max(absGapFather, leftData.absGap);
                return new ReturnData(max, min, absGap);
            }
            if (x.left == null){
                ReturnData returnData = process(x.right);
                int max = Math.max(x.val, returnData.max);
                int min = Math.min(x.val, returnData.min);
                int a = Math.abs(x.val - returnData.max);
                int b = Math.abs(x.val - returnData.min);
                int absGapFather = Math.max(a,b);
                int absGap = Math.max(absGapFather, returnData.absGap);
                return new ReturnData(max, min, absGap);
            }

            ReturnData leftData = process(x.left);
            ReturnData rightData = process(x.right);
            int max = Math.max(x.val, Math.max(leftData.max, rightData.max));
            int min = Math.min(x.val, Math.min(leftData.min, rightData.min));
            int a = Math.abs(x.val - leftData.max);
            int b = Math.abs(x.val - leftData.min);
            int c = Math.abs(x.val - rightData.max);
            int d = Math.abs(x.val - rightData.min);
            int absGapFather = Math.max(Math.max(a,b), Math.max(c,d));
            int absGapChild = Math.max(rightData.absGap, leftData.absGap);
            int absGap = Math.max(absGapChild, absGapFather);
            return new ReturnData(max, min, absGap);
        }
    }

    public int maxAncestorDiff2(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mi, int ma) {
        if (root == null) {
            return 0;
        }
        int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        mi = Math.min(mi, root.val);
        ma = Math.max(ma, root.val);
        diff = Math.max(diff, dfs(root.left, mi, ma));
        diff = Math.max(diff, dfs(root.right, mi, ma));
        return diff;
    }
}
