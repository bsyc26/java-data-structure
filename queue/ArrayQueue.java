public class ArrayQueue<E> {
    // state
    private final CircularArrayList<E> carr = new CircularArrayList<>();
    
    // create method
    public void offer(E item) { carr.addLast(item); }

    // delete method
    public E poll() { return carr.removeFirst(); }

    // readin method
    public E peek() { return carr.getFirst(); }

    // unit test
    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.offer(0);
        q.offer(1);
        System.out.println(q.peek());
        System.out.println(q.poll());
    }
}
