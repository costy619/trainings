package tourists;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Integer.numberOfLeadingZeros;
import static java.lang.Integer.parseInt;
import static tourists.Application.hotels;

public class Main {

    public static void main(String[] args) {
//        System.out.println("introdu suma pe care vrei sa o folosesti pentru a gasi combinatia de hoteluri");
//        problema1(hotels);
//        System.out.println(" introdu pretul pe care vrei sa in vezi de cate ori se repeta");
//        problema2(hotels);
//        System.out.println(" situatia preturilor care se repeta");
        problema3FrecventaPreturi(hotels);
//        ArrayList<String>hoteluri=new ArrayList<>();
//        problema3FrecventaPreturiVar2(hotels, hoteluri);
      //  problema3VectorDeFrecventaVaR3();
        problema4Binarysearch();
//        problema5(hotels);
//        list();

    }


    private static void problema4Binarysearch() {
        int arr[] = {7, 9, 14, 18, 20};
        int n = arr.length;
        int x = 7;
        int l = 0, r = arr.length - 1;
        boolean v = false;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) {
                System.out.println("numarul " + x + " a fost gasit la pozitia " + m);
                v = true;
                break;
            } else {
                if (arr[m] < x) {
                    l = m + 1;
                } else
                    r = m - 1;
            }
        }
        if (v == false) {
            System.out.println("Numarul " + x + " nu a fost gasit");
        }
    }

    private static void problema3VectorDeFrecventaVaR3() {
        int[] v = {4, 7, 6, 6, 6, 66, 18, 51};
        int max = 0;
        for (int y = 0; y < v.length; y++) {
            for (int b = y + 1; b < v.length; b++) {
                if (v[y] > v[b]) {
                    max = v[y];
                    v[y] = v[b];
                    v[b] = max;
                    max = v[b];
                }
            }
        }
        System.out.println(max);
        int i = 0;
        int f[] = new int[max + 1];
        for (i = 0; i < v.length; i++) {
            f[v[i]]++;
        }
        for (i = 0; i < f.length; i++) {
            if (f[i] > 0) {
                System.out.println(i + " apare de " + f[i] + " ori");
            }
        }
    }

    private static void problema5(ArrayList<Hotel> hotels) {
        //trebuia sa pui sau sa scoti din comentariu metoda  AfisareHoteluriInFunctieDePret(hotels);
        //cand o scoti din comentariu trebuie sa arate ca e sortata
        int c = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < hotels.size() - 1; i++) {
            if (hotels.get(0).getPrice() < hotels.get(i + 1).getPrice()) {
                if (hotels.get(i).getPrice() > hotels.get(i + 1).getPrice()) {
                    break;
                }
                c++;
                a++;

            } else {
                if (hotels.get(i).getPrice() < hotels.get(i + 1).getPrice()) {
                    break;
                }
                c++;
                b++;
            }
        }
        if (c == hotels.size() - 1 && a == hotels.size() - 1) {
            System.out.println(" lista sortata Crescator");

        } else {
            if (c == hotels.size() - 1 && b == hotels.size() - 1) {
                System.out.println(" lista sortata Descrescator");
            } else System.out.println("lista nesortata");
        }
    }


    private static void problema3FrecventaPreturiVar2(ArrayList<Hotel> hotels, ArrayList<String> hoteluri) {

        System.out.println(" a doua varianta a problemei 3");
        for (int i = 0; i < hotels.size(); i++) {
            int c = 0;
            for (int k = 1; k < hotels.size(); k++) {
                if (hotels.get(i).getPrice() == hotels.get(k).getPrice()) {
                    c++;

                } else {

                }
            }
            hoteluri.add("Pretul  " + hotels.get(i).getPrice() + " al hotelului " + hotels.get(i).getName() + " se repeta de " + String.valueOf(c) + " ori");
        }

        for (int i = 0; i < hoteluri.size(); i++) {
            System.out.println(hoteluri.get(i));
        }
    }

    private static void list() {
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(3);
        list.add(2);
        int c = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(0) < list.get(i + 1)) {
                    if (list.get(i) > list.get(i + 1)) {
                        break;
                    }
                    c++;
                    a++;

            } else {
                if (list.get(i) < list.get(i + 1)) {
                    break;
                }
                c++;
                b++;
            }
        }
        if (c == list.size() - 1 && a == list.size() - 1) {
            System.out.println(" lista sortata Crescator");

        } else {
            if (c == list.size() - 1 && b == list.size() - 1) {
                System.out.println(" lista sortata Descrescator");
            } else System.out.println("lista nesortata");
        }
    }

    private static void problema3FrecventaPreturi(ArrayList<Hotel> hotels) {
        System.out.println(" prima varianta");
        for (int i = 0; i < hotels.size(); i++) {
            int c = 0;
            for (int k = 1; k < hotels.size(); k++) {
                if (hotels.get(i).getPrice() == hotels.get(k).getPrice()) {
                    c++;
                }
            }
            System.out.println("Pretul  " + hotels.get(i).getPrice() + " al hotelului " + hotels.get(i).getName() + " se repeta de " + c + " ori");
        }
    }

    private static void problema2(ArrayList<Hotel> hotels) {
        try {
            int r = parseInt(introducereDeLaTastatura());
            int c = 0;
            int m;
            for (int i = 0; i < hotels.size(); i++) {
                if (hotels.get(i).getPrice() == r) {
                    c++;
                }
            }
            if (c > 0) {
                System.out.println(" Pretul " + r + " apare de " + c + " ori");
            } else System.out.println(" Elementul nu apare niciodata ");
        } catch (NumberFormatException e) {
            System.out.println("caracter invalid");
        }
    }

    private static void problema1(ArrayList<Hotel> hotels) {
        try {
            try {
                double n = Double.parseDouble(introducereDeLaTastatura());

                boolean v = true;
                for (int i = 0; i < hotels.size(); i++) {
                    for (int k = 1; k < hotels.size(); k++) {
                        if (hotels.get(i).getPrice() + hotels.get(k).getPrice() == n) {
                            if (hotels.get(i).getName().equals(hotels.get(k).getName())) {

                            } else {
                                System.out.println(hotels.get(i).getName() + " " + hotels.get(k).getName() + " au suma " + n);
                            }
                            v = false;
                        }
                    }
                }
                if (v == true) {
                    System.out.println(" nu exista hoteluri cu suma preturilor " + n);
                }
            } catch (NumberFormatException e) {
                System.out.println("caracter invalid");
            }
        } catch (NoSuchElementException e) {
            System.out.println("suma nu poate fi compusa");
        }
    }

    private static String introducereDeLaTastatura() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
}

