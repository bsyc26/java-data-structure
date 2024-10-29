public class DFS {
    // dfs:traverse
    public static void traverse(Node node) {
        // base case
        if (node == null)
            return;
        // pre order
        traverse(node.left);
        // in order
        traverse(node.right);
        // post order
    }

    // dfs:division
    public static <T> T division(Node node) {
        // base 
        if (node == null)
            return t;
        // pre order
        int tLeft = division(node.left);
        // in order
        int tRight = division(node.right);
        // post order
        return t;
    }
}
