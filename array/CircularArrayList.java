import java.util.NoSuchElementException;

public class CircularArrayList<E> {
    // states
    private E[] arr;
    private int start;
    private int end; // [start, end)
    private int cap; // capacity of arr[]
    private int size; // num of elem in arr[]

    // constructors
    public CircularArrayList() {
        this(1);
    }
    @SuppressWarnings("unchecked")
    public CircularArrayList(int cap) {
        arr = (E[]) new Object[cap];
        start = 0;
        end = 0;
        size = 0;
        this.cap = cap;
    }

    // create methods
    public void addFirst(E item) { // O(1)
        if (start == end || size == cap)
            resize(cap*2);
        start = (start == 0) ? cap-1 : start-1;
        arr[start] = item;
        ++size;
    }
    public void addLast(E item) { // O(1)
        if (start == end || size == cap)
            resize(cap*2);
        arr[end] = item;
        end = (end == cap-1) ? 0 : end+1;
        ++size;
    }

    // readin methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E getFirst() { // O(1)
        checkEmpty();
        return arr[start];
    }
    public E getLast() { // O(1)
        checkEmpty();
        int last = (end == 0) ? cap-1: end-1;
        return arr[last];
    }
    public E get(int index) { // O(1)
        checkEmpty();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        index = (start+index >= cap) ? start+index-cap : start+index;
        return arr[index];
    }

    // update methods
    public void set(int index, E item) { // O(1)
        checkEmpty();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        index = (start+index >= cap) ? start+index-cap : start+index;
        arr[index] = item;
    }

    // delete methods
    public E removeFirst() { // O(1)
        checkEmpty();
        E delVal = arr[start];
        arr[start] = null;
        start = (start == cap-1) ? 0 : start+1;
        --size;
        if (size > 0 && size == cap / 4)
            resize(cap/2);
        return delVal;
    }
    public E removeLast() { // O(1)
        checkEmpty();
        int last = (end == 0) ? cap-1 : end-1;
        E delVal = arr[last];
        arr[last] = null;
        end = (end == 0) ? cap-1 : end-1;
        arr[end] = null;
        --size;
        if (size > 0 && size == cap / 4)
            resize(cap/2);
        return delVal;
    }

    // support methods
    @SuppressWarnings("unchecked")
    private void resize(int newCap) {
        assert newCap >= 1;
        E[] newArr = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++)
            newArr[i] = arr[(start+i+cap) % cap];
        arr = newArr;
        start = 0;
        end = size;
        cap = newCap;
    }
    private void checkEmpty() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Array is empty");
    }
    private void display() {
        System.out.print("[");
        for (int i = 0; i < size-1; i++)
            System.out.print(arr[(start+i+cap) % cap] + ", ");
        System.out.println(arr[(end-1+cap) % cap] + "]");
    }

    // unit test
    public static void main(String[] args) {
        CircularArrayList<Integer> carr = new CircularArrayList<>();
        carr.addFirst(0);
        carr.addFirst(2);
        carr.addLast(1);
        carr.display();
        System.out.println(carr.get(2));
        carr.set(2, 5);
        carr.display();
        System.out.println(carr.getFirst());
        System.out.println(carr.getLast());
        carr.removeFirst();
        carr.removeLast();
        carr.display();
    }
}
