import java.util.List;
import java.util.ArrayList;

public class AdjListWeightedDigraph {
    // nested class
    public static class Edge { // stores adj verts + their weights
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
    private List<Edge>[] graph;

    // constructor
    @SuppressWarnings("unchecked")
    public WeightedDigraph(int numVert) {
        graph = new List[numVert];
        for (int i = 0; i < numVert; i++)
            graph[i] = new ArrayList<>();
    }

    // create method
    public void addEdge(int from, int to, int weight) {
        graph[from].add(new Edge(to, weight));
    }

    // readin methods
    public boolean hasEdge(int from, int to) {
        for (Edge edge : graph[from])
            if (edge.to == to)
                return true;
        return false;
    }
    public int weight(int from, int to) {
        for (Edge edge : graph[from])
            if (edge.to == to)
                return edge.weight;
        throw new IllegalArgumentException("No such edge");
    }
    public List<Edge> neighbors(int vert) {
        return graph[vert];
    }

    // delete method
    public void removeEdge(int from, int to) {
        for (int i = 0; i < graph[from].size(); i++) {
            if (graph[from].get(i).to == to) {
                graph[from].remove(i);
                break;
            }
        }
    }

    // unit test
    public static void main(String[] args) {
        WeightedDigraph graph = new WeightedDigraph(3);
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
