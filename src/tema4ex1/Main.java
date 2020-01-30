package tema4ex1;

import OnlineStoreClass.C;
import tema4ex1.Building.Category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Building> listaCladiri = new ArrayList<>();
        adaugareInLista(listaCladiri);
        show(listaCladiri);
        Building b = new Building("Casa", 10000, "Alexexandru", Category.RESIDENTIAL);
        averageForEach(listaCladiri);
        averageForEachNeighborhood(listaCladiri);
        System.out.println("The number of categories is: "+Category.values().length);
        uniqueNeighborhoods(listaCladiri);
    }

    private static void  uniqueNeighborhoods(ArrayList<Building> arrayList){
        HashSet<String> setNeighborhoods= new HashSet<>();
     for (int i = 0; i < arrayList.size(); i++){
         setNeighborhoods.add(arrayList.get(i).neighborhood);
     }
//        System.out.println(setNeighborhoods);

        Iterator<String> i = setNeighborhoods.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
    }
}

    private static void adaugareInLista(ArrayList<Building> list) {
        Building b1 = new Building("Casa", 30000, "Alexexandru", Category.RESIDENTIAL);
        Building b2 = new Building("Casa ta", 20000, "Dalas", Category.RELIGIOUS);
        Building b3 = new Building("Casa mea", 30000, "Dalas", Category.RELIGIOUS);
        Building b4 = new Building("Casa ei", 40000, "Alexexandru", Category.OFFICE);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
    }

    private static void show(ArrayList<Building> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).getCategoryAsString();
        }
    }

    private static void averageForEachNeighborhood (ArrayList<Building> arrayList) {
        int c = 0;
        int d = 0;

        int mediaA =0;
        int mediaD =0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).neighborhood.equals("Alexexandru")) {
             c++;
            mediaA=(mediaA+arrayList.get(i).price)/c;
            }
            if (arrayList.get(i).neighborhood.equals("Dalas")) {
                d++;
                mediaD=(mediaD+arrayList.get(i).price)/d;
            }
        }
        System.out.println("media Alexexandru "+mediaA);
        System.out.println("media Dalas "+mediaD);
    }
    private static void averageForEach (ArrayList<Building> arrayList) {
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int mediaR =0;
        int mediaRes =0;
        int mediaOF =0;
        int mediaH =0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getCategoryAsString().equals(Category.RELIGIOUS)) {
                c++;
                mediaR=(mediaR+arrayList.get(i).price)/c;
            }
            if (arrayList.get(i).getCategoryAsString().equals(Category.RESIDENTIAL)) {
                d++;
                mediaRes=(mediaRes+arrayList.get(i).price)/d;
            }
            if (arrayList.get(i).getCategoryAsString().equals(Category.OFFICE)) {
                e++;
                mediaOF=(mediaOF+arrayList.get(i).price)/e;
            }
            if (arrayList.get(i).getCategoryAsString().equals(Category.HOSPITAL)) {
                f++;
                mediaH=(mediaH+arrayList.get(i).price)/e;
            }
        }
        System.out.println("media RELIGIOUS "+mediaR);
        System.out.println("media HOSPITAL "+mediaH);
        System.out.println("media OFFICE "+mediaOF);
        System.out.println("media RESIDENTIAL "+mediaRes);
    }
}