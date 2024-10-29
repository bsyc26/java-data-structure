import java.util.Queue;
import java.util.LinkedList;

public class BFS {
    // nested class
    private static State { // node + its-depth
        // states
        Node node;
        int depth;
        // constructor
        State(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // bfs:lever-order
    public static void bfs(Node root) {
        // edge case
        if (node == null) return;
        // DS
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        // var
        int depth = 1;
        // bfs
        while (!q.isEmpty()) {
            // count level
            int sz = q.size();
            // traverse level
            for (int i = 0; i < sz; i++) {
                // poll
                Node cur = q.poll();
                // level order
                // offer
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            ++depth; // update depth
        }
    }
    public static void bfsDepth(Node root) {
        // edge case
        if (root == null) return;
        // DS
        Queue<State> q = new LinkedList<>();
        q.offer(new State(root, 1));
        // bfs
        while (!q.isEmpty()) {
            // poll
            State curState = q.poll();
            Node curNode = curState.node;
            int curDepth = curState.depth;
            // level order with known depth
            // offer
            for (Node child : curNode.children)
                q.offer(new State(child, depth+1));
        }
    }
}
