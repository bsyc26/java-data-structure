import java.util.LinkedList;

public class LinkedListQueue<E> {
    // state
    private final LinkedList<E> list = new LinkedList<>();

    // create method
    public void push(E item) { list.addLast(item); } // O(1)

    // delete method
    public E pop() { return list.removeFirst(); } // O(1)

    // readin method
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public E peek() { return list.getFirst(); } // O(1)

    // unit test
    public static void main(String[] args) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.peek());
    }
}
