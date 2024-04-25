package offer;

import java.util.*;

public class JZ86 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        parentMap.put(root.val, Integer.MIN_VALUE);

        while (!queue.isEmpty()){
            if (parentMap.containsKey(o1)  && parentMap.containsKey(o2)){
                break;
            }
            TreeNode cur = queue.poll();
            if (cur.left != null){
                queue.offer(cur.left);
                parentMap.put(cur.left.val, cur.val);
            }
            if (cur.right!= null){
                queue.offer(cur.right);
                parentMap.put(cur.right.val, cur.val);
            }
        }

        Set<Integer> o1ParentSet = new HashSet<>();

        while (parentMap.containsKey(o1)){
            o1ParentSet.add(o1);
            o1 = parentMap.get(o1);
        }


        while (!o1ParentSet.contains(o2)){
            o2 = parentMap.get(o2);
        }
        return o2;
    }


    public int lowestCommonAncestorRecur (TreeNode root, int o1, int o2) {
        // write code here
        if (root == null){
            return -1;
        }
        return recurHelper(root, o1, o2).val;

    }

    public TreeNode recurHelper(TreeNode root, int o1, int o2){
        if (root == null || root.val == o1 || root.val == o2){
            return root;
        }

        TreeNode left = recurHelper(root.left, o1,o2);
        TreeNode right = recurHelper(root.right, o1, o2);

        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}
