import java.util.LinkedList;

public class LinkedListStack<E> {

    // state
    private final LinkedList<E> list = new LinkedList<>();

    // create method
    public void push(E item) { list.addLast(item); }

    // readin method
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public E peek() { return list.getLast(); }

    // delete method
    public E pop() { return list.removeLast(); }

}
