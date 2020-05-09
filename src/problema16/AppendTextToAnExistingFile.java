package problema16;



import java.io.*;
import java.util.Scanner;

public class AppendTextToAnExistingFile {
    public static void appendTextToAnExistingFile() {
        while (true) {
            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter out = null;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Introdupath-ulfisierulpecarevreisailmodifici");
            File file = new File(keyboard.nextLine());
            try {
                if (file.exists()) {

                    fw.append("asda");
                    out = new PrintWriter(bw);

                    System.out.println("introdutextinfisier");
                    out.println(keyboard.nextLine());
                    out.close();
                    break;
                }
                else System.out.println("Reintrodupath-ul");


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