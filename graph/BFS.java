import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class BFS {
    // bfs:min-path
    public static void bfs(Graph graph, int start) {
        // DS
        boolean[] visited = new boolean[graph.size()];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // res
        int step = 0;
        // bfs
        while (!q.isEmpty()) {
            // count level
            int sz = q.size();
            // traverse level
            for (int i = 0; i < sz; i++) {
                // poll
                int curVert = q.poll();
                // offer
                for (Edge edge : graph.neighbors(curVert)) {
                    int toVert = edge.to;
                    // jump visited
                    if (!visited[toVert]) {
                        q.offer(toVert);
                        visited[toVert] = true;
                    }
                }
            }
            ++step;
        }
        // return res
        return steps
    }

    // bfs:weighted-path-sum
    private static class State {
        // states
        int node;
        int weight; // from start to cur node
        // constructor
        public State(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static void vfs(Graph, graph, int start) {
        // DS
        boolean[] visited = new boolean[graph.size()];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(start, 0));
        visited[start] = true;
        // bfs
        while (!q.isEmpty()) {
            // poll
            State curState = q.poll();
            int curNode = curState.node;
            int curWieght = curState.weight;
            // offer
            for (Edge edge : graph.neighbors(curNode)) {
                int toNode = edge.to;
                if (!visted[toNode]) {
                    q.offer(new State(toNode, curWeight+toNode.weight));
                    visited[toNode] = true;
                }
            }
        }
    }

    // bfs:Dijkstra
    private static class State {
        // states
        int id;
        int distFromStart;
        // constructor
        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public int weight(int from, int to) {}

    public List<Integer> neighbors(int start) {}

    public int[] dijkstra(int start, List<Integer>[] graph) { // O(ElogV)
        // consts
        int V = graph.length;
        // DS
        int[] distTo = new int[V]; // distTo[i]: min sum wts start to i
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        pq.offer(new State(start, 0));
        // bfs
        while (!pq.isEmpty()) {
            // poll
            State curState = pq.poll();
            int curId = curState.id;
            int curDistFromStart = curState.distFromStart;
            // jump larger dist
            if (curDistFromStart > distTo[curId])
                continue;
            // offer
            for (int nextId : neighbors(curId)) {
                int distToNext = distTo[curId] + weight(curId, nextId);
                if (distTo[nextId] > distToNext) {
                    distTo[nextId] = disToNext;
                    pq.offer(new State(nextId, distToNext));
                }
            }
        }
        // return res
        return distTo;
    }
}
