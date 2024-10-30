import java.util.List;
import java.util.ArrayList;

public class AdjMatWeightedDigraph {
    // nested class
    public static class Edge {
        // states
        int to;
        int weight;
        // constructor
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // state
    private int[][] graph;

    // constructor
    public AdjMatWeightedDigraph(int numVert) {
        graph = new int[numVert][numVert];
    }

    // create method
    public void addEdge(int from, int to, int weight) {
        graph[from][to] = weight;
    }

    // readin methods
    public boolean hasEdge(int from, int to) {
        return graph[from][to] != 0;
    }
    public int weight(int from, int to) {
        return graph[from][to];
    }
    public List<Edge> neighbors(int vert) {
        List<Edge> adjVerts = new ArrayList<>();
        for (int i = 0; i < graph[vert].length; i++) {
            if (graph[vert][i] > 0)
                adjVerts.add(new Edge(i, graph[vert][i]));
        }
        return adjVerts;
    }

    // delete method
    public void removeEdge(int from, int to) {
        graph[from][to] = 0;
    }

    // unit test
    public static void main(String[] args) {
        AdjMatWeightedDigraph graph = new AdjMatWeightedDigraph(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);
        System.out.println(graph.hasEdge(0, 1));
        System.out.println(graph.hasEdge(1, 0));
        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", weight: " + edge.weight);
        });
        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1));
    }
}
