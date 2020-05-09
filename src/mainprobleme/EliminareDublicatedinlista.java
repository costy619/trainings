package mainprobleme;

import java.util.ArrayList;

public class EliminareDublicatedinlista {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
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


        for (int i = 0; i < list.size(); i++) {
            for(int j=1;j<list.size();j++)
            if (list.get(i) == list.get(j)) {
                list.remove(i);
            }
        }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

        }
    }
