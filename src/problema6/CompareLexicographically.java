package problema6;

import inheritance.Account;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareLexicographically {
    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<>();


               while (true) {
                   try {
                       System.out.println("Introdu fisierul 1 - ");
                       Scanner keyboard = new Scanner(System.in);
                       File file = new File(keyboard.nextLine());
                       Scanner sc = new Scanner(file);

                       while (sc.hasNextLine()) {

                           myList.add(sc.nextLine());
                       }
                       for (int i = 0; i < myList.size(); i++) {
                           System.out.print(" : " + myList.get(i));
                       }
                   } catch (FileNotFoundException e) {
                       System.out.println("Reintrodu alt path");

                   }

                ArrayList<String> myList1 = new ArrayList<String>();
                try {
                    System.out.println("Introdu fisierul 2 - ");
                    Scanner keyboard1 = new Scanner(System.in);
                    File file1 = new File(keyboard1.nextLine());
                    Scanner sc = new Scanner(file1);

                    while (sc.hasNextLine()) {

                        myList1.add(sc.nextLine());
                    }
                    for (int i = 0; i < myList1.size(); i++) {
                        System.out.print(" : " + myList1.get(i));
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Reintrodu alt path");

                }


                System.out.println();

                if (myList.equals(myList1)) {
                    System.out.println(" bla");
                } else
                    System.out.println("hjfhjfu");


            }
        }

}







