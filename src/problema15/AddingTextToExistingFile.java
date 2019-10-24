package problema15;

import java.io.*;
import java.util.Scanner;

public class AddingTextToExistingFile {
    public static void addingTextToExistingFile() {
        while (true) {
            PrintWriter output;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introdu path-ul fisierul pe care vrei sa il modifici");
        File file = new File(keyboard.nextLine());
        if (file.exists()) {
            try {

                output = new PrintWriter(new FileWriter(file));
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
                System.out.println("Path-ul nu exista reintrodu");

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }

    }
    }
}





