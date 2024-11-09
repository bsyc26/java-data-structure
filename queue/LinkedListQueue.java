import java.util.LinkedList;

public class LinkedListQueue<E> {

    // field
    private final LinkedList<E> list = new LinkedList<>();

    // create method
    public void push(E item) { list.addLast(item); } // O(1)

    // readin methods
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public E peek() { return list.getFirst(); } // O(1)

    // delete method
    public E pop() { return list.removeFirst(); } // O(1)

}
