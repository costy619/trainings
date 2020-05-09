package mainprobleme;

import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(8);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(56);
        ArrayList<Integer> list3 = new ArrayList<>();

        int i = 0, j = 0;
        while (i < list.size() && j < list1.size()) {
            if (list.get(i) < list1.get(j)){
                list3.add(list.get(i));
            i++;
            }
            else {
                list3.add(list1.get(j));
                j++;
            }
        }
        while (i < list.size()){
            list3.add(list.get(i));
            i++;
    }
        while (j < list1.size()){
            list3.add(list1.get(j));
            j++;
    }
        for (int l=0;l<list3.size();l++){
            System.out.println(list3.get(l));
            }
        }



    }
