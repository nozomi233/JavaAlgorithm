package main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author zhulang
 * @Date 2023-05-04
 **/
public class LeetCode0111_MinDepth {
    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int res = 1;
            while (!q.isEmpty()){
                int len = q.size();
                for (int i = 0; i < len; i++){
                    TreeNode cur = q.poll();
                    /* 到达叶子节点 */
                    if (cur.left == null && cur.right == null){
                        return res;
                    }
                    if (cur.left != null){
                        q.offer(cur.left);
                    }
                    if (cur.right != null){
                        q.offer(cur.right);
                    }
                }
                res += 1;
            }
           return res;
        }
    }
}
