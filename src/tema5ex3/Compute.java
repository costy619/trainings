package tema5ex3;

import java.util.ArrayList;

public class Compute {
    ArrayList arbitrary(ArrayList<Integer> arrayList,Function e){
        ArrayList el=new ArrayList();
        for(Integer i:arrayList){
            el.add(e.evaluate(i));
        }
        return el;
    }
}
