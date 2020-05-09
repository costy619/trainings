package Collections;

import java.util.Iterator;

public class HashSet {
    public static void main(String[] args) {
        java.util.HashSet<Integer> hashSet = new java.util.HashSet();
        hashSet.add(3);
        hashSet.add(7);
        Iterator iterator=hashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
