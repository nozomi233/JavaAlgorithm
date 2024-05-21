package offer;

/**
 * @Author Nozomi
 * @Date 2024/4/26 9:54
 */

public class JZ84 {
    private int res = 0;
    //dfs查询以某结点为根的路径数
    private void dfs(TreeNode root, int sum){
        if(root == null)
            return;
        //符合目标值
        if(sum == root.val){
            res++;
        }

        //进入子节点继续找，即时下面相等也有可能下面值为 -1 ， +1 ，依然等于sum,所以要注意终止条件，只有root为nulll终止
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
    //dfs 以每个结点作为根查询路径
    public int FindPath (TreeNode root, int sum) {
        //为空则返回
        if(root == null)
            return res;
        //查询以某结点为根的路径数
        dfs(root, sum);
        //以其子结点为新根，因为有可能是子节点开始的路径
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        return res;
    }
}
