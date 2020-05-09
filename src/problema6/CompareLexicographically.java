package problema6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareLexicographically {
    public static void compareLexicographically() {
        ArrayList<String> myList = new ArrayList<>();
        ArrayList<String> myList1 = new ArrayList<String>();
        populateListAndShowing(myList);
        populateListAndShowing(myList1);
        printingResults(myList, myList1);
    }


    private static void populateListAndShowing(ArrayList<String> myList1) {
        while (true) {
            try {
                System.out.println();
                Scanner sc = getScannerFisiere("Introdu fisierul  - ");
                while (sc.hasNextLine()) {
                    myList1.add(sc.nextLine());
                }
                for (int i = 0; i < myList1.size(); i++) {
                    System.out.print(" : " + myList1.get(i));
                }
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Reintrodu alt path");
            }
        }
    }

    private static void printingResults(ArrayList<String> myList, ArrayList<String> myList1) {
        System.out.println();
        if (myList.equals(myList1)) {
            System.out.println("Listele egale");
            return;

        } else {
            System.out.println("Ceva nu a mers bine si nu am putut compara listele te rugam mai incearca");
            return;
        }
    }


    private static Scanner getScannerFisiere(String s) throws FileNotFoundException {
        System.out.println(s);
        Scanner keyboard = new Scanner(System.in);
        File file = new File(keyboard.nextLine());
        return new Scanner(file);
    }

}








