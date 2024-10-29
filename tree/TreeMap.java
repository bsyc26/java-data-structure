public interface TreeMap<K, V> {
    // create && udpate method
    void put(K key, V value); // O(logN)

    // readin methods
    V get(K key); // O(logN)
    boolean containsKey(K key); // O(N)
    List<K> keys();
    K firstKey(); // O(logN)
    K lastKey(); // O(logN)
    K floorKey(K key); // O(logN)
    K ceilingKey(K key); // O(logN)
    K selectKey(int rank); // O(logN)
    int rank(K key); // O(logN)
    List<E> rangeKeys(K lo, K hi); // O(M+logN)

    // delete method
    void remove(K key); // O(logN)
}
