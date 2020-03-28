package Collections;
import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    private int b;
    int c;
    public Hashmap(int b, int c){
        this.b=b;
        this.c=c;
    }
    public int getB() {
        return b;
    }
    public int getC(){
        return c;
    }

    public static void main(String[] args) {
        HashMap<Integer,Hashmap> hashMap= new java.util.HashMap();
        Hashmap n = new Hashmap(2, 3);
        hashMap.put(1, new Hashmap(4, 6));
        hashMap.put(2, n);
        for (Map.Entry<Integer, Hashmap> mapElement : hashMap.entrySet()) {
            int key = mapElement.getKey();
            Hashmap g =mapElement.getValue();
            System.out.println("key is "+key+" values "+g.getB()+" "+g.getC());
        }
    }
}

