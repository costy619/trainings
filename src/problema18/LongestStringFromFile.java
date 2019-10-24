package problema18;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LongestStringFromFile {
    public static void longestStringFromFile() {


        ArrayList<String> myList = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
      String rand;
           String longest_word=" ";

        while (true) {

            try {
                Scanner sc = getScannerFisiere("Introdu path-ul  - ");
                while (sc.hasNextLine()) {
                    rand = sc.nextLine();
                    if (rand.length() > longest_word.length()) {
                        longest_word = rand;
                    }

                    }
                System.out.println(longest_word);
                break;
            }catch(FileNotFoundException e){
                System.out.println("Se pare ca path-ul introdus este incorect ");
                }
            }
        }


    private static Scanner getScannerFisiere(String s) throws FileNotFoundException {

            System.out.println(s);

            Scanner keyboard = new Scanner(System.in);
            File file = new File(keyboard.nextLine());
            return new Scanner(file);

        }
    }
