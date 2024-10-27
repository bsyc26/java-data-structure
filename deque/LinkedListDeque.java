import java.util.LinkedList;

public class LinkedListDeque<E> {
    // state
    private final LinkedList<E> list = new LinkedList<>();

    // create methods
    public void addFirst(E item) { list.addFirst(item); } // O(1)
    public void addLast(E item) { list.addLast(item); } // O(1)

    // delete methods
    public E removeFirst() { return list.removeFirst(); } // O(1)
    public E removeLast() { return list.removeLast(); } // O(1)

    // readin methods
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public E peekFirst() { return list.getFirst(); } // O(1)
    public E peekLast() { return list.getLast(); } // O(1)

    // unit test
    public static void main(String[] args) {
        LinkedListDeque<Integer> dq = new  LinkedListDeque<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(3);
        dq.addLast(4);
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
    }
}
