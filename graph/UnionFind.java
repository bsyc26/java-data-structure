public class UnionFind {
    // field
    private int count; // num of sep groups
    private int[] parent;
    // constructor
    public UF(int n) {
        // const
        int N = n;
        // var
        this.count = N;
        parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;
    }
    // method
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        parent[rootQ] = rootP;
        --count;
    }
    public boolean isConn(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int count() { return count; }
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}
