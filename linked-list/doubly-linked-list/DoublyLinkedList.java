import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    // nested class
    private static class Node<E> {
        // states
        E val;
        Node<E> next;
        Node<E> prev;
        // constructor
        Node(E val) {
            this.val = val;
        }
    }

    // states
    private final Node<E> dummyHead;
    private final Node<E> dummyTail;
    private int size;

    // construtor
    public DoublyLinkedList() {
        dummyHead = new Node<>(null);
        dummyTail = new Node<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }

    // access methods
    public E get(int index) { // O(N)
        validIndex(index);
        Node<E> target = getNode(index);
        return target.val;
    }
    public E getFirst() { // O(1)
        if (size < 1) throw new NoSuchElementException();
        return dummyHead.next.val;
    }
    public E getLast() { // O(1)
        if (size < 1) throw new NoSuchElementException();
        return dummyTail.prev.val;
    }

    // create methods
    public void addLast(E item) { // O(1)
        // get nodes
        Node<E> newest = new Node<>(item);
        Node<E> last = dummyTail.prev;
        // conn last-newest
        last.next = newest;
        newest.prev = last;
        // conn newest-tail
        newest.next = dummyTail;
        dummyTail.prev = newest;
        // update size
        ++size;
    }
    public void addFirst(E item) { // O(1)
        // get nodes
        Node<E> newest = new Node<>(item);
        Node<E> first = dummyHead.next;
        // conn newest-first
        first.prev = newest;
        newest.next = first;
        // conn head-newest
        dummyHead.next = newest;
        newest.prev = dummyHead;
        // update size
        ++size;
    }
    public void add(int index, E item) { // O(N)
        // pre check
        if (index != size) validIndex(index);
        if (index == size) {
            addLast(item);
            return;
        }
        // get nodes
        Node<E> newest = new Node<>(item);
        Node<E> succ = getNode(index);
        Node<E> pred = succ.prev;
        // conn pred-newest-succ
        pred.next = newest;
        newest.prev = pred;
        succ.prev = newest;
        newest.next = succ;
        // update size
        ++size;
    }

    // delete methods
    public E removeFirst() { // O(1)
        // pre check
        if (size < 1) throw new NoSuchElementException();
        // get nodes
        Node<E> delete = dummyHead.next;
        Node<E> succ = delete.next;
        // conn head-succ
        dummyHead.next = succ;
        succ.prev = dummyHead;
        // GC
        delete.prev = null;
        delete.next = null;
        // update size
        --size;
        // return delete
        return delete.val;
    }
    public E removeLast() { // O(1)
        // pre check
        if (size < 1) throw new NoSuchElementException();
        // get nodes
        Node<E> delete = dummyTail.prev;
        Node<E> pred = delete.prev;
        // conn pred-tail
        pred.next = dummyTail;
        dummyTail.prev = delete;
        // GC
        delete.prev = null;
        delete.next = null;
        // update size
        --size;
        // return delete
        return delete.val;
    }
    public E remove(int index) { // O(N)
        // pre check
        validIndex(index);
        // get nodes
        Node<E> delete = getNode(index);
        Node<E> pred = delete.prev;
        Node<E> succ = delete.next;
        // conn pred-succ
        pred.next = succ;
        succ.prev = pred;
        // GC
        delete.prev = null;
        delete.next = null;
        // udpate size
        --size;
        // return delete
        return delete.val;
    }

    // modify method
    public E set(int index, E item) { // O(N)
        // pre check
        validIndex(index);
        // get node
        Node<E> target = getNode(index);
        // record old val && modify node
        E oldVal = target.val;
        target.val = item;
        // return old val
        return oldVal;
    }

    // support methods
    private Node<E> getNode(int index) { // O(N)
        // pre check
        validIndex(index);
        // get node
        Node<E> walker = dummyHead.next;
        for (int i = 0; i < index; i++)
            walker = walker.next;
        // return node
        return walker;
    }
    private void validIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    private void display() {
        System.out.println("Size = " + size);
        for (Node<E> walker = dummyHead.next; walker != dummyTail; walker = walker.next)
            System.out.print(walker.val + " <-> ");
        System.out.println("null");
        System.out.println();
    }

    // unit test
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.add(2, 100);
        list.display();
    }
}
