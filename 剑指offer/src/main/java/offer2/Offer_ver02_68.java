package offer2;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer_ver02_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        // 深度优先遍历找到p,q的路径
        List<TreeNode> pathP = findPath(root, p);
        List<TreeNode> pathQ = findPath(root, q);

        List<TreeNode> shortList = pathP.size() < pathQ.size() ? pathP : pathQ;
        for (int i = 0; i < shortList.size(); i++){
            if (pathP.get(i) != pathQ.get(i)){
                return pathP.get(i - 1);
            }
        }
        return shortList.get(shortList.size() - 1);
    }

    public List<TreeNode> findPath(TreeNode root, TreeNode p){
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        set.add(root);
        if (root == p){
            return stackToList(stack);
        }
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.left != null && !set.contains(cur.left)){
                stack.push(cur);
                stack.push(cur.left);
                set.add(cur.left);
                if (cur.left == p){
                    return stackToList(stack);
                }
                continue;
            }
            if (cur.right != null && !set.contains(cur.right)){
                stack.push(cur);
                stack.push(cur.right);
                set.add(cur.right);
                if (cur.right == p){
                    return stackToList(stack);
                }
            }
        }
        // 没有路径到p点
        return null;
    }

    private List<TreeNode> stackToList(Stack<TreeNode> stack){
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(0, stack.pop());
        }
        return list;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        return left == null ? right : left;

    }
}
