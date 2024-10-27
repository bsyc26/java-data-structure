public class ArrayDeque<E> {
    // state
    private final CircularArrayList<E> carr = new CircularArrayList<>();

    // create methods
    public void offerFirst(E item) { carr.addFirst(item); }
    public void offerLast(E item) { carr.addLast(item); }

    // delete methods
    public E pollFirst() { return carr.removeFirst(); }
    public E pollLast() { return carr.removeLast(); }

    // readin methods
    public int size() { return carr.size(); }
    public boolean isEmpty() { return carr.isEmpty(); }
    public E peekFirst() { return carr.getFirst(); }
    public E peekLast() { return carr.getLast(); }
}
