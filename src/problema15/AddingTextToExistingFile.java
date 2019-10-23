package problema15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddingTextToExistingFile {
   public static void addingTextToExistingFile(){

           Scanner keyboard = new Scanner(System.in);
           System.out.println("Introdu path-ul fisierul pe care vrei sa il modifici");
           try {

               PrintWriter output = new PrintWriter(keyboard.nextLine());

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

       }
    }


}





