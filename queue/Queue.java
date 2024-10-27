 public interface Queue<E> {
    // create methods
     boolean add(E e); // throws IllegalStateException if reaching capacity
     boolean offer(E e); // returns false if reaching capacity

    // delete method
     E remove(); // throws NoSuchElementException if empty queue
     E poll(); // returns null if empty queue

    // access method
     boolean isEmpty();
     int size();
     E element(); // throws NoSuchElementException if empty queue
     E peek(); // returns null if empty queue
}
