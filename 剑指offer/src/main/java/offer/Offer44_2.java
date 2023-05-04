package offer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhulang
 * @Date 2023-05-04
 **/
public class Offer44_2 {
    static class Solution {

        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> lists = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode cur = queue.poll();
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
                lists.add(list);

            }
            return lists.stream().map(Collections::max).collect(Collectors.toList());

        }

        /**
         * 广度优先，层序
         * @param root
         * @return
         */
        public List<Integer> largestValues1(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < len; i++) {
                    TreeNode cur = queue.poll();
                    max = Math.max(max, cur.val);
                    if (cur.left != null){
                        queue.offer(cur.left);
                    }
                    if (cur.right != null){
                        queue.offer(cur.right);
                    }
                }
                res.add(max);
            }
            return res;
        }

        public List<Integer> largestValuesDfs(TreeNode root) {
            if (root == null){
                return Collections.emptyList();
            }

            List<Integer> res = new ArrayList<>();
            dfs(res, root, 0);
            return res;
        }

        private void dfs(List<Integer> res, TreeNode node, int curHeight){
            if (curHeight == res.size()){
                res.add(node.val);
            } else {
                res.set(curHeight, Math.max(res.get(curHeight), node.val));
            }
            if (node.left != null){
                dfs(res, node.left, curHeight + 1);
            }
            if (node.right != null){
                dfs(res, node.right, curHeight + 1);
            }
        }
    }
}
