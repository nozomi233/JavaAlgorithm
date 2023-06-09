package main.leetcode;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2023-06-09
 **/
public class LeetCode2699_ModifiedGraphEdges {
    long[] fromDestination;
    int target;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        this.target = target;
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(adjMatrix[i], -1);
        }
        // 邻接矩阵中存储边的下标
        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0], v = edges[i][1];
            adjMatrix[u][v] = adjMatrix[v][u] = i;
        }
        fromDestination = dijkstra(0, destination, edges, adjMatrix);
        if (fromDestination[source] > target) {
            return new int[0][];
        }
        long[] fromSource = dijkstra(1, source, edges, adjMatrix);
        if (fromSource[destination] != target) {
            return new int[0][];
        }
        return edges;
    }

    public long[] dijkstra(int op, int source, int[][] edges, int[][] adjMatrix) {
        // 朴素的 dijkstra 算法
        // adjMatrix 是一个邻接矩阵
        int n = adjMatrix.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        boolean[] used = new boolean[n];
        dist[source] = 0;

        for (int round = 0; round < n - 1; ++round) {
            int u = -1;
            for (int i = 0; i < n; ++i) {
                if (!used[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            used[u] = true;
            for (int v = 0; v < n; ++v) {
                if (!used[v] && adjMatrix[u][v] != -1) {
                    if (edges[adjMatrix[u][v]][2] != -1) {
                        dist[v] = Math.min(dist[v], dist[u] + edges[adjMatrix[u][v]][2]);
                    } else {
                        if (op == 0) {
                            dist[v] = Math.min(dist[v], dist[u] + 1);
                        } else {
                            int modify = (int) (target - dist[u] - fromDestination[v]);
                            if (modify > 0) {
                                dist[v] = Math.min(dist[v], dist[u] + modify);
                                edges[adjMatrix[u][v]][2] = modify;
                            } else {
                                edges[adjMatrix[u][v]][2] = target;
                            }
                        }
                    }
                }
            }
        }

        return dist;
    }
}
