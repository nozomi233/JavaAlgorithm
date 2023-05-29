package main.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zhulang
 * @Date 2022-12-19
 **/
public class LeetCode1971_ValidPath {
    static class Solution {
        public boolean validPath1(int n, int[][] edges, int source, int destination) {
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                adj[x].add(y);
                adj[y].add(x);
            }

            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new ArrayDeque<Integer>();
            queue.offer(source);
            visited[source] = true;
            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                if (vertex == destination) {
                    break;
                }
                for (int next : adj[vertex]) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            return visited[destination];
        }

        public boolean validPath2(int n, int[][] edges, int source, int destination) {
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                adj[x].add(y);
                adj[y].add(x);
            }

            boolean[] visited = new boolean[n];

            return dfs(source, destination, adj, visited);
        }

        public boolean dfs(int source, int destination, List<Integer>[] adj, boolean[] visited) {
            if(source == destination){
                return true;
            }
            visited[source] = true;
            for(int next : adj[source]){
                if(!visited[next] && dfs(next, destination, adj, visited)){
                    return true;
                }
            }

            return false;
        }

        public boolean validPath3(int n, int[][] edges, int source, int destination) {
            if (source == destination) {
                return true;
            }
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.uni(edge[0], edge[1]);
            }
            return uf.connect(source, destination);
        }
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public void uni(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]){
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }

        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean connect(int x, int y) {
            return find(x) == find(y);
        }
    }
}
