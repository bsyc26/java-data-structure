import java.util.NoSuchElementException;

public class ArrayList<E> {
    // states
    private E[] arr;
    private int size;
    private static final int INIT_CAP = 1;

    // constructors
    public ArrayList() {
        this(INIT_CAP);
    }
    @SuppressWarnings("unchecked")
    public ArrayList(int initCap) {
        arr = (E[]) new Object[initCap];
        size = 0;
    }

    // create methods
    public void addLast(E item) { // O(1)
        // pre check
        int cap = arr.length;
        if (size == cap)
            resize(2*cap);
        // append item
        arr[size] = item;
        ++size;
    }
    public void add(int index, E item) { // O(N)
        // pre check
        if (index != size) validIndex(index); // index can be size when adding
        int cap = arr.length;
        if (size == cap)
            resize(2*cap);
        // insert item
        for (int i = size-1; i >= index; i--) // reverse
            arr[i+1] = arr[i];
        arr[index] = item;
        ++size;
    }
    public void addFirst(E item) { // O(N)
        add(0, item);
    }

    // readin methods
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    public E get(int index) { // O(1)
        // pre check
        validIndex(index);
        // return elem
        return arr[index];
    }

    // update method
    public E set(int index, E item) { // O(1)
        // pre check
        validIndex(index);
        // mod elem
        E oldVal = arr[index];
        arr[index] = item;
        // return old val
        return oldVal;
    }

    // delete methods
    public E removeLast() { // O(1)
        // pre check
        validIndex(size-1);
        int cap = arr.length;
        if (size == cap / 4)
            resize(cap/2);
        // del tail
        E delVal = arr[size-1];
        arr[size-1] = null; // GC
        --size;
        // return del val
        return delVal;
    }
    public E remove(int index) { // O(N)
        // pre check
        validIndex(index);
        int cap = arr.length;
        if (size == cap / 4)
            resize(cap/2);
        // del mid
        E delVal = arr[index];
        for (int i = index+1; i < size; i++)
            arr[i-1] = arr[i];
        arr[size-1] = null; // GC
        --size;
        // return del val
        return delVal;
    }
    public E removeFirst() { // O(N)
        return remove(0);
    }


    // support methods
    @SuppressWarnings("unchecked")
    private void resize(int newCap) { // O(N)
        E[] tmp = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++)
            tmp[i] = arr[i];
        arr = tmp;
    }
    private void validIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    private void display() {
        System.out.println("Size = " + size + ", Capacity = " + arr.length);
        System.out.print("[");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + ", ");
        System.out.println(arr[size-1] + "]");
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
