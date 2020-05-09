package implementareHashMap;

import java.util.Objects;

public class MyMap<K, V> implements Map <K,V>{
    int sizeinitial=2;
    private Entry<K, V>[] vector=new Entry[sizeinitial];
    int locatie;
    int numberOfObjectsInHash=0;
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);
        locatie = getHash(key) %sizeinitial;
        Entry<K, V> existing = vector[locatie];
        if ( vector[locatie] ==  null) {
            vector[locatie] = entry;
            numberOfObjectsInHash++;
            System.out.println("0.S-a pus"+entry.key);
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                }
                System.out.println("da");
                existing=existing.next;
            }
            if (existing.key.equals(key)) {
                existing.value = value;
                System.out.println("2.S-a pus "+existing.key);
            } else {
                existing.next=entry;
                numberOfObjectsInHash++;
                System.out.println("are next1 "+existing.key);
            }
        }
    }
    @Override
    public V get(K key) {

        Entry<K, V> vector1 = vector[getHash(key) % sizeinitial];
        while (vector1 != null ) {
            if (vector1.key.equals(key)) {
                return vector1.value;
            }
            vector1 = vector1.next;
        }
        return null;

    }
public int getHash(K key){
        return Objects.hash(key);

}
    @Override
    public int hashCode() {
        return Objects.hash();
    }



}