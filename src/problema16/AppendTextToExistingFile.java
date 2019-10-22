package problema16;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AppendTextToExistingFile {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introdu path-ul fisierul pe care vrei sa il modifici");
        while (true) {
            try {
                PrintWriter output = new PrintWriter(keyboard.nextLine());
                System.out.println("introdu textul in fisier");
                String next = keyboard.next();
                output.println(next);
                output.close();
                if (next.endsWith("gata")) {
                    System.out.println("gata");
                    break;
                }
            } catch (FileNotFoundException e) {
            }
        }
    }

    void metoda(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introdu path-ul fisierul pe care vrei sa il modifici");
        try {
            PrintWriter output = new PrintWriter(keyboard.nextLine());
            System.out.println("introdu textul in fisier");
            while (true) {
                String next = keyboard.next();
                output.println(next);
                if (next.endsWith("gata")) {
                    System.out.println("gata");
                    output.close();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
        }
    }


}





