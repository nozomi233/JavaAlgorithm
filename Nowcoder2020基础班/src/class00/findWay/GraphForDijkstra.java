package class00.findWay;

import java.util.LinkedList;

/**
 * @Author zhulang
 * @Date 2023-04-20
 **/

public class GraphForDijkstra { // 有向有权图的邻接表表示
    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    public GraphForDijkstra(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重
        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }
    // 下面这个类是为了dijkstra实现用的
    private class Vertex {
        public int id; // 顶点编号ID
        public int dist; // 从起始顶点到这个顶点的距离
        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    private class PriorityQueue { // 根据vertex.dist构建小顶堆
        private Vertex[] nodes;
        private int count;
        public PriorityQueue(int v) {
            this.nodes = new Vertex[v+1];
            this.count = v;
        }
        public Vertex poll() {
            // TODO: 留给读者实现...
            return null;
        }
        public void add(Vertex vertex) {
            // TODO: 留给读者实现...
        }
        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
        public void update(Vertex vertex) {
            // TODO: 留给读者实现...

        }
        public boolean isEmpty() {
            // TODO: 留给读者实现...
            return false;
        }
    }

    /**
     * 从顶点s到顶点t的最短路径
     * @param s
     * @param t
     */
    public void dijkstra(int s, int t) {
        // 用来还原最短路径
        int[] predecessor = new int[this.v];
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; ++i) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // 小顶堆
        PriorityQueue queue = new PriorityQueue(this.v);
        // 标记是否进入过队列
        boolean[] inQueue = new boolean[this.v];
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inQueue[s] = true;
        while (!queue.isEmpty()) {
            // 取堆顶元素并删除
            Vertex minVertex= queue.poll();
            // 最短路径产生了
            if (minVertex.id == t) {
                break;
            }
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                // 取出一条minVetex相连的边
                Edge e = adj[minVertex.id].get(i);
                // minVertex-->nextVertex
                Vertex nextVertex = vertexes[e.tid];
                // 更新next的dist
                if (minVertex.dist + e.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inQueue[nextVertex.id] == true) {
                        // 更新队列中的dist值
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) {
            return;
        }
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }

}
