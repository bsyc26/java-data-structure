public interface Queue<E> {

     // create methods
     boolean add(E e); // throws IllegalStateException if reaching capacity
     boolean offer(E e); // returns false if reaching capacity

     // readin methods
     boolean isEmpty();
     int size();
     E element(); // throws NoSuchElementException if empty queue
     E peek(); // returns null if empty queue

     // delete methods
     E remove(); // throws NoSuchElementException if empty queue
     E poll(); // returns null if empty queue

}
