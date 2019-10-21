package problema4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.security.Permission;
import java.util.Scanner;

public class FileHasReadOrWritePerm {
    public static void main(String[] args) throws FileNotFoundException {
        while (true) {
            System.out.println("Introdu fisierul- ");
            Scanner keyboard = new Scanner(System.in);
            File file = new File(keyboard.nextLine());
           if(file.exists()) {
                if (file.canWrite()) {

                    System.out.println("Writable: ");
                } else {
                    System.out.println("Not Writable");
                }
                if (file.canRead()) {
                    System.out.println("Readable: ");
                } else {
                    System.out.println("Not Readable: ");
                }
            }
        }
        }
    }

