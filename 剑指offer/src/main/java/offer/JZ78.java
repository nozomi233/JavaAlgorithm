package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Nozomi
 * @Date 2024/4/26 11:05
 */

public class JZ78 {
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        // write code here
        if (pRoot == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int len = queue.size();
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(row);
        }
        return res;
    }
}
