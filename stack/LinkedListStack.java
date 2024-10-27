import java.util.LinkedList;

public class LinkedListStack<E> {
    // state
    private final LinkedList<E> list = new LinkedList<>();

    // create method
    public void push(E item) { list.addLast(item); }

    // delete method
    public E pop() { return list.removeLast(); }

    // readin method
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public E peek() { return list.getLast(); }

    // unit test
    public static void main(String[] args) {
        LinkedListStack<Integer> stk = new LinkedListStack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        System.out.println(stk.peek());
        System.out.println(stk.pop());
        System.out.println(stk.peek());
    }
}
