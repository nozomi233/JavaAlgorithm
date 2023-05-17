package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-05-17
 **/
public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        if (root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, target - root.val, res, path);
        return res;

    }

    public void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> path){
        if (target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            return;
        }


        if (root.left != null){
            path.add(root.left.val);
            dfs(root.left, target - root.left.val, res, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null){
            path.add(root.right.val);
            dfs(root.right, target - root.right.val, res, path);
            path.remove(path.size() - 1);
        }
    }
}
