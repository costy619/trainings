package tourists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> myList = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> ListaCuUseri = new ArrayList<>();
        ArrayList<String> ListaCuParole = new ArrayList<>();
        ArrayList<String> ListaCuTipuriDeUseri = new ArrayList<>();
        File file2 = new File("C:\\Users\\constantinb\\Documents\\users.txt");
        try {
            Scanner sc = new Scanner(file2);
            {
                while (sc.hasNextLine()) {
                    myList.add(sc.nextLine());
                }
                for (int i = 0; i < myList.size(); i += 3) {
                    ListaCuUseri.add(myList.get(i));
//                        System.out.println(myList.get(i));
                }
                for (int i = 1; i < myList.size(); i += 3) {
                    ListaCuParole.add(myList.get(i));
//                    System.out.println(myList.get(i));
                }
                for (int i = 2; i < myList.size(); i += 3) {
                    ListaCuTipuriDeUseri.add(myList.get(i));
//                    System.out.println(myList.get(i));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Reintrodu alt path");
        }


        while (true) {
            System.out.println("Bine ai venit!");
            System.out.println("Username:");
            Scanner u = new Scanner(System.in);
            String username = u.nextLine();
            System.out.println("Va rugam selectati tipul de utilizator");
            Scanner uu= new Scanner(System.in);
            String tipselectat= u.nextLine();
            if (ListaCuUseri.contains(username)) {
              if(ListaCuUseri.indexOf(username)==ListaCuTipuriDeUseri.indexOf(tipselectat)){
                  System.out.println(username +" este "+tipselectat);
                  System.out.println("Va rugam Introduceti parola");
              }
              else {

                  System.out.println("Tipul de cont selectat nu corespunde");
                  break;
              }

            } else System.out.println("Nu exista username, mai incearca!");

            while (true) {
                System.out.println("Password:");
                Scanner p = new Scanner(System.in);
                String password = p.nextLine();
                if (ListaCuParole.contains(password)) {
                   if(ListaCuUseri.indexOf(username)==ListaCuParole.indexOf(password)){
                       System.out.println("Felicitari a-ti introdus o parola corecta");
                   }else System.out.println("Ne pare rau dar nu puteti fi autentificat");
                   break;
                } else System.out.println("Parola incorecta, mai incearca!");
            }

                    break;
        }

    }

//
//    private static Scanner getScannerFisiere(String s) throws FileNotFoundException {
//        System.out.println(s);
//        Scanner keyboard = new Scanner(System.in);
//        File file = new File(keyboard.nextLine());
//        return new Scanner(file);
//    }
}