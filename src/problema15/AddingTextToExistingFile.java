package problema15;

import java.io.*;
import java.util.Scanner;

public class AddingTextToExistingFile {

    public static void main(String[] args) {
        addingTextToExistingFile();
    }

    public static void addingTextToExistingFile() {
        while (true) {
            FileWriter out = null;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Introdu path-ul fisierul pe care vrei sa il modifici");
            File file = new File(keyboard.nextLine());
            if (file.exists()) {
                try {
                    out = new FileWriter(file);
                    System.out.println("introdu textul in fisier");
                    while (true) {
                        String next = keyboard.next();
                        out.write(next);
                        if (next.endsWith("gata")) {
                            System.out.println("gata");
                            out.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                System.out.println("Path-ul nu exista reintrodu");
            }

        }

    }
}






