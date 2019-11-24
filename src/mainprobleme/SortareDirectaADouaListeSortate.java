package mainprobleme;

import java.util.ArrayList;

public class SortareDirectaADouaListeSortate {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(6);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(5);
        ArrayList<Integer> list3=new ArrayList<>();
        for(int i=0;i<list1.size();i++) {
            for(int j=0;j<list1.size();j++){
                if(list1.get(i)>list.get(i)){
                    list3.add(list1.get(i));
                    list3.add(list.get(i));
            }
            }
        }
        for (int i=0;i<list3.size();i++){
            System.out.println(list3.get(i));
            }
        }

    }
