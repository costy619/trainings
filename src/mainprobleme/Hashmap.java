package mainprobleme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("b");
        list.add("b");
        list.add("c");

        HashMap<String,Integer> map=new HashMap<>();
        Iterator<String> iterator1 = list.iterator();

        while(iterator1.hasNext()){
            String el=iterator1.next();
            if(!map.containsKey(el)){
                map.put(el,1);
            }else{
                map.put(el,map.get(el)+1);
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
while(iterator.hasNext()){
    Map.Entry m=iterator.next();
    System.out.print(m.getKey()+ "  ");
    System.out.println(m.getValue());
}

    }


}
