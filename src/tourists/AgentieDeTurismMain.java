package tourists;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AgentieDeTurismMain {
    static  String booking=null; //"C:\\Users\\constantinb\\args\\booking.txt";
    static  String allDestinations=null; //"C:\\Users\\constantinb\\Documents\\Destination.txt";
    static  String autentification=null;// "C:\\Users\\constantinb\\Documents\\users.txt";
    static  ArrayList<Hotel> hotels = new ArrayList<>();
    static ArrayList<Destination> destinations = new ArrayList<>();
    static ArrayList<Hotel> sortarePret = new ArrayList<>();
    static ArrayList<String> ListaCuUseri = new ArrayList<>();
    static ArrayList<String> ListaCuParole = new ArrayList<>();
    static ArrayList<String> ListaCuTipuriDeUseri = new ArrayList<>();
    static boolean validareAutentificare = false;
    static int pozitieTipUser;

    public static void main(String[] args)  {
        for (int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        allDestinations = args[0];
        booking = args[1];
        autentification = args[2];

        ArrayList<String> myList = new ArrayList<>();
        try {
            creareListeDeAutentificare(myList, ListaCuUseri, ListaCuParole, ListaCuTipuriDeUseri);
    } catch (FileNotFoundException e) {
        System.out.println("Fisierul nu exista ");
    }
        ArrayList<String> fisier = new ArrayList<>();
        creareListaCuDate(fisier);
        creareListe(fisier, destinations, hotels);
        autentificareUseri(ListaCuUseri, ListaCuParole, ListaCuTipuriDeUseri);
    }
    public static void inchiereCamere() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = 0;
        boolean numarValidDeCamereInchiriate = false;
        Scanner keyboard = new Scanner(System.in);
        int nrCamereInchiriate = 0;
        String hotel = null;
        int numarCamere=0;
        int ca=0;
        try {
            try {
                FileReader fr = new FileReader(allDestinations);
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui pe care vreti sa il inchiriati");
                hotel = keyboard.nextLine();
                String line;
                String[] lineArr;
                while (reader.hasNextLine() && (line = reader.nextLine()) != null) {
                    lineArr = line.split("-");
                    if (lineArr[1].equals(hotel)) {
                        tempArray.add(lineArr[0] + "-" + lineArr[1]);
                        y = tempArray.indexOf(line);
                    } else tempArray.add(line);
                }
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("Path-ul nu este corect");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fisierul nu poate fi inchis");
        }
        if (y > 0) {
            try {
                System.out.println("Introduceti numarul de camere pe care vreti sa il inchiriati");
                nrCamereInchiriate = keyboard.nextInt();
                if (nrCamereInchiriate < 0) {
                    System.out.println("Numarul de camere este incorect si trebuie sa fie mai mare ca 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Caracterul nu este acceptat trebuie sa introduci cifre mai mari ca sau egale cu 0");
                numarValidDeCamereInchiriate = true;
            }
            String[] lineArr;
            lineArr = tempArray.get(y + 2).split("-");
            numarCamere = Integer.parseInt(lineArr[1]);
            if (Integer.parseInt(lineArr[1]) == 0) {
                System.out.println("Nu mai sunt camere disponibile ");
            }
            if ((Integer.parseInt(lineArr[1]) > 0) && (numarCamere - nrCamereInchiriate >= 0)) {
                for (int i = 0; i < tempArray.size(); i++) {
                    tempArray.remove(tempArray.get(y + 2));
                    tempArray.add(y + 2, "NC-" + (numarCamere - nrCamereInchiriate));
                    ca=numarCamere - nrCamereInchiriate;
                    break;
                }
            } else {
                System.out.println("Mai sunt disponibile doar " + numarCamere + "camere");
                numarValidDeCamereInchiriate=true;
            }
        } else
            System.out.println("Hotelul nu exista");
        if (y > 0 && numarValidDeCamereInchiriate == false && nrCamereInchiriate > 0) {
            scriereInFisierulBooking(tempArray, y);
            rescriereListaInFisier(tempArray);
            System.out.println("Felicitari a-ti inchiriat cu succes " + nrCamereInchiriate + " la hotelul " + hotel);
            System.out.println("Daca doriti sa adaugati rating hotelului apasati tasta 4");
            for (int k = 0; k < destinations.size(); k++) {
                Destination d = destinations.get(k);
                for (int l = 0; l < d.getCities().size(); l++) {
                    City c = d.getCities().get(l);
                    for (int b = 0; b < c.getHotels().size(); b++) {
                        if (c.getHotels().get(b).getName().equals("H-"+hotel)) {
                            c.getHotels().get(b).setAvailableRooms(ca);
                        }
                    }
                }
            }
        } else System.out.println("Nu s-a putut face booking-ul");
    }
   public static void scriereInFisierulBooking(ArrayList<String> tempArray, int y) {
        try {
            try {
                File file = new File(booking);
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter sr = new PrintWriter(bw);
                String [] linearr=tempArray.get(y).split("-");
                sr.println(linearr[1]);
                sr.println(ListaCuUseri.get(pozitieTipUser));
                System.out.println(tempArray.get(y));
                sr.close();
            } catch (FileNotFoundException e) {
                System.out.println("fisierul nu exista");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu a putut fi inchis");
        }
    }
    public static void adaugareNumarCamere() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = 0;
        boolean saIntrodusNumarDeCamereValid = false;
        String numarCamere = null;
        Scanner keyboard = new Scanner(System.in);
        String hotel=null;
        try {
            try {
                FileReader fr = new FileReader(allDestinations);
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui");
                hotel = keyboard.nextLine();
                String line;
                String[] lineArr;
                while (reader.hasNextLine() && (line = reader.nextLine()) != null) {
                    lineArr = line.split("-");
                    if (lineArr[1].equals(hotel)) {
                        tempArray.add(lineArr[0] + "-" + lineArr[1]);
                        y = tempArray.indexOf(line);
                    } else tempArray.add(line);
                }
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println(" Fisierul nu exista");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu poate fi inchis");
        }
        if (y > 0) {
            try {
                System.out.println("Introduceti numarul de camere disponibile");
                numarCamere = keyboard.nextLine();
                if (Integer.parseInt(numarCamere) < 0) {
                    System.out.println("Numarul de camere este incorect si trebuie sa fie mai mare ca 0");
                }
            } catch (NumberFormatException e) {
                saIntrodusNumarDeCamereValid = true;
                System.out.println("Caracterul nu este acceptat trebuie sa introduci cifre mai mari ca sau egale cu 0");
            }
            for (int i = 0; i < tempArray.size(); i++) {
                tempArray.remove(tempArray.get(y + 2));
                tempArray.add(y + 2, "NC-" + numarCamere);
            }
        } else
            System.out.println("Hotelul nu exista");
        if (saIntrodusNumarDeCamereValid == false && y>0) {
            for (int k = 0; k < destinations.size(); k++) {
                Destination d = destinations.get(k);
                for (int l = 0; l < d.getCities().size(); l++) {
                    City c = d.getCities().get(l);
                    for (int b = 0; b < c.getHotels().size(); b++) {
                        if (c.getHotels().get(b).getName().equals("H-"+hotel)) {
                            c.getHotels().get(b).setAvailableRooms(Integer.parseInt(numarCamere));
                        }
                    }
                }
            }
            rescriereListaInFisier(tempArray);
            System.out.println("Numarul de camere s-a updatat");
        } else  System.out.println("Modificarea nu s-a produs deoarece nu s-au indeplinit caracteristicile minime obligatorii");
    }
    public static void adaugarePretInFisier() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = 0;
        String hotel=null;
        String pret = null;
        Scanner keyboard = new Scanner(System.in);
        boolean saIntrodusUnPretAcceptat = false;
        try {
            try {
                FileReader fr = new FileReader(allDestinations);
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui");
                hotel = keyboard.nextLine();
                String line;
                String[] lineArr;
                while (reader.hasNextLine() && (line = reader.nextLine()) != null) {
                    lineArr = line.split("-");
                    if (lineArr[1].equals(hotel)) {
                        tempArray.add(lineArr[0] + "-" + lineArr[1]);
                        y = tempArray.indexOf(line);
                    } else tempArray.add(line);
                }
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu poate fi inchis");
        }
        if (y > 0) {
            try {
                System.out.println("Introduceti pretul hotelului");
                pret = keyboard.nextLine();
                if (Integer.parseInt(pret) < 0) {
                    System.out.println("Pretul este incorect si trebuie sa fie mai mare ca 0");
                }
            } catch (NumberFormatException e) {
                saIntrodusUnPretAcceptat = true;
                System.out.println("Caracterul nu este acceptat trebuie sa introduci cifre mai mari ca sau egale cu 0");
            }
            for (int i = 0; i < tempArray.size(); i++) {
                tempArray.remove(tempArray.get(y + 3));
                tempArray.add(y + 3, "P-" + pret);
            }
        } else if (y == 0) {
            System.out.println("Hotelul nu exista");
        }
        if (saIntrodusUnPretAcceptat == false && y>0) {
            rescriereListaInFisier(tempArray);
            for (int k = 0; k < destinations.size(); k++) {
                Destination d = destinations.get(k);
                for (int l = 0; l < d.getCities().size(); l++) {
                    City c = d.getCities().get(l);
                    for (int b = 0; b < c.getHotels().size(); b++) {
                        if (c.getHotels().get(b).getName().equals("H-"+hotel)) {
                            c.getHotels().get(b).setPrice(Double.parseDouble(pret));
                        }
                    }
                }
            }
            System.out.println("Pretul Hotelului a fost upadatat cu success");
        } else
            System.out.println("Modificarea nu s-a produs deoarece nu s-au indeplinit caracteristicile minime obligatorii");
    }
    public static void rescriereListaInFisier(ArrayList<String> tempArray) {
        try {
            try {

                PrintWriter pr = new PrintWriter(allDestinations);
                for (int i = 0; i < tempArray.size(); i++) {
                    pr.println((tempArray.get(i)));
                }
                pr.close();

            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu poate fi inchis");
        }
    }
    public static void adaugareInFisierHotel() {
            ArrayList<String> tempArray = new ArrayList<>();
            boolean existaOras = false;
            boolean rNCPbineIntroduse = false;
            String oras = null;
            String hotel = null;
            String rating = null;
            String numarCamere = null;
            String pret = null;
try {
    try {
        FileReader fr = new FileReader(allDestinations);
        Scanner reader = new Scanner(fr);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduceti orasul unde vreti sa adaugati hotelul");
        oras = keyboard.nextLine();
        System.out.println("Introduceti numele Hotelui nou");
        hotel = keyboard.nextLine();
            System.out.println("Ratingul initial este 0 cu 0 recenzii");
            rating = "0-0";
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
            if ( (Integer.parseInt(numarCamere) > 0) && (Integer.parseInt(pret) > 0)) {
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
                fr.close();
            } else
                System.out.println("Datele sunt introduse eronat");
        } catch (NumberFormatException e) {
        }
    } catch (FileNotFoundException e) {
        System.out.println("Fisierul nu exista");
    }
}catch (Exception e) {
}
            if (existaOras == false && rNCPbineIntroduse == true) {
                System.out.println("Orasul nu exista");
            }
            if (existaOras == true && rNCPbineIntroduse == false) {
                System.out.println("Orasul exista dar datele introduse sunt incorecte");
            }
            try {
                if ((Integer.parseInt(numarCamere) > 0) && (Integer.parseInt(pret) > 0) && existaOras == true) {
                    Hotel h=new Hotel();
                    for (int k = 0; k < destinations.size(); k++) {
                        Destination d = destinations.get(k);
                        for (int l = 0; l < d.getCities().size(); l++) {
                            City c = d.getCities().get(l);
                            if(d.getCities().get(l).getName().equals("CY-"+oras)){
                            for (int b = 0; b < c.getHotels().size(); b++) {
                                c.getHotels().add(h);
                                   h.setAvailableRooms(Integer.parseInt(numarCamere));
                                    h.setPrice(Double.parseDouble(pret));
                                    h.setRating(rating);
                                    h.setName(hotel);
                                    break;
                            }
                            }
                        }
                    }
                    rescriereListaInFisier(tempArray);
                    System.out.println("Noul hotel a fost creat cu success");
                } else System.out.println("Nu s-a putut crea hotel din cauza datelor introduse eronat");
            } catch (NumberFormatException e) {
                System.out.println("Nu s-a putut crea hotel din cauza datelor introduse eronat");
            }
        }
        public static void problema1SortareDupaPretCrescator(ArrayList<Hotel> sortarePret) {
        System.out.println(" Afisare Hoteluri In Functie De Preturi Crescatoare ");
           for (int i = 0; i < hotels.size(); i++) {
               for (int j = i + 1; j < hotels.size(); j++) {
                   if (hotels.get(i).getPrice() > hotels.get(j).getPrice()) {
                       Hotel temp = hotels.get(i);
                       hotels.set(i, hotels.get(j));
                       hotels.set(j, temp);
                   }
               }
               System.out.println((hotels.get(i).getName()+" "+hotels.get(i).getPrice()));
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
    public static void autentificareUseri(ArrayList<String> listaCuUseri, ArrayList<String> listaCuParole, ArrayList<String> listaCuTipuriDeUseri) {

        while (true) {
            System.out.println("Bine ai venit!");
            Scanner u = new Scanner(System.in);
            System.out.println("Username:");
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
                        } else {
                            System.out.println("Ne pare rau dar nu puteti fi autentificat");
                            continue;
                        }
                    } else {
                        System.out.println("Username or password incorect");
                        continue;
                    }
                } else {
                    System.out.println("Username or password incorect");
                    continue;
                }
            Meniu.meniu(ListaCuTipuriDeUseri, pozitieTipUser);
                break;
            }
    }
    public static void creareListe(ArrayList<String> fisier, ArrayList<Destination> destinations, ArrayList<Hotel> hotels) {
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
                                        h.setRating((v[1])+"-"+(v[2]));
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
    public static void creareListaCuDate(ArrayList<String> fisier) {
        File file = new File(allDestinations);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("fisierul nu fost gasit");
        }
        while (sc.hasNextLine()) { fisier.add(sc.nextLine()); }
    }
    public static void creareListeDeAutentificare(ArrayList<String> myList, ArrayList<String> listaCuUseri, ArrayList<String> listaCuParole, ArrayList<String> listaCuTipuriDeUseri) throws FileNotFoundException {
           File file2 = new File(autentification);
           Scanner sc = new Scanner(file2);
           while (sc.hasNextLine()) { myList.add(sc.nextLine()); }
           for (int i = 0; i < myList.size(); i += 3) { listaCuUseri.add(myList.get(i)); }
           for (int i = 1; i < myList.size(); i += 3) { listaCuParole.add(myList.get(i)); }
           for (int i = 2; i < myList.size(); i += 3) { listaCuTipuriDeUseri.add(myList.get(i)); }
   }
}
