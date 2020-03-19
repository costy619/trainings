package implementareHashMap;

public class Main {
    public static void main(String[] args) {
        MyMap<Integer, Integer> myMap = new MyMap<>();
        myMap.put(8346,9);
        myMap.put(368,10);
        myMap.put(10,56);
        myMap.put(11,946);
        myMap.put(44,94);
        myMap.put(55,97);
        myMap.put(7,5);
        myMap.put(855,9);
        System.out.println(myMap.get(8346));
        System.out.println(myMap.get(368));
        System.out.println(myMap.get(10));
        System.out.println(myMap.get(11));
        System.out.println(myMap.get(55));
        System.out.println(myMap.get(7));
        System.out.println(myMap.get(855));

        System.out.println(myMap.numberOfObjectsInHash);
    }
}
