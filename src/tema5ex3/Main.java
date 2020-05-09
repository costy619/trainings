package tema5ex3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(100);
        integers.add(80);
        Function el=new Half();
        Compute c=new Compute();
        Print p = new Print();
        for (Integer i : integers) {
            p.evaluate(i);
        }
        System.out.println(c.arbitrary(integers,el));
    }
}
