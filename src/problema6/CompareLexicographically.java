package problema6;

import inheritance.Account;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareLexicographically {
    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<>();


        while (true) {
            if(myList.size()==0){
            try {
                Scanner sc = getScannerFisiere("Introdu fisierul 1 - ");

                while (sc.hasNextLine()) {
                    myList.add(sc.nextLine());
                }
                for (int i = 0; i < myList.size(); i++) {
                    System.out.print(" : " + myList.get(i));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Reintrodu alt path");
            }
            }
            if (myList.size() > 0) {
                ArrayList<String> myList1 = new ArrayList<String>();
                while (true) {
                    try {

                        Scanner sc = getScannerFisiere("Introdu fisierul 2 - ");
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
                        System.out.println("Listele egale");
                    } else {
                        System.out.println("Ceva nu a mers bine");
                    }


                }
            }

                }

        }


        private static Scanner getScannerFisiere (String s) throws FileNotFoundException {
            System.out.println(s);
            Scanner keyboard = new Scanner(System.in);
            File file = new File(keyboard.nextLine());
            return new Scanner(file);
        }

    }








