public interface Stack<E> {

    // create method
    E push(E e);

    // readin methods
    boolean isEmpty();
    boolean empty();
    int size();
    E peek();
    int search(Object o); // returns 1-based pos

    // delete method
    E pop();

}
