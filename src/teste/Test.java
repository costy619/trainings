package teste;


import java.util.HashMap;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) {

        HashMap<Integer, Test1> s = new HashMap();
        Test1 n = new Test1(2, 3);
        s.put(1, new Test1(4, 6));
        s.put(2, n);
        Iterator b = s.entrySet().iterator();
        for (HashMap.Entry mapElement : s.entrySet()) {
            int key = (int)mapElement.getKey();
            Test1 g =(Test1) mapElement.getValue();
                    System.out.print(key);
            System.out.println(g.getB());
        }
    }
    }


