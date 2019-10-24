package problema16;

import org.omg.CORBA.portable.ValueInputStream;
import org.omg.CORBA.portable.ValueOutputStream;

import java.io.*;
import java.util.Scanner;

public class AppendTextToAnExistingFile {
    public static void appendTextToAnExistingFile() {
        while (true) {
            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter out = null;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Introdu path-ul fisierul pe care vrei sa il modifici");
            File file = new File(keyboard.nextLine());
            try {
                if (file.exists()) {
                    fw = new FileWriter(file, true);
                    bw = new BufferedWriter(fw);
                    out = new PrintWriter(bw);

                    System.out.println("introdu text in fisier");
                    out.println(keyboard.nextLine());
                    out.close();
                    break;
                }
            } catch (FileNotFoundException e) {
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

    }


