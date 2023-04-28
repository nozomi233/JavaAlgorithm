package chapter00;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法框架
 * @Author zhulang
 * @Date 2023-04-27
 **/
public class AlgorithmFramework {
    /**
     * 数组遍历框架，典型的线性迭代结构：
     * @param arr
     */
    void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 迭代访问 arr[i] } }
        }
    }

    /**
     * 链表遍历框架，兼具迭代和递归结构：
     */
    class ListNode {
        int val;
        ListNode next;
    }
    void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代访问 p.val } }
        }
    }

    void traverseRecur(ListNode head) {
        // 递归访问 head.val
        // traverse(head.next)
    }


    /**
     * ⼆叉树遍历框架，典型的⾮线性递归遍历结构：
     */
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    void traverse(TreeNode root) {
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * ⼆叉树框架可以扩展为 N 叉树的遍历框架：
     */
    /* 基本的 N 叉树节点 */
    class TreeNodeN {
        int val;
        TreeNodeN[] children;
    }

    void traverse(TreeNodeN root) {
        for (TreeNodeN child : root.children) {
            traverse(child) ;
        }
    }

    /**
     * 路径列表
     */
    private final List<List<Integer>> pathList = new ArrayList<>();

    /**
     * 回溯算法框架
     * @param path 路径
     * @param choices 选择列表
     */
    void backtrack(List<Integer> path, List<Integer> choices){
        // if 满足结束条件 ,假设做10次选择后结束
        if (path.size() == 10){
            pathList.add(path);
            return;
        }

        // for 选择 in 选择列表
        for (Integer choice : choices){
            // 做选择
            path.add(choice);
            backtrack(path, choices);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }

}