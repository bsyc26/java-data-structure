public interface Stack<E> implements Serializable, Coloneable,
        Iterable<E>, Collection<E>, List<E>, RandomAccess {
    // access methods
    public boolean isEmpty();
    public boolean empty();
    public int size();
    public E peek();
    public int search(Object o);

    // insert method
    public E push(E e);

    // remove method
    public E pop();

}
