 public interface Map<K, V> {
     // create && update methods
     V put(K key, V value);
     default V putIfAbsent(K key, V value);
     void putAll(Map<? extends K, ? extends V> map);

     // readin methods
     int size();
     boolean isEmpty();
     int hashCode();
     boolean equals(Object obj);
     V get(Object key);
     V getOrDefault(Object key, V defaultValue);
     boolean containsKey(Object key);
     boolean containsValue(Object value);
     Set<K> keySet();
     Set<Map.Entry<K, V>> entrySet();
     Collection<V> values();

     // delete methods
     V remove(Object key);
     default boolean remove(Object key, Object value);
     boolean remove(Object key, Object value);
     void clear();
}
