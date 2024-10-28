import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class LinkedHashMap<K, V> {
    // nested class
    private static class Node<K, V> {
        // states
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;
        // constructor
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // states
    private final HashMap<K, Node<K, V>> table = new HashMap<>();
    private final Node<K, V> dummyHead;
    private final Node<K, V> dummyTail;

    // constructor
    public LinkedHashMap() {
        dummyHead = new Node<>(null, null);
        dummyTail = new Node<>(null, null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    // create && update methods
    public void put(K key, V value) { // O(1)
        // case: new node
        if (!table.containsKey(key)) {
            Node<K, V> newest = new Node<>(key, value);
            addLastNode(newest);
            table.put(key, newest);
        }
        // case: existing node
        table.get(key).value = value;
    }

    // readin methods
    public int size() { return table.size(); }
    public boolean isEmpty() { return table.size() == 0; }
    public V get(K key) { // O(1)
        Node<K, V> target = table.get(key);
        if (target == null) return null;
        return target.value;
    }
    public boolean containsKey(K key) { // O(1)
        return table.containsKey(key);
    }
    public List<K> keys() { // traverse the linkedlist: O(N)
        List<K> keyList = new ArrayList<>();
        for (Node<K, V> node = dummyHead.next; node != dummyTail; node = node.next)
            keyList.add(node.key);
        return keyList;
    }

    // delete methods
    public void remove(K key) { // O(1)
        if (!table.containsKey(key)) return;
        Node<K, V> delete = table.get(key);
        table.remove(delete);
        removeNode(delete);
    }

    // support methods
    private void addLastNode(Node<K, V> newest) { // O(1)
        Node<K, V> last = dummyTail.prev;
        // conn last-newest-tail
        newest.next = dummyTail;
        newest.prev = last;
        last.next = newest;
        dummyTail.prev = newest;
    }
    private void removeNode(Node<K, V> delete) { // O(1)
        Node<K, V> pred = delete.prev;
        Node<K, V> succ = delete.next;
        // conn pred-succ
        pred.next = succ;
        succ.prev = pred;
        // GC
        delete.next = null;
        delete.prev = null;
    }

    // unit test
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        System.out.println(map.keys());
        map.remove("c");
        System.out.println(map.keys());
    }
}
