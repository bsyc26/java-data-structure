public interface Stack<E> {
    // create method
    E push(E e);

    // delete method
    E pop();

    // readin methods
    boolean isEmpty();
    boolean empty();
    int size();

    E peek();
    int search(Object o); // returns 1-based pos
}
