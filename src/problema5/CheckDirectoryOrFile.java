package problema5;

import java.io.File;
import java.util.Scanner;

public class CheckDirectoryOrFile {
    public static void checkDirectoryOrFile() {
        while (true) {

            System.out.println("introdu path-ul fisierului dorit- ");

            Scanner keyboard = new Scanner(System.in);
            File file = new File(keyboard.nextLine());
            if (file.exists()) {

                if (file.isDirectory()) {
                    System.out.println("is a directory");
                }
                if (file.isFile()) {
                    System.out.println("is file");
                }
                break;
            } else {
                System.out.println("Fisierul nu exista te rugam re-");
            }
        }

    }
}
