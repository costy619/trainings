package problema1;

import java.io.File;
import java.util.Scanner;

public class FileListFromFolder {

    public static void main(String[] args) {
        System.out.println("Introdu path - ");
             Scanner keyboard= new Scanner(System.in);
             File file = new File(keyboard.nextLine());
        if(file.exists()){
            System.out.println(file + " exista");
        }
        else System.out.println("nu exista");
    }
}
