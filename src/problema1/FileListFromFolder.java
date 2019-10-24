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
            if (file.isDirectory()) {
                String[] fileList = file.list();
                if (file.exists()) {
                    System.out.println("Lista documentelor este ");
                    for (int i = 0; i < fileList.length; i++) {
                        System.out.println(fileList[i]);
                    }
                    break;

                } else System.out.println("nu exista");
            } else {
                System.out.println("nu are o lista de fisiere, reintroduceti un director");
            }

        }
    }
}

