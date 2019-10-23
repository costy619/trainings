package problema17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadFirst3linesFromAfile {
    public static void readFirst3linesFromAfile() {

        ArrayList<String> myList = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        double n;
        while (true) {
            try {
                System.out.println(" cate randuri vrei sa citesti");
                 n = keyboard.nextDouble();
            }
            catch (InputMismatchException e){
                System.out.println("introdu un numar");
                keyboard.nextLine();
                continue;
            }
            try {
                Scanner sc = getScannerFisiere("Introdu fisierul  - ");
                    {
                        while (sc.hasNextLine()) {
                            myList.add(sc.nextLine());
                        }
                        for (int i = 0; i < n; i++) {
                            System.out.println(myList.get(i));
                        }

                        break;
                    }


            } catch (FileNotFoundException e) {
                System.out.println("Reintrodu alt path");
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
