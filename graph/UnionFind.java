public class UnionFind {
    // states
    private int count;
    private int[] parent;

    // constructor
    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        count = n;
    }

    // update method
    public void union(int p, int q) { // O(1)
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        parent[rootQ] = rootP;
        --count;
    }

    // readin method
    public boolean isConn(int p, int q) { // O(1)
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int find(int x) { // O(logN)
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public int count() { // O(1)
        return count;
    }
}
