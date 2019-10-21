package mainprobleme;

import problema1.FileListFromFolder;
import problema2.FileListSpecificExtension;

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
            MainProbleme p = new MainProbleme();
            Scanner s = new Scanner(System.in);

            while (true) {
                try {
                    System.out.println("Introduceti cifra: ");
                    int n = s.nextInt();
                    if (n == 1) {     //C:\Users\constantinb\Documents\text.txt

                        FileListFromFolder.fileListFromFolder();
                    }
                    if (n == 2) {   //C:\Users\constantinb\Documents
                        FileListSpecificExtension.fileListSpecificExtension();
                    }
//                if (n == 3) {    //C:\\Users\\JohnSmith\\Documents\\Test.txt
//                    VerificaDacaExista.Verifica();
//                }
//                if (n == 4) {     //C:\\Users\\JohnSmith\\Documents\\Test.txt
//                    PermisiuneDeCitireScriere.CitireScriere();
//                }
//                if (n == 5) {      //C:\\Users\\JohnSmith\\Documents\\Test.txt
//                    FisierSauDirector.FisierDirector();
//                }
//                if (n == 7) {    //C:\\Users\\JohnSmith\\Documents\\Test.txt
//                    DataModificarii.Data();
//                }
//                if (n == 9) {   //C:\\Users\\JohnSmith\\Documents\\Test.txt
//                    Size.Kb();
                }
                catch (InputMismatchException e){
                    System.out.println("Reintrodu o optiune ");
                    System.out.println();

                }
            }
            }
        }





