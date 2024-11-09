public class ArrayQueue<E> {

    // field
    private final CircularArrayList<E> carr = new CircularArrayList<>();
    
    // create method
    public void offer(E item) { carr.addLast(item); }

    // readin method
    public E peek() { return carr.getFirst(); }

    // delete method
    public E poll() { return carr.removeFirst(); }

}
