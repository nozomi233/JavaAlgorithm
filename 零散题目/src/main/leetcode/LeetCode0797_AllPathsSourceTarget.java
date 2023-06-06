package main.leetcode;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-06-06
 **/
public class LeetCode0797_AllPathsSourceTarget {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return ans;
    }

    /* 图的遍历框架 */
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        // 添加节点 s 到路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            ans.add(new LinkedList<>(path));
            // 每次add 都要有一次remove，上面有add哪怕这里返回也要remove，否则有错误；下面dfs法，add和remove都在for循环内，也是一一对应的
            path.removeLast();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.removeLast();
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        LeetCode0797_AllPathsSourceTarget l = new LeetCode0797_AllPathsSourceTarget();
        System.out.println(l.allPathsSourceTarget1(graph));
    }
}


