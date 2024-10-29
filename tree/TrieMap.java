public interface Trie<V> {
    // create method
    void put(String key, V value);

    // readin method
    V get(String key);
    boolean containsKey(String key);
    String shortestPrefixOf(String query);
    String longestPrefixOf(String query);
    boolean hasKeyWithPrefix(String prefix);
    List<String> keysWithPrefix(String prefix);
    boolean hasKeyWithPattern(String pattern);
    List<String> keysWithPattern(String pattern);

    // remove method
    void remove(String key);
}
