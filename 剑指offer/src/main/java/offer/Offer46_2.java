package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer46_2 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>(len);
            for (int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }

        List<Integer> res = lists.stream().map(r -> {
            return r.get(r.size() - 1);
        }).collect(Collectors.toList());
        return res;
    }

    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) {
            // 这个深度首次遇到
            ans.add(root.val);
        }
        dfs(root.right, depth + 1); // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1);
    }
}
