package problema2;



import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileListSpecificExtension {
    public static void fileListSpecificExtension() {


        while (true) {
            System.out.println("Introdu path - ");
            Scanner keyboard = new Scanner(System.in);
            File file = new File(keyboard.nextLine());
            ArrayList<String> listaCuExtensii= new ArrayList();
            if (file.exists()) {
                System.out.println("Introdu extensia ");

                if(file.isDirectory()) {
                    String[] fileList = file.list();
                    String extensie = keyboard.nextLine();

                    for (int i = 0; i < fileList.length; i++) {
                        if (fileList[i].endsWith(extensie)) {
                            listaCuExtensii.add(fileList[i]);
                        }

                    }
                    for (int i = 0; i < listaCuExtensii.size(); i++) {

                        System.out.print(" : " + listaCuExtensii.get(i));
                    }
                    if (listaCuExtensii.size() == 0) {
                        System.out.println("Extensia " + extensie + " nu a fost gasita");
                    }
                    break;
                }
                else {
                    System.out.println("nu are o lista de fisiere, reintroduceti un director");
                }
            } else System.out.println("Path-ul nu este bun");

        }
    }

}






