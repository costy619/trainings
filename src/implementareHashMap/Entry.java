package implementareHashMap;

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;
    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;

    }

    // getters, equals, hashCode and toString

}