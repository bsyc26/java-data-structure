import java.util.List;
import java.util.LinkedList;

public class ChainingHashMap<K, V> {
    // nested class
    private static class KVNode<K, V> {
        // states
        K key;
        V value;
        // constructor
        public KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // states
    private LinkedList<KVNode<K, V>>[] table;
    private int size; // num of k-v pairs
    private static final int INIT_CAP = 4;

    // constructors
    public ChainingHashMap() { this(INIT_CAP); }
    @SuppressWarnings("unchecked")
    public ChainingHashMap(int initCap) {
        size = 0;
        initCap = Math.max(initCap, 1);
        table = (LinkedList<KVNode<K, V>>[]) new LinkedList[initCap];
        for (int i = 0; i < initCap; i++)
            table[i] = new LinkedList<>();
    }

    // create && update method
    public void put(K key, V value) { // O(1)
        validKey(key);
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        // case key exists
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        // case key is new
        list.add(new KVNode<>(key, value));
        ++size;
        if (size >= table.length * 0.75) // 0.75 is empirical load factor
            resize(table.length * 2);
    }

    // readin methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public V get(K key) { // O(1)
        validKey(key);
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        // case key exists
        for (KVNode<K, V> node : list)
            if (node.key.equals(key))
                return node.value;
        return null;
    }
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    public List<K> keySet() { // O(1)
        List<K> keys = new LinkedList<>();
        for (LinkedList<KVNode<K, V>> list : table)
            for (KVNode<K, V> node : list)
                keys.add(node.key);
        return keys;
    }
    public List<V> values() { // O(1)
        List<V> values = new LinkedList<>();
        for (LinkedList<KVNode<K, V>> list : table)
            for (KVNode<K, V> node : list)
                values.add(node.value);
        return values;
    }

    // delete method
    public void remove(K key) { // O(1)
        validKey(key);
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        // case key exists
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                list.remove(node);
                --size;
                if (size <= table.length / 8)
                    resize(table.length / 4);
                return;
            }
        }
    }


    // support methods
    public int hash(K key) {
        return (key.hashCode()&0x7fffffff) % table.length; // avoid negative hash code
    }
    private void resize(int newCap) {
        newCap = Math.max(newCap, 1);
        ChainingHashMap<K, V> newMap = new ChainingHashMap<>(newCap);
        for (LinkedList<KVNode<K, V>> list : table)
            for (KVNode<K, V> node : list)
                newMap.put(node.key, node.value);
        this.table = newMap.table;
    }
    private void validKey(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");
    }

    // unit test
    public static void main(String[] args) {
        ChainingHashMap<Integer, Integer> map = new ChainingHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.put(1, 100);
        System.out.println(map.get(1));
        map.remove(2);
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
