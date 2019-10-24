package mainprobleme;

import problema1.FileListFromFolder;
import problema15.AddingTextToExistingFile;
import problema16.AppendTextToAnExistingFile;
import problema17.ReadFirst3linesFromAfile;
import problema18.LongestStringFromFile;
import problema2.FileListSpecificExtension;
import problema3.PathExistsOrNot;
import problema4.FileHasReadOrWritePerm;
import problema5.CheckDirectoryOrFile;
import problema6.CompareLexicographically;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProbleme {
    public static void main(String[] args) {
        System.out.println("Meniu");
        System.out.println("1. Afisare director");
        System.out.println("2. Fisier cu extensie");
        System.out.println("3. Verifica daca fisierul exista");
        System.out.println("4. Verifica permisiunea de cirire si/sau scriere");
        System.out.println("5. Verifica daca este fisier sau director");
        System.out.println("6. Compara lexicografic");
        System.out.println("15. Adaugare continut intr-un fisier gol");
        System.out.println("16. Adaugare continut intr-un fisier deja scris");
        System.out.println("17. Citim N linii dintrun fisier");
        System.out.println("18. Cel mai lung cuvant dintr-un fisier");
        System.out.println("0. Stop the application");
        MainProbleme p = new MainProbleme();
        Scanner s = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Introduceti optiunea: ");
                String n = s.next();
                if (n.equals("1")) {

                    FileListFromFolder.fileListFromFolder();
                }
                if (n.equals("2")) {
                    FileListSpecificExtension.fileListSpecificExtension();
                }
                if (n.equals("3")) {
                    PathExistsOrNot.pathExistsOrNot();
                }
                if (n.equals("4")) {
                    FileHasReadOrWritePerm.fileHasReadOrWritePerm();
                }
                if (n.equals("5")) {
                    CheckDirectoryOrFile.checkDirectoryOrFile();
                }
                if (n.equals("6")) {    //C:\\Users\\JohnSmith\\Documents\\Test.txt
                    CompareLexicographically.compareLexicographically();
                }

                if (n.equals("15")) {
                   AddingTextToExistingFile.addingTextToExistingFile();
                }
                if (n.equals("16")) {
                    AppendTextToAnExistingFile.appendTextToAnExistingFile();
                }
                if (n.equals("17")) {
                   ReadFirst3linesFromAfile.readFirst3linesFromAfile();
                }
                if (n.equals("18")) {
                    LongestStringFromFile.longestStringFromFile();
                }
                if (n.equals("0")) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Reintrodu o optiune ");
            }
        }
    }
}





