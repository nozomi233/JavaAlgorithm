package main.chapter00;

import java.util.*;

/**
 * 算法框架
 *
 * @Author zhulang
 * @Date 2023-04-27
 **/
public class AlgorithmFramework {
    /**
     * 数组遍历框架，典型的线性迭代结构：
     *
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
            traverse(child);
        }
    }

    /**
     * 路径列表
     */
    private final List<List<Integer>> pathList = new ArrayList<>();

    /**
     * 回溯算法框架(dfs)
     *
     * @param path    路径
     * @param choices 选择列表
     */
    void backtrack(List<Integer> path, List<Integer> choices) {
        // if 满足结束条件 ,假设做10次选择后结束
        if (path.size() == 10) {
            pathList.add(path);
            return;
        }

        // for 选择 in 选择列表
        for (Integer choice : choices) {
            // 做选择
            path.add(choice);
            backtrack(path, choices);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }

    /**
     * 计算从起点 start 到终点 target 的最近距离
     *
     * @param start
     * @param target
     * @return
     */
    int bfs(Node start, Node target) {
        // 核⼼数据结构
        Queue<Node> q = new LinkedList<>();
        // 避免⾛回头路
        Set<Node> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);
        int step = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            // 将当前队列节点向四周扩散
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                /* 划重点：这⾥判断是否到达终点 */
                if (cur == target) {
                    return step;
                }
                /* 将 cur 的相邻节点加⼊队列 */
                for (Node next : cur.nexts) {
                    /**
                     * 队列 q 就不说了，BFS 的核⼼数据结构； cur.nexts 泛指 cur 相邻的节点;
                     * visited 的主要作⽤是防⽌⾛回头路，⼤部分时候都是必须的，但是像⼀般的⼆叉树结构，
                     * 没有⼦节点到⽗节点的指针，不会⾛回头路就不需要 visited 。
                     */
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            /* 划重点：更新步数在这⾥ */
            step++;
        }
        return step;
    }


}