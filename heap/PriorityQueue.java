import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<T> {
    // states
    private T[] heap;
    private int size;
    private final Comparator<? super T> comp;

    // constructor
    @SuppressWarnings("unchecked")
    public PriorityQueue(int cap, Comparator<? super T> comp) {
        heap = (T[]) new Object[cap];
        size = 0;
        this.comp = comp;
    }

    // create method
    public void push(T item) { // O(logN)
        if (size == heap.length)
            resize(2*heap.length);
        heap[size] = item;
        swim(size);
        ++size;
    }

    // readin method
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public T peek() { // O(1)
        if (isEmpty()) throw new NoSuchElementException("PriorityQueue underflow");
        return heap[0];
    }

    // delete method
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("PriorityQueue underflow");
        T delete = heap[0];
        swap(0, size-1); // move top elem to the bot
        heap[size-1] = null; // GC
        --size;
        sink(0);
        if (size > 0 && size == heap.length / 4)
            resize(heap.length/2);
        return delete;
    }

    // support methods
    private int parent(int node) {
        return (node-1) / 2;
    }
    private int leftChild(int node) {
        return node*2 + 1;
    }
    private int rightChild(int node) {
        return node*2 + 2;
    }
    private void swap(int p, int q) {
        T tmp = heap[p];
        heap[p] = heap[q];
        heap[q] = tmp;
    }
    private void swim(int node) { // O(logN)
        while (node > 0 && comp.compare(heap[parent(node)], heap[node]) > 0) {
            swap(parent(node), node);
            node = parent(node);
        }
    }
    private void sink(int node) { // O(logN)
        while (leftChild(node) < size || rightChild(node) < size) {
            int min = node;
            if (leftChild(node) < size && comp.compare(heap[leftChild(node)], heap[min]) < 0)
                min = leftChild(node);
            if (rightChild(node) < size && comp.compare(heap[rightChild(node)], heap[min]) < 0)
                min = rightChild(node);
            if (min == node)
                break;
            swap(node, min);
            node = min;
        }
    }
    @SuppressWarnings("unchecked")
    private void resize(int newCap) { // O(N)
        assert newCap > 1;
        T[] newHeap = (T[]) new Object[newCap];
        for (int i = 0; i < size; i++)
            newHeap[i] = heap[i];
        heap = newHeap;
    }

    // unit test
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, Comparator.naturalOrder());
        pq.push(3);
        pq.push(1);
        pq.push(4);
        pq.push(1);
        pq.push(5);
        pq.push(9);
        while (!pq.isEmpty())
            System.out.println(pq.pop());
    }
}
