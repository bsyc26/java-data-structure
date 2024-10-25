public interface Queue<E> implements Collection<E>, Iterable<E> {
    // insert method
    public boolean add(E e); // throws IllegalStateException if reaching capacity
    public boolean offer(E e); // returns false if reaching capacity

    // access method
    public boolean isEmpty();
    public int size();
    public E element(); // throws NoSuchElementException if empty queue
    public E peek(); // returns null if empty queue

    // remove method
    public E remove(); // throws NoSuchElementException if empty queue
    public E poll(); // returns null if empty queue
}
