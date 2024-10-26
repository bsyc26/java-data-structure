import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> {
    // states
    private E[] data;
    private int size;
    private static final int INIT_CAP = 1;

    // constructors
    public ArrayList() {
        this(INIT_CAP);
    }
    @SuppressWarnings("unchecked")
    public ArrayList(int initCap) {
        data = (E[]) new Object[initCap];
        size = 0;
    }

    // access methods
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    public E get(int index) { // O(1)
        // pre check
        validIndex(index);
        // return elem
        return data[index];
    }

    // create methods
    public void addLast(E item) { // O(1)
        // pre check
        int cap = data.length;
        if (size == cap)
            resize(2*cap);
        // append item
        data[size] = item;
        ++size;
    }
    public void add(int index, E item) { // O(N)
        // pre check
        if (index != size) validIndex(index);
        int cap = data.length;
        if (size == cap)
            resize(2*cap);
        // insert item
        for (int i = size-1; i >= index; i--) // reverse
            data[i+1] = data[i];
        data[index] = item;
        ++size;
    }
    public void addFirst(E item) { // O(N)
        add(0, item);
    }

    // delete methods
    public E removeLast() throws new NoSuchElementException { // O(1)
        // pre check
        if (size == 0) throw new NoSuchElementException();
        int cap = data.length;
        if (size == cap / 4)
            resize(cap/2);
        // del tail
        E delVal = data[size-1];
        data[size-1] = null; // GC
        --size;
        // return del val
        return delVal;
    }
    public E remove(int index) { // O(N)
        // pre check
        validIndex(index);
        int cap = data.length;
        if (size == cap / 4)
            resize(cap/2);
        // del mid
        E delVal = data[index];
        for (int i = index+1; i < size; i++)
            data[i-1] = data[i];
        data[size-1] = null; // GC
        --size;
        // return del val
        return delVal;
    }
    public E removeFirst() { // O(N)
        return remove(0);
    }

    // modify method
    public E set(int index, E item) { // O(1)
        // pre check
        validIndex(index);
        // mod elem
        E oldVal = data[index];
        data[index] = item;
        // return old val
        return oldVal;
    }

    // support methods
    @SuppressWarnings("unchecked")
    private void resize(int newCap) { // O(N)
        E[] tmp = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++)
            tmp[i] = data[i];
        data = tmp;
    }
    private void validIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    private void display() {
        System.out.println("Size = " + size + ", Capacity = " + data.length);
        System.out.println(Arrays.toString(data));
    }

    // unit test
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(3);
        for (int i = 1; i <= 5; i++)
            arr.addLast(i);
        arr.display();
        arr.remove(3);
        arr.add(1, 9);
        arr.addFirst(100);
        arr.display();
        int lastVal = arr.removeLast();
        for (int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
    }
}
