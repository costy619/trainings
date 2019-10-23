package problema16;

import java.io.*;
import java.util.Scanner;

public class AppendTextToAnExistingFile {
    public static void appendTextToAnExistingFile() {

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introdu path-ul fisierul pe care vrei sa il modifici");
        try {

            fw = new FileWriter(keyboard.nextLine(), true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(keyboard.nextLine());
            out.close();
        } catch ( FileNotFoundException e) {
            System.out.println("Reintrodu path-ul");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {

            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {

            }
        }
    }
}
