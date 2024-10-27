import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    // nested class
    private static class Node<E> {
        // states
        E val;
        Node<E> next;
        // constructor
        Node(E val) {
            this.val = val;
            this.next = null;
        }
    }

    // states
    private Node<E> dummyHead;
    private Node<E> tail; // tail is always the last node 
    private int size;

    // constructor
    public SinglyLinkedList() {
        dummyHead = new Node<>(null);
        tail = dummyHead;
        size = 0;
    }

    // create methods
    public void addFirst(E item) { // O(1)
        // get node
        Node<E> newest = new Node<>(item);
        // conn head-newest-first
        newest.next = dummyHead.next;
        dummyHead.next = newest;
        // if one node
        if (size == 0)
            tail = newest;
        // udpate size
        ++size;
    }
    public void addLast(E item) { // O(1)
        // get node
        Node<E> newest = new Node<>(item);
        // conn tail-newest && update tail
        tail.next = newest;
        tail = newest;
        // update size
        ++size;
    }
    public void add(int index, E item) { // O(N)
        // pre check
        if (index == size) {
            addLast(item);
            return;
        }
        validIndex(index);
        // get nodes
        Node<E> pred = dummyHead;
        for (int i = 0; i < index; i++)
            pred = pred.next;
        Node<E> newest = new Node<>(item);
        // conn pred-newest-...
        newest.next = pred.next;
        pred.next = newest;
        // update size
        ++size;
    }

    // readin methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E getFirst() { // O(1)
        if (isEmpty()) throw new NoSuchElementException();
        return dummyHead.next.val;
    }
    public E getLast() { // O(1)
        if (isEmpty()) throw new NoSuchElementException();
        Node<E> last = getNode(size-1);
        return last.val;
    }
    public E get(int index) { // O(N)
        validIndex(index);
        Node<E> target = getNode(index);
        return target.val;
    }

    // update method
    public E set(int index, E item) { // O(N)
        // pre check
        validIndex(index);
        // get node
        Node<E> target = getNode(index);
        // modify val
        E oldVal = target.val;
        target.val = item;
        // return old val
        return oldVal;
    }

    // delete methods
    public E removeFirst() { // O(1)
        // pre check
        if (isEmpty()) throw new NoSuchElementException();
        // get node
        Node<E> first = dummyHead.next;
        // conn head-second
        dummyHead.next = first.next;
        // if one node
        if (size == 1)
            tail = dummyHead.next;
        // udpate size
        --size;
        // return del val
        return first.val;

    }
    public E removeLast() { // O(N)
        // precheck
        if (isEmpty()) throw new NoSuchElementException();
        // get node before tail && del tail
        Node<E> pred = dummyHead;
        while (pred.next != tail)
            pred = pred.next;
        E delVal = tail.val;
        pred.next = null;
        // update tail
        tail = pred;
        // udpate size
        --size;
        // return del val
        return delVal;
    }
    public E remove(int index) { // O(1)
        // precheck
        validIndex(index);
        // get node
        Node<E> pred = dummyHead;
        for (int i = 0; i < index; i++)
            pred = pred.next;
        Node<E> delete = pred.next;
        // del target
        pred.next = delete.next;
        // update tail
        if (index == size-1)
            tail = pred;
        // udpate size
        --size;
        // return del val
        return delete.val;
    }

    // support methods
    private Node<E> getNode(int index) { // O(N)
        Node<E> walker = dummyHead.next;
        for (int i = 0; i < index; i++)
            walker = walker.next;
        return walker;
    }
    private void validIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    private void display() {
        System.out.println("Size: " + size);
        for (Node<E> walker = dummyHead.next; walker != null; walker = walker.next)
            System.out.print(walker.val + " -> ");
        System.out.println("null");
    }

    // unit test
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        list.add(2, 5);
        list.display();
    }
}
