package problema2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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

            String extensie = keyboard.nextLine();
            String[] fileList = file.list();

                for (int i = 0; i < fileList.length; i++) {
                    if (fileList[i].endsWith(extensie)) {
                        listaCuExtensii.add(fileList[i]);
                    }

                }
                for (int i = 0; i < listaCuExtensii.size(); i++) {

                    System.out.print(" : " + listaCuExtensii.get(i));
                }
                if(listaCuExtensii.size()==0){
                    System.out.println("Extensia " +extensie+ " nu a fost gasita");
                }
                break;
            } else System.out.println("Path-ul nu este bun");

        }
    }

}






