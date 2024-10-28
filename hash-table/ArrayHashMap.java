import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class ArrayHashMap<K, V> {
    // nested class
    private static class Node<K, V> {
        // staets
        K key;
        V value;
        // constructor
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // states
    private final HashMap<K, Integer> keyToIndex = new HashMap<>();
    private final ArrayList<Node<K, V>> table = new ArrayList<>();
    private final Random rand = new Random();

    // create && update method
    public void put(K key, V value) { // O(1)
        // if existing key
        if (containsKey(key)) {
            int index = keyToIndex.get(key);
            Node<K, V> node = table.get(index);
            node.value = value;
            return;
        }
        // if new key
        table.add(new Node<>(key, value));
        keyToIndex.put(key, table.size()-1);
    }

    // readin method
    public int size() { return table.size(); }
    public boolean isEmepty() { return table.size() == 0; }
    public boolean containsKey(K key) {
        return keyToIndex.containsKey(key);
    }
    public V get(K key) { // O(1)
        if (!keyToIndex.containsKey(key)) return null;
        int index = keyToIndex.get(key);
        Node<K, V> target = table.get(index);
        return target.value;
    }
    public K randomKey() { // O(1)
        int size = table.size();
        int randIndex = rand.nextInt(size); // [0, size)
        Node<K, V> randNode = table.get(randIndex);
        return randNode.key;
    }
    
    // delete method
    public void remove(K key) { // swap && remove ArrayList tail elem: O(1)
        if (!keyToIndex.containsKey(key)) return;
        int index = keyToIndex.get(key);
        Node<K, V> delete = table.get(index);
        // swap with last elem
        Node<K, V> last = table.get(table.size()-1);
        table.set(index, last);
        table.set(table.size()-1, delete);
        // update table && keyToIndex
        table.remove(table.size()-1);
        keyToIndex.put(last.key, index);
        keyToIndex.remove(delete.key);
    }

    // unit test
    public static void main(String[] args) {
        ArrayHashMap<Integer, Integer> map = new ArrayHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        System.out.println(map.get(1));
        System.out.println(map.randomKey());
        map.remove(4);
        System.out.println(map.randomKey());
        System.out.println(map.randomKey());
    }
}
