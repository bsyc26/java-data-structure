public interface Deque<E> {
    // create methods
    void addFirst(E item); // throws exception
    void addLast(E item); // throws exception
    boolean offerFirst(E item); // returns special value
    boolean offerLast(E item); // returns special value

    // readin methods
    int size();
    boolean isEmpty();
    boolean contains(Object obj);
    Iterator<E> iterator();
    E getFirst(); // throws exception
    E getLast(); // throws exception
    E peekFirst(); // returns special value
    E peekLast(); // returns special value

    // delete methods
    E removeFirst(); // throws exception
    E removeLast(); // throws exception
    E pollFirst(); // returns special value
    E pollLast(); // returns special value
}
