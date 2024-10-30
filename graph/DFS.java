public class DFS {
    // nested class
    class Vertex {
        int id;
        Vertext[] neighbors;
    }

    // traverse of Vertex
    public void traverse(Vertex vert, boolean[] visited) { // O(E+V)
        // base case
        if (vert == null)
            return;
        // jump visited
        if (visited[vert.id]) return;
        // pre order
        visited[vert.id] = true;
        for (Vertext adjVert : vert.neighbors)
            traverse(adjVert, visited);
        // post order
    }

    // traverse of AdjList/AdjMat
    public void traverse(Graph graph, int start, boolean[] visited) { // O(E+V)
        // base case
        if (start < 0 || start >= graph.size())
            return;
        // jump visited
        if (visited[start]) return;
        // pre order
        visited[start] = true;
        for (Edge adjEdge : graph.neighbors(s))
            traverse(graph, adjEdge.to, visited);
        // post order
    }

    // find path from src to dest
    boolean[] onPath = new boolean[graph.size()];
    List<Integer> path = new LinkedList<>();

    public void traverse(Graph, graph, int src, int dest) {
        // base case
        if (src < 0 || src >= graph.size())
            return;
        // jump onPath
        if (onPath[src] = true) return;
        // pre order
        onPath[src] = true;
        path.add(src);
        if (src == dest)
            ;
        for (Edge edge : graph.neighbors(src))
            traverse(graph, e.to, dest);
        // post order
        path.remove(path.size()-1);
        onPath[src] = false;
    }
}
