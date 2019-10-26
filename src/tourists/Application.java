package tourists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
//        ArrayList<String> myList = new ArrayList<>();
//        File file2 = new File("C:\\Users\\constantinb\\Documents\\users.txt");
//        createList(myList, file2);
//        username(myList);
//    }
//
//    private static void createList(ArrayList<String> myList, File file2) throws FileNotFoundException {
//        Scanner sc = new Scanner(file2);
//        {
//            while (sc.hasNextLine()) {
//                myList.add(sc.nextLine());
//            }
//        }
//    }
//
//    private static void username(ArrayList<String> myList) {
//        while (true) {
//            System.out.println("Bine ai venit!");
//            System.out.println("va rugam intruceti usename-ul");
//            System.out.println("Username:");
//            Scanner u = new Scanner(System.in);
//            String username = u.nextLine();
//            if (myList.contains(username)) {
//                System.out.println("Contul "+username +" este un " +myList.get(myList.indexOf(username) + 2));
//                System.out.println("Va rugam Introduceti parola");
//            } else{ System.out.println("Nu exista username, mai incearca!");
//            continue;}
//if(myList.indexOf(username)>=0) {
//    password(myList, username);
//}
//            break;
//        }
//    }
//
//    private static void password(ArrayList<String> myList, String username) {
//        while (true) {
//            System.out.println("Password:");
//            Scanner p = new Scanner(System.in);
//            String password = p.nextLine();
//            if (myList.contains(password)) {
//                if (myList.indexOf(username) == (myList.indexOf(password)) - 1) {
//                    System.out.println("Felicitari a-ti introdus o parola corecta");
//                } else System.out.println("Ne pare rau dar nu puteti fi autentificat");
//                break;
//            } else System.out.println("Parola incorecta, mai incearca!");
//        }
//    }
//}
        File file = new File("C:\\Users\\constantinb\\Documents\\ana.txt");
        Scanner sc = new Scanner(file);

        ArrayList<String> fisier = new ArrayList<>();

        ArrayList<Destination> destinations = new ArrayList<>();
        ArrayList<City> cities = new ArrayList<>();
        Destination d = new Destination();
        while (sc.hasNextLine()) {
            fisier.add(sc.nextLine());
        }
        for (int i = 0; i < fisier.size(); i++) {
            if (fisier.get(i).startsWith("C")) {
                d = new Destination();
                d.setCountry(fisier.get(i));
                destinations.add(d);

            }
        }
            for (int j = 0; j < fisier.size(); j++) {
                if (fisier.get(j).startsWith("Y")) {
                    City c = new City();
                    c.setName(fisier.get(j));
                    cities.add(c);
                    d.setCities(cities);
                }
            }


            for (int i = 0; i < destinations.size(); i++) {
                System.out.println(destinations.get(i).getCountry());
                for (int j = 0; j < cities.size(); j++) {
                    System.out.println(cities.get(j).getName());
                }
            }

        }

    }





