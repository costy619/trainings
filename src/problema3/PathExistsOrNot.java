package problema3;

import java.io.File;
import java.util.Scanner;

public class PathExistsOrNot {
    public static void pathExistsOrNot() {
        while(true) {
            System.out.println("Introdu path - ");
            Scanner keyboard = new Scanner(System.in);
            File file = new File(keyboard.nextLine());
            String[] fileList = file.list();
            if (file.exists()) {
                System.out.println("Path-ul exista");
            } else System.out.println("nu exista");
            break;
        }
    }
}

