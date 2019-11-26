package tourists;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Autentificare {
    public static final String C_USERS_CONSTANTINB_DOCUMENTS_ANA_TXT = "C:\\Users\\constantinb\\Documents\\ana.txt";
    private static ArrayList<Hotel> hotels = new ArrayList<>();
    private static ArrayList<Destination> destinations = new ArrayList<>();
    private static ArrayList<Hotel> sortarePret = new ArrayList<>();
    private static ArrayList<String> ListaCuUseri = new ArrayList<>();
    private static ArrayList<String> ListaCuParole = new ArrayList<>();
    private static ArrayList<String> ListaCuTipuriDeUseri = new ArrayList<>();
    private static boolean validareAutentificare = false;
    private static int pozitieTipUser;


    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> myList = new ArrayList<>();
        creareListeDeAutentificare(myList, ListaCuUseri, ListaCuParole, ListaCuTipuriDeUseri);
        ArrayList<String> fisier = new ArrayList<>();
        creareListaCuDate(fisier);

        creareListe(fisier, destinations, hotels);
        autentificareUseri(ListaCuUseri, ListaCuParole, ListaCuTipuriDeUseri);
        meniu(ListaCuTipuriDeUseri, pozitieTipUser);
//        afisareListeCreate(destinations);

    }

    private static void capabilDeAOferiRating() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = -1;
        String hotel = null;
        Scanner keyboard = new Scanner(System.in);
        boolean poateDaRating = false;
        try {
            try {

                FileReader fr = new FileReader("C:\\Users\\constantinb\\Documents\\costy.txt");
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele hotelului pentru care vreti sa introduceti ratingul ");
                hotel = keyboard.nextLine();
                String line;
                while ((line = reader.nextLine()) != null) {
                    if (line.equals(hotel)) {
                        tempArray.add(line);
                        y = tempArray.indexOf(line);
                    } else tempArray.add(line);
                }
                fr.close();


            } catch (FileNotFoundException e) {
            }
        } catch (Exception e) {

        }
        if (y >= 0) {
            for (int i = 0; i < tempArray.size(); i++) {
                if (tempArray.get(y + 1).equals(ListaCuUseri.get(pozitieTipUser))) {
                    poateDaRating = true;
                    break;
                }
            }
        } else
            System.out.println("Nu puteti oferi rating pentru hotelul" + hotel);
        if (poateDaRating == true) {

            ArrayList<String> tempArray1 = new ArrayList<>();
            int pozitiaHotelului = 0;
            double rating;
            try {
                try {

                    FileReader fr = new FileReader("C:\\Users\\constantinb\\Documents\\ana.txt");
                    Scanner reader = new Scanner(fr);
                    String line;
                    String[] lineArr1;
                    while ((line = reader.nextLine()) != null) {
                        lineArr1 = line.split("-");
                        if (lineArr1[1].equals(hotel)) {
                            tempArray1.add(lineArr1[0] + "-" + lineArr1[1]);
                            pozitiaHotelului = tempArray1.indexOf(line);
                        } else tempArray1.add(line);
                    }
                    fr.close();


                } catch (FileNotFoundException e) {
                }
            } catch (Exception e) {

            }
            try {
                try {
                    if (pozitiaHotelului > 0) {
                        System.out.println("Introduceti noul rating al hotelului");
                        rating = Double.parseDouble(keyboard.nextLine());
                        if (rating > 0 && rating < 11) {
                            String[] lineArr;
                            for (int i = 0; i < tempArray1.size(); i++) {
                                lineArr = tempArray1.get(pozitiaHotelului + 1).split("-");
                                Double c = Double.parseDouble(lineArr[2]);
                                System.out.println(lineArr[2]);
                                Double b = Double.parseDouble(lineArr[1]);
                                tempArray1.remove(tempArray1.get(pozitiaHotelului + 1));
                                if (c == 0) {
                                    tempArray1.add(pozitiaHotelului + 1, "R-" + rating + "-" + (1 + c));
                                } else tempArray1.add(pozitiaHotelului + 1, "R-" + (rating + b) / 2 + "-" + (1 + c));
                                break;
                            }
                        } else
                            System.out.println("Ratingul trebuie sa fie cuprins intre 0 si 10 apasa iar obtiunea 4 pentru a incerca din nou");
                    } else
                        System.out.println("Hotelul nu exista");
                } catch (NumberFormatException e) {
                    System.out.println("Ratingul trebuie sa fie un numar cuprins intre 0 si 10 apasa iar obtiunea 4 pentru a incerca din nou");
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            rescriereListaInFisier(tempArray1);
        }
    }

    private static void inchiereCamere() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = 0;
        Scanner keyboard = new Scanner(System.in);
        try {
            try {
                FileReader fr = new FileReader("C:\\Users\\constantinb\\Documents\\ana.txt");
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui pe care vreti sa il inchiriati");
                String hotel = keyboard.nextLine();
                String line;
                String[] lineArr;
                while ((line = reader.nextLine()) != null) {
                    lineArr = line.split("-");
                    if (lineArr[1].equals(hotel)) {
                        tempArray.add(lineArr[0] + "-" + lineArr[1]);
                        y = tempArray.indexOf(line);
                    } else tempArray.add(line);
                }

                fr.close();

            } catch (FileNotFoundException e) {
            }
        } catch (Exception e) {
        }
        if (y > 0) {
            System.out.println("Introduceti numarul de camere pe care vreti sa il inchiriati");
            int nrCamereInchiriate = keyboard.nextInt();
            String[] lineArr;
            lineArr = tempArray.get(y + 2).split("-");
            int numarCamere = Integer.parseInt(lineArr[1]);
            if (Integer.parseInt(lineArr[1]) == 0) {
                System.out.println("Nu mai sunt camere disponibile ");
            }

            if ((Integer.parseInt(lineArr[1]) > 0) && (numarCamere - nrCamereInchiriate >= 0)) {
                for (int i = 0; i < tempArray.size(); i++) {
                    tempArray.remove(tempArray.get(y + 2));
                    tempArray.add(y + 2, "NC-" + (numarCamere - nrCamereInchiriate));
                    break;
                }
            } else System.out.println("Mai sunt disponibile doar " + numarCamere + "camere");
        } else
            System.out.println("Hotelul nu exista");

        scriereInFisierulBooking(tempArray, y);
        rescriereListaInFisier(tempArray);
    }

    private static void scriereInFisierulBooking(ArrayList<String> tempArray, int y) {
        try {
            try {

                File file = new File("C:\\Users\\constantinb\\Documents\\costy.txt");
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter sr = new PrintWriter(bw);
                sr.println(tempArray.get(y));
                sr.println(ListaCuUseri.get(pozitieTipUser));
                System.out.println(tempArray.get(y));
                sr.close();
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }


    private static void adaugareNumarCamere() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = 0;
        String numarCamere = null;
        Scanner keyboard = new Scanner(System.in);
        try {
            try {

                FileReader fr = new FileReader(C_USERS_CONSTANTINB_DOCUMENTS_ANA_TXT);
                Scanner reader = new Scanner(fr);

                System.out.println("Introduceti numele Hotelui");
                String hotel = keyboard.nextLine();

                String line;
                String[] lineArr;
                while ((line = reader.nextLine()) != null) {
                    lineArr = line.split("-");
                    if (lineArr[1].equals(hotel)) {
                        tempArray.add(lineArr[0] + "-" + lineArr[1]);
                        y = tempArray.indexOf(line);
                    } else tempArray.add(line);
                }

                fr.close();

            } catch (FileNotFoundException e) {
            }
        } catch (Exception e) {
        }
        if (y > 0) {
            System.out.println("Introduceti noul numar de camere disponibile");
            numarCamere = keyboard.nextLine();
            for (int i = 0; i < tempArray.size(); i++) {
                tempArray.remove(tempArray.get(y + 2));
                tempArray.add(y + 2, "NC-" + numarCamere);
            }
        } else
            System.out.println("Hotelul nu exista");


        rescriereListaInFisier(tempArray);
    }

    private static void adaugarePretInFisier() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = 0;
        String pret = null;
        Scanner keyboard = new Scanner(System.in);
        try {
            try {

                FileReader fr = new FileReader("C:\\Users\\constantinb\\Documents\\ana.txt");
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui");
                String hotel = keyboard.nextLine();
                String line;
                String[] lineArr;
                while ((line = reader.nextLine()) != null) {
                    lineArr = line.split("-");
                    if (lineArr[1].equals(hotel)) {
                        tempArray.add(lineArr[0] + "-" + lineArr[1]);
                        y = tempArray.indexOf(lineArr);
                        System.out.println(y = tempArray.indexOf(line));
                    } else tempArray.add(line);
                }
                fr.close();


            } catch (FileNotFoundException e) {
            }
        } catch (Exception e) {

        }
        if (y > 0) {
            System.out.println("Introduceti noul pret al hotelului");
            pret = keyboard.nextLine();

            for (int i = 0; i < tempArray.size(); i++) {
                tempArray.remove(tempArray.get(y + 3));
                tempArray.add(y + 3, "P-" + pret);
            }
        } else
            System.out.println("Hotelul nu exista");

        rescriereListaInFisier(tempArray);
    }

    private static void rescriereListaInFisier(ArrayList<String> tempArray) {
        try {
            try {

                PrintWriter pr = new PrintWriter("C:\\Users\\constantinb\\Documents\\ana.txt");
                for (int i = 0; i < tempArray.size(); i++) {
                    pr.println((tempArray.get(i)));
                }
                pr.close();

            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }

    private static void adaugareInFisierHotel() {
        ArrayList<String> tempArray = new ArrayList<>();
        boolean existaOras = false;
        boolean rNCPbineIntroduse = false;
        String oras = null;
        String hotel = null;
        String rating = null;
        String numarCamere = null;
        String pret = null;

            try {
                FileReader fr = new FileReader("C:\\Users\\constantinb\\Documents\\ana.txt");
                Scanner reader = new Scanner(fr);
                Scanner keyboard = new Scanner(System.in);

                System.out.println("Introduceti orasul unde vreti sa adaugati hotelul");
                oras = keyboard.nextLine();
                System.out.println("Introduceti numele Hotelui nou");
                hotel = keyboard.nextLine();
                try {
                    System.out.println("Introduceti ratingul hotelului");
                    rating = keyboard.nextLine();
                    if (Integer.parseInt(rating) < 0 || Integer.parseInt(rating) > 11) {
                        System.out.println("Ratingul este incorect si trebuie sa fie cuprins intre 0 si 10");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Caracterul nu este acceptat trebuie sa introduci cifre  intre 0 si 10");
                }
                try {
                    System.out.println("Introduceti numarul de camere disponibile");
                    numarCamere = keyboard.nextLine();
                    if (Integer.parseInt(numarCamere) < 0) {
                        System.out.println("Numarul de camere este incorect si trebuie sa fie mai mare ca 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Caracterul nu este acceptat trebuie sa introduci cifre mai mari ca sau egale cu 0");
                }
                try {
                    System.out.println("Introduceti pretul hotelului");
                    pret = keyboard.nextLine();
                    if (Integer.parseInt(pret) < 0) {
                        System.out.println("Pretul este incorect si trebuie sa fie mai mare ca 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Caracterul nu este acceptat trebuie sa introduci cifre mai mari ca sau egale cu 0");
                }

                String line;
                String[] lineArr;
                try {
                    if ((Integer.parseInt(rating) > 0 && Integer.parseInt(rating) < 11) && (Integer.parseInt(numarCamere) > 0) && (Integer.parseInt(pret) > 0)) {
                        rNCPbineIntroduse = true;
                        while ((line = reader.nextLine()) != null) {
                            lineArr = line.split("-");

                            if (lineArr[1].equals(oras)) {
                                existaOras = true;
                                tempArray.add(lineArr[0] + "-" + lineArr[1]);
                                tempArray.add("H-" + hotel);
                                tempArray.add("R-" + rating);
                                tempArray.add("NC-" + numarCamere);
                                tempArray.add("P-" + pret);

                            } else tempArray.add(line);
                        }
                        try {
                            fr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else
                        System.out.println("Datele sunt introduse eronat");
                } catch (NumberFormatException e) {
                }
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }


        if (existaOras == false && rNCPbineIntroduse == true) {
            System.out.println("Orasul nu exista");
        }
        if (existaOras == true && rNCPbineIntroduse == false) {
            System.out.println("Orasul exista dar datele introduse sunt incorecte");
        }

        try {
            if ((Integer.parseInt(rating) > 0 && Integer.parseInt(rating) < 11) && (Integer.parseInt(numarCamere) > 0) && (Integer.parseInt(pret) > 0) && existaOras == true) {
                rescriereListaInFisier(tempArray);
                System.out.println("Noul hotel a fost creat cu success");
            } else System.out.println("Nu s-a putut crea hotel din cauza datelor introduse eronat");
        } catch (NumberFormatException e) {

            System.out.println("Nu s-a putut crea hotel din cauza datelor introduse eronat");
        }
    }

    private static void problema1SortareDupaPretCrescator(ArrayList<Hotel> sortarePret) {
        System.out.println(" Afisare Hoteluri In Functie De Preturi Crescatoare ");
        for (int i = 0; i < hotels.size(); i++) {
            for (int j = i + 1; j < hotels.size(); j++) {
                if (hotels.get(i).getPrice() > hotels.get(j).getPrice()) {
                    Hotel temp = hotels.get(i);
                    hotels.set(i, hotels.get(j));
                    hotels.set(j, temp);
                }
            }
            sortarePret.add(hotels.get(i));
        }
        for (int i = 0; i < sortarePret.size(); i++) {
            System.out.println(sortarePret.get(i) + "  " + sortarePret.get(i).getPrice());
        }

    }

    public static void meniu(ArrayList<String> listaCuTipuriDeUseri, int pozitieTipUser) {
        if (listaCuTipuriDeUseri.get(pozitieTipUser).equals("client") && validareAutentificare == true) {
            Scanner keyboard = new Scanner(System.in);
            while (true) {
                meniulClientilor();
                try {
                    System.out.println("Introduceti optiunea: ");
                    String n = keyboard.next();

                    if (n.equals("1")) {
                        afisareListeCreate(destinations);

                    }
                    if (n.equals("2")) {
                        problema1SortareDupaPretCrescator(sortarePret);
                    }
                    if (n.equals("3")) {
                        inchiereCamere();
                    }
                    if (n.equals("4")) {
                        capabilDeAOferiRating();
                    }
                    if (n.equals("5")) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Reintrodu o optiune ");
                }
            }
        } else if (listaCuTipuriDeUseri.get(pozitieTipUser).equals("admin") && validareAutentificare == true) {
            System.out.println();
            Scanner keyboard = new Scanner(System.in);
            while (true) {
                meniulAdminilor();
                try {
                    System.out.println("Introduceti optiunea: ");
                    String n = keyboard.next();
                    if (n.equals("1")) {
                        adaugareInFisierHotel();
                    }
                    if (n.equals("2")) {
                        adaugarePretInFisier();
                    }

                    if (n.equals("3")) {
                        adaugareNumarCamere();
                    }
                    if (n.equals("4")) {

                    }
                    if (n.equals("5")) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Reintrodu o optiune ");
                }
            }
        }
    }

    public static void afisareListeCreate(ArrayList<Destination> destinations) {
        for (int k = 0; k < destinations.size(); k++) {
            System.out.println(destinations.get(k).getCountry());
            Destination d = destinations.get(k);
            for (int l = 0; l < d.getCities().size(); l++) {
                System.out.println("     " + destinations.get(k).getCities().get(l).getName());
                City c = d.getCities().get(l);
                for (int b = 0; b < c.getHotels().size(); b++) {
                    System.out.println("         " + c.getHotels().get(b).getName());
                    System.out.println("          Rating " + c.getHotels().get(b).getRating());
                    System.out.println("          AvailableRooms " + c.getHotels().get(b).getAvailableRooms());
                    System.out.println("          Price " + c.getHotels().get(b).getPrice());

                }
            }
        }
    }

    private static void meniulAdminilor() {
        System.out.println("1.Adauga Hotel");
        System.out.println("2.Modificare pret pentru un hotel existent");
        System.out.println("3.Modificare numar camere pentru un hotel existent");
        System.out.println("5.Iesi din aplicatie");
    }

    public static void meniulClientilor() {
        System.out.println("1.Afisare destinatii ");
        System.out.println("2.Ordonare dupa pret");
        System.out.println("3.Inchiriere camere");
        System.out.println("4.Ofera rating");
        System.out.println("5.Iesi din aplicatie");
    }

    private static void autentificareUseri(ArrayList<String> listaCuUseri, ArrayList<String> listaCuParole, ArrayList<String> listaCuTipuriDeUseri) {

        while (true) {
            System.out.println("Bine ai venit!");
            System.out.println("Username:");
            Scanner u = new Scanner(System.in);
            String username = u.nextLine();
            pozitieTipUser = listaCuUseri.indexOf(username);
            if (listaCuUseri.contains(username)) {
                System.out.println("Password:");
                Scanner p = new Scanner(System.in);
                String password = p.nextLine();
                if (listaCuParole.contains(password)) {
                    if (listaCuUseri.indexOf(username) == listaCuParole.indexOf(password)) {
                        validareAutentificare = true;
                        System.out.println(username + " este " + listaCuTipuriDeUseri.get(pozitieTipUser));
                    } else System.out.println("Ne pare rau dar nu puteti fi autentificat");
                } else System.out.println("Username or password incorect");
            } else System.out.println("Username or password incorect");
            break;
        }
    }

    private static void creareListe(ArrayList<String> fisier, ArrayList<Destination> destinations, ArrayList<Hotel> hotels) {
        for (int i = 0; i < fisier.size(); i++) {
            if (fisier.get(i).startsWith("C-")) {
                Destination d = new Destination();
                d.setCountry(fisier.get(i));
                destinations.add(d);
                d.setCities(new ArrayList());
                for (int j = i + 1; j < fisier.size(); j++) {
                    if (fisier.get(j).startsWith("CY-")) {
                        City c = new City();
                        c.setName(fisier.get(j));
                        d.getCities().add(c);
                        c.setHotels(new ArrayList<>());
                        for (int a = j + 1; a < fisier.size(); a++) {
                            if (fisier.get(a).startsWith("H-")) {
                                Hotel h = new Hotel();
                                h.setName(fisier.get(a));
                                c.getHotels().add(h);
                                hotels.add(h);
                                for (int m = a + 1; m < fisier.size(); m++) {

                                    if (fisier.get(m).startsWith("R-")) {
                                        String[] v = (fisier.get(m).split("-"));
                                        h.setRating(Double.parseDouble(v[1]));

                                    } else {
                                        if (fisier.get(m).startsWith("NC-")) {
                                            String[] v = (fisier.get(m).split("-"));
                                            h.setAvailableRooms(Integer.parseInt(v[1]));
                                            m++;
                                        }
                                        if (fisier.get(m).startsWith("P-")) {
                                            String[] v = (fisier.get(m).split("-"));
                                            h.setPrice(Double.parseDouble(v[1]));
                                        }

                                        if (fisier.get(j).startsWith("CY-") || fisier.get(j).startsWith("C-") || fisier.get(j).startsWith("H-"))
                                            a = m;
                                        a--;
                                        break;
                                    }
                                }

                            } else if (fisier.get(a).startsWith("CY-")) {
                                j = a;
                                j--;
                                break;
                            } else if (fisier.get(a).startsWith("C-")) {
                                j = a;
                                j--;
                                break;

                            }

                        }
                    } else if (fisier.get(j).startsWith("C-")) {
                        i = j;
                        i--;
                        break;
                    }

                }
            }
        }

    }

    private static void creareListaCuDate(ArrayList<String> fisier) {
        File file = new File("C:\\Users\\constantinb\\Documents\\ana.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            fisier.add(sc.nextLine());
        }
    }

    private static void creareListeDeAutentificare(ArrayList<String> myList, ArrayList<String> listaCuUseri, ArrayList<String> listaCuParole, ArrayList<String> listaCuTipuriDeUseri) throws FileNotFoundException {
        File file2 = new File("C:\\Users\\constantinb\\Documents\\users.txt");
        Scanner sc = new Scanner(file2);
        {
            while (sc.hasNextLine()) {
                myList.add(sc.nextLine());
            }
            for (int i = 0; i < myList.size(); i += 3) {
                listaCuUseri.add(myList.get(i));
//
            }
            for (int i = 1; i < myList.size(); i += 3) {
                listaCuParole.add(myList.get(i));
//
            }
            for (int i = 2; i < myList.size(); i += 3) {
                listaCuTipuriDeUseri.add(myList.get(i));
//
            }
        }
    }
}
