import java.util.ArrayList;

public class ArrayStack<E> {

    // state
    private ArrayStack<E> list = new ArrayList<>();

    // create method
    public void push(E item) { list.add(item); }

    // readin methods
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public E peek() { return list.get(list.size()-1); }

    // delete method
    public E pop() { return list.removeLast(); }
    
}
