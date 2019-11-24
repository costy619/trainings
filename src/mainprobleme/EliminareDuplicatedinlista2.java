package mainprobleme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EliminareDuplicatedinlista2 {

    public EliminareDuplicatedinlista2() {
        super();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(6);
        list.add(6);
        list.add(6);
        list.add(8);
        list.add(8);
        list.add(1);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(6);
        list.add(6);
        list.add(6);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(14);
        list.add(14);
        list.add(14);


ArrayList<Integer> list1=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        Iterator<Integer> iterator1 = list.iterator();
        while(iterator1.hasNext()){
            Integer el=iterator1.next();
            if(map.get(el)==null){
                map.put(el,1);
                list1.add(el);
            }else {
                map.put(el, map.get(el) + 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> m=iterator.next();
            System.out.print(m.getKey()+ "  ");
            System.out.println(m.getValue());
        }
        System.out.println("varianta cu o remove merge doar cu lista sorta");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("varianta cu a doua lista");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }
}
