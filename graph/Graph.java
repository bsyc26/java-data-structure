public interface Graph<E> {
    // create method
    void addEdge(int from, int to, int weight);

    // readin methods
    int size();
    boolean hasEdge(int from, int to);
    int weight(int from, int to);
    List<Edge> neighbors(int vert); // returns all neighbors and weights of vert
    
    // delete method
    void removeEdge(int from, int to);
}
