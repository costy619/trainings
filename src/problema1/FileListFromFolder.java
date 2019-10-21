package problema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileListFromFolder {
    public static void fileListFromFolder() {
        while (true) {
            System.out.println("Introdu path - ");
            Scanner keyboard = new Scanner(System.in);
            File file = new File(keyboard.nextLine());
            String[] fileList = file.list();
            if (file.exists()) {
                for (int i = 0; i < fileList.length; i++) {
                    System.out.println("Lista documentelor este ");
                }

                break;
            } else System.out.println("nu exista");
        }

    }
}

