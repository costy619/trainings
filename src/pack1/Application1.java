package pack1;

import java.io.*;
import java.util.*;

public class Application1 {
    static String user = null;
    static ArrayList<Destination> destinations = new ArrayList<>();
    static ArrayList<Hotel> hoteluri = new ArrayList<>();
    static ArrayList<Hotel> hoteluri2 = new ArrayList<>();
    static String rol = null;
    static String holiday = null;
    static String booking = null;
    static String users = null;

    // static String holiday1=null;
    public static void main(String[] args) throws FileNotFoundException {

        users = args[0];//"C:\\Users\\JohnSmith\\Documents\\users.txt"
        holiday = args[1];//C:\\Users\\JohnSmith\\Documents\\holiday.txt
        booking = args[2];//C:\\Users\\JohnSmith\\Documents\\booking.txt
        // holiday = args[3];//"holiday.txt"
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        ArrayList<String> fileList = adaugareDinFisier(holiday);
        login(users);
        metodaMain(fileList, hoteluri, hoteluri2, destinations);
        meniuPrincipal(holiday, booking);
    }

    private static void meniuPrincipal(String holiday, String booking) {
        while (true) {
            try {
                if ("admin".equals(rol)) {
                    meniuAdmin();
                }
                if ("client".equals(rol)) {
                    meniuClienti();
                }
                int n = readOption();

                if (n == 8) {
                    insertHotel(holiday);
                } else if (n == 9) {
                    modificaPret(holiday);
                } else if (n == 10) {
                    modificaNrCamere(holiday);
                }
                if (n == 1) {
                    afisareGenerala(destinations);
                } else if (n == 2) {
                    hotelDupaPret(hoteluri2);
                } else if (n == 3) {
                    hotelDupaRating(hoteluri2);
                } else if (n == 4) {
                    hoteluriPretEgal(hoteluri);
                } else if (n == 5) {
                    dacaTaraExista(destinations);
                } else if (n == 6) {
                    oferaRating(destinations, holiday, booking);
                } else if (n == 7) {
                    rezervaCamere(holiday, booking);
                } else if (n >= 12) {
                    System.out.println("Optiunea nu exista!");
                } else if (n == 0) {
                    logout();
                }
            } catch (Exception e) {
                System.out.println("Datele de login gresite");
            }
        }
    }

    private static int readOption() {
        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                System.out.println("Introduceti cifra corespunzatoare optiunii dorite: ");
                return s.nextInt();
            } catch (Exception e) {
                System.out.println("Trebuie sa introduci o cifra");
            }
        }
    }


    private static void logout() {
        while (true) {
            System.out.println("Ai iesit din meniu!");
            break;
        }
        try {
            login(users);
        } catch (FileNotFoundException e) {
            System.out.println("Nu s-a gasit fisierul");
            ;
        }
    }

    private static void meniuAdmin() {
        System.out.println("Meniul pentru admin:");
        System.out.println("0.Iesi din meniu");
        System.out.println("8.Adauga hotel");
        System.out.println("9. Modifica pretul unui hotel");
        System.out.println("10. Modifica numarul de camere");
    }

    private static void meniuClienti() {
        System.out.println("Meniu pentru client:");
        System.out.println("0.Iesi din meniu");
        System.out.println("1.Afisare a listei de destinatii cu hoteluri");
        System.out.println("2.Afisare hoteluri dupa pret");
        System.out.println("3.Afisare hoteluri dupa rating");
        System.out.println("4.Afisare hoteluri cu preturi egale");
        System.out.println("5.Verifica daca destinatia dorita exista in lista noastra");
        System.out.println("6.Ofera rating");
        System.out.println("7.Rezerva Camere");
    }


    private static void login(String users) throws FileNotFoundException {
        System.out.println("Bine ai venit, te rugam sa te loghezi!");
        System.out.println("Useranme");
        Scanner keyboard = new Scanner(System.in);
        user = keyboard.nextLine();
        System.out.println("Password");
        String parola = keyboard.nextLine();
        File file = new File(users);
        Scanner sc = new Scanner(file);
        boolean b = true;
        while (sc.hasNextLine()) {
            if (user.equals(sc.nextLine())) {
                if (parola.equals(sc.nextLine())) {
                    b = false;
                    rol = sc.nextLine();
                    break;
                }
            }
        }
        if (b == false) {
            System.out.println("Rolul este " + rol);
        } else {
            System.out.println("Datele introduse nu sunt corecte, reintrodu!");
            login(users);
        }

    }

    private static void metodaMain(ArrayList<String> fileList, ArrayList<Hotel> hoteluri, ArrayList<Hotel> hoteluri2, ArrayList<Destination> destinations) {
        for (int i = 0; i < fileList.size(); i++) {
            if (fileList.get(i).startsWith("D-")) {
                Destination d = new Destination();
                d.setCountry(fileList.get(i));
                destinations.add(d);
                d.setCities(new ArrayList<>());
                for (int j = i + 1; j < fileList.size(); j++) {
                    if (fileList.get(j).startsWith("CY-")) {
                        City c = new City();
                        String name2 = fileList.get(j);
                        c.setName(name2);
                        d.getCities().add(c);

                        c.setHotels(new ArrayList<>());
                        for (int k = j + 1; k < fileList.size(); k++) {
                            if (fileList.get(k).startsWith("H-")) {
                                Hotel h = new Hotel();
                                String name = fileList.get(k);
                                h.setName(name);
                                c.getHotels().add(h);
                                hoteluri.add(h);
                                hoteluri2.add(h);
                                for (int m = k + 1; m < fileList.size(); m++) {
                                    String st = fileList.get(m);

                                    if (st.startsWith("R-")) {
                                        String v[] = st.split("-");
                                        double rating = Double.parseDouble(v[1]);
                                        h.setRating(rating);
                                    }
                                    if (st.startsWith("NC-")) {
                                        String v[] = st.split("-");
                                        int availableRooms = Integer.parseInt(v[1]);
                                        h.setAvailableRooms(availableRooms);
                                    }
                                    if (st.startsWith("P-")) {
                                        String v[] = st.split("-");
                                        double price = Double.parseDouble(v[1]);
                                        h.setPrice(price);
                                    }
                                    if (st.startsWith("D-") || st.startsWith("CY-") || st.startsWith("H-")) {
                                        k = m;
                                        k--;
                                        break;
                                    }

                                }
                            } else {
                                if (fileList.get(k).startsWith("CY-")) {
                                    j = k;
                                    j--;
                                    break;
                                } else {

                                    if (fileList.get(k).startsWith("D-")) {
                                        j = k;
                                        j--;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        if (fileList.get(j).startsWith("D-")) {
                            i = j;
                            i--;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static ArrayList<String> adaugareDinFisier(String holiday) throws FileNotFoundException {
        File file = new File(holiday);//"holiday.txt"
        ArrayList<String> fileList = new ArrayList<>();
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            fileList.add(in.nextLine().trim());
        }
        return fileList;
    }

    private static void hotelOrdAceiasiLista(ArrayList<Hotel> hoteluri) {
        System.out.println("Hoteluri ordaonate in aceiasi lista");
        for (int i = 0; i < hoteluri.size(); i++) {
            for (int j = i + 1; j < hoteluri.size(); j++) {
                if (hoteluri.get(i).getPrice() > hoteluri.get(j).getPrice()) {

                    Hotel pret = hoteluri.get(i);
                    hoteluri.set(i, hoteluri.get(j));
                    hoteluri.set(j, pret);
                }
            }
        }
        System.out.println(" ");
        for (int i = 0; i < hoteluri.size(); i++) {
            System.out.println(hoteluri.get(i).getName() + " " + hoteluri.get(i).getPrice());

        }
    }

    private static void hoteluriPretEgal(ArrayList<Hotel> hoteluri) {
        System.out.println("Hotelurile care au acelasi pret");
        for (int i = 0; i < hoteluri.size(); i++) {
            for (int j = i + 1; j < hoteluri.size(); j++) {
                if (hoteluri.get(i).getPrice() == hoteluri.get(j).getPrice()) {
                    System.out.println(hoteluri.get(i).getName() + " cu " + hoteluri.get(j).getName());
                    //System.out.println(hoteluri.get(i).getPrice() + " "  + hoteluri.get(j).getPrice());
                }

            }
        }
    }

    private static void dacaTaraExista(ArrayList<Destination> destinations) {
        System.out.println("Introduceti tara (cu majuscula) pe care doriti sa o verificati daca exista");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String tara = sc.nextLine();
            if (tara.equals("GATA")) {
                break;
            }
            Boolean country = false;
            for (int i = 0; i < destinations.size(); i++) {
                String v[] = destinations.get(i).getCountry().split("-");
                if (tara.equals(v[1])) {
                    country = true;
                }

            }
            if (country == true) {
                System.out.println("Tara exista");
                System.out.println("Daca doriti sa mai verificati, introduceti tara, altfel introduceti GATA");

            } else {
                System.out.println("Tara nu exista, introduceti din nou!");
                System.out.println("Daca nu mai doriti sa introduceti tara, scrieti GATA");
            }
        }
    }

    private static void hotelDupaRating(ArrayList<Hotel> hoteluri2) {
        ArrayList<Hotel> ratingh2 = new ArrayList<>();
        System.out.println("Hotelurile mele dupa rating");
        for (int i = 0; i < hoteluri2.size(); i++) {
            for (int j = i + 1; j < hoteluri2.size(); j++) {
                if (hoteluri2.get(i).getRating() > hoteluri2.get(j).getRating()) {
                    Hotel rating;
                    rating = hoteluri2.get(i);
                    hoteluri2.set(i, hoteluri2.get(j));
                    hoteluri2.set(j, rating);
                }
            }
            ratingh2.add(hoteluri2.get(i));
        }
        for (int i = 0; i < ratingh2.size(); i++) {
            System.out.println(ratingh2.get(i).getName() + " " + ratingh2.get(i).getRating());
        }
    }

    private static void hotelDupaPret(ArrayList<Hotel> hoteluri2) {
        ArrayList<Hotel> priceh2 = new ArrayList<>();
        System.out.println("Hotelurile mele dupa pret:");
        for (int i = 0; i < hoteluri2.size(); i++) {
            for (int j = i + 1; j < hoteluri2.size(); j++) {
                if (hoteluri2.get(i).getPrice() < hoteluri2.get(j).getPrice()) {
                    Hotel pret;
                    pret = hoteluri2.get(i);
                    hoteluri2.set(i, hoteluri2.get(j));
                    hoteluri2.set(j, pret);
                }

            }
            priceh2.add(hoteluri2.get(i));
        }

        for (int i = 0; i < priceh2.size(); i++) {
            System.out.println(priceh2.get(i).getName() + "  " + priceh2.get(i).getPrice());
        }
    }

    private static void afisareGenerala(ArrayList<Destination> destinations) {
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println(destinations.get(i).getCountry());
            for (int j = 0; j < destinations.get(i).getCities().size(); j++) {
                System.out.println("  " + destinations.get(i).getCities().get(j).getName());
                for (int k = 0; k < destinations.get(i).getCities().get(j).getHotels().size(); k++) {
                    System.out.println("   " + destinations.get(i).getCities().get(j).getHotels().get(k).getName());
                    System.out.println("    R-" + destinations.get(i).getCities().get(j).getHotels().get(k).getRating());
                    System.out.println("    NC-" + destinations.get(i).getCities().get(j).getHotels().get(k).getAvailableRooms());
                    System.out.println("    P-" + destinations.get(i).getCities().get(j).getHotels().get(k).getPrice());
                }
            }
        }
    }

    public static void myMap(ArrayList<Hotel> hoteluri) {

        HashMap<String, Integer> map = new HashMap<>();
        Iterator<Hotel> it = hoteluri.iterator();
        while (it.hasNext()) {
            Hotel el = it.next();
            if (map.containsKey(el.getName())) {
                map.put(el.getName(), map.get(el.getName()) + 1);
            } else {
                map.put(el.getName(), 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> itm = map.entrySet().iterator();
        while (itm.hasNext()) {
            Map.Entry m = itm.next();
            System.out.print(m.getKey() + " ");
            System.out.println(m.getValue());
        }

    }

    public static void mySet(ArrayList<Hotel> hoteluri) {
        HashSet<String> set = new HashSet<>();
        for (int j = 0; j < hoteluri.size(); j++) {
            set.add(hoteluri.get(j).getName());
        }

        Iterator<String> itm = set.iterator();
        while (itm.hasNext()) {
            System.out.println(itm.next());

        }
    }

    private static void modificaPret(String holiday) {
        ArrayList<String> lista = new ArrayList<>();
        int pozitieHotel = 0;
        int pret = 0;
        Scanner keyboard = new Scanner(System.in);
        try {
            try {
                FileReader fr = new FileReader(holiday);
                Scanner reader = new Scanner(fr);

                System.out.println("Introduceti numele Hotelui");
                String hotel = keyboard.nextLine();

                String linie;
                String[] elementLinie;
                while ((linie = reader.nextLine()) != null) {
                    elementLinie = linie.split("-");
                    if (elementLinie[1].equals(hotel)) {
                        lista.add(elementLinie[0] + "-" + elementLinie[1]);
                        pozitieHotel = lista.indexOf(linie);
                    } else lista.add(linie);
                }
                try {
                    fr.close();
                } catch (IOException e) {
                }
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (NoSuchElementException e) {
            // System.out.println("Nu sunt linii de citit");
        }
        try {
            if (pozitieHotel > 0) {
                System.out.println("Introduceti noul pret al hotelului");
                pret = keyboard.nextInt();
            } else {
                System.out.println("Nu exista hotelul");
            }
        } catch (InputMismatchException e) {
            System.out.println("Trebuie introdus un numar");

        }

        for (int i = 0; i < lista.size(); i++) {
            if (pozitieHotel > 0) {
                if (pret > 0) {
                    lista.remove(pozitieHotel + 3);
                    lista.add(pozitieHotel + 3, "P-" + pret);
                    System.out.println("Pretul hotelului a fost modificat");
                    break;
                }
            }
        }
        try {
            try {
                PrintWriter pr = new PrintWriter(holiday);
                for (int i = 0; i < lista.size(); i++) {
                    pr.println((lista.get(i)));
                }
                pr.close();
                for (int k = 0; k < destinations.size(); k++) {
                    Destination d = destinations.get(k);
                    for (int l = 0; l < d.getCities().size(); l++) {
                        City c = d.getCities().get(l);
                        for (int b = 0; b < c.getHotels().size(); b++) {
                            if (c.getHotels().get(b).getName().equals(lista.get(pozitieHotel))) {
                                c.getHotels().get(b).setPrice(pret);
                                //  System.out.println(c.getHotels().get(b).getName());
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (Exception e) {
        }
    }

    private static void modificaNrCamere(String holiday) {
        ArrayList<String> lista = new ArrayList<>();
        int pozitieHotel = 0;
        int camere = 0;
        Scanner keyboard = new Scanner(System.in);
        try {
            try {
                FileReader fr = new FileReader(holiday);
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui");
                String hotel = keyboard.nextLine();
                String linie;
                String[] elementLinie;
                while ((linie = reader.nextLine()) != null) {
                    elementLinie = linie.split("-");
                    if (elementLinie[1].equals(hotel)) {
                        lista.add(elementLinie[0] + "-" + elementLinie[1]);
                        pozitieHotel = lista.indexOf(linie);
                    } else lista.add(linie);
                }
                try {
                    fr.close();

                } catch (IOException e) {
                }
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (NoSuchElementException e) {
            //   System.out.println("Nu sunt linii de citit");
        }

        try {
            if (pozitieHotel > 0) {
                System.out.println("Introduceti noul numar de camere al hotelului");
                camere = keyboard.nextInt();
            } else {
                System.out.println("Nu exista hotelul");

            }
        } catch (InputMismatchException e) {
            System.out.println("Trebuie introdus un numar");
        }

        for (int i = 0; i < lista.size(); i++) {
            if (pozitieHotel > 0) {
                if (camere > 0) {
                    lista.remove(pozitieHotel + 2);
                    lista.add(pozitieHotel + 2, "NC-" + camere);
                    System.out.println("Numarul de camere a fost schimbat!");
                    break;
                }
            }
        }
        try {
            try {
                PrintWriter pr = new PrintWriter(holiday);
                for (int i = 0; i < lista.size(); i++) {
                    pr.println((lista.get(i)));
                }
                pr.close();
                pr.close();
                for (int k = 0; k < destinations.size(); k++) {
                    Destination d = destinations.get(k);
                    for (int l = 0; l < d.getCities().size(); l++) {
                        City c = d.getCities().get(l);
                        for (int b = 0; b < c.getHotels().size(); b++) {
                            if (c.getHotels().get(b).getName().equals(lista.get(pozitieHotel))) {
                                c.getHotels().get(b).setAvailableRooms(camere);
                                //  System.out.println(c.getHotels().get(b).getName());
                            }
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (Exception e) {
        }
    }

    private static void insertHotel(String holiday) {
        ArrayList<String> lista = new ArrayList<>();
        while (true) {
            String oras = null;
            boolean pozitieOras = true;
            int numarCamere = 0;
            int rating = 0;
            String hotel;
            int pret;
            Hotel deAdaugat =null;
            try {
                try {
                    try {
                        FileReader fr = new FileReader(holiday);
                        Scanner reader = new Scanner(fr);
                        Scanner keyboard = new Scanner(System.in);
                        System.out.println("Introduceti orasul unde vreti sa adaugati hotelul");
                        System.out.println("GATA daca nu mai doresti sa mai adaugi");
                        oras = keyboard.nextLine();
                        if (oras.equals("GATA")) {
                            break;
                        }
                        System.out.println("Introduceti numele Hotelui nou");
                        hotel = keyboard.nextLine();
                        System.out.println("Introduceti ratingul hotelului");
                        rating = keyboard.nextInt();
                        System.out.println("Introduceti numarul de camere disponibile");
                        numarCamere = keyboard.nextInt();
                        System.out.println("Introduceti pretul hotelului");
                        pret = keyboard.nextInt();
                        String linie;
                        String[] elementLinie;
                        while ((linie = reader.nextLine()) != null) {
                            elementLinie = linie.split("-");
                            if (elementLinie[1].equals(oras)) {
                                deAdaugat = new Hotel();
                                pozitieOras = false;
                                lista.add(elementLinie[0] + "-" + elementLinie[1]);
                                lista.add("H-" + hotel);
                                lista.add("R-" + rating);
                                lista.add("NC-" + numarCamere);
                                lista.add("P-" + pret);
                                deAdaugat.setName("H-"+hotel);
                                deAdaugat.setRating(rating);
                                deAdaugat.setAvailableRooms(numarCamere);
                                deAdaugat.setPrice(pret);
                                System.out.println("Hotel adaugat!");
                            } else lista.add(linie);
                        }
                        if (pozitieOras == true) {
                            System.out.println("Orasul nu exista ca sa adaugati hotelul");
                        }
                        try {
                            fr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } catch (FileNotFoundException e) {
                        System.out.println("Fisierul nu a fost gasit!");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Trebuie introdusa o cifra");
                }

            } catch (NoSuchElementException ex) {
                // System.out.println("S-au terminat de citit liniile");
            }

            try {
                if ((pozitieOras == false) && (numarCamere > 0) && (rating > 0)) {

                    try {
                        try {

                            PrintWriter fr = new PrintWriter(holiday);
                            for (int i = 0; i < lista.size(); i++) {
                                fr.println((lista.get(i)));
                            }
                            fr.close();


                            for (int k = 0; k < destinations.size(); k++) {
                                Destination d = destinations.get(k);
                                for (int l = 0; l < d.getCities().size(); l++) {
                                    City c = d.getCities().get(l);
                                    if (d.getCities().get(l).getName().equals("CY-"+oras)) {
                                        c.getHotels().add(deAdaugat);
                                        hoteluri.add(deAdaugat);
                                        hoteluri2.add(deAdaugat);
                                    }
                                }
                            }

                            break;

                        } catch (FileNotFoundException e) {
                            System.out.println("Fisierul nu exista");

                        }
                    } catch (Exception e) {

                    }
                } else System.out.println("Nu se poate adauga hotelul, datele sunt incorecte");
            } catch (NumberFormatException e) {
                System.out.println("Datele nu corespund tipului lor");
            }
        }
    }

    private static void oferaRating(ArrayList<Destination> destinations, String holiday, String booking) {
        ArrayList<String> lista = new ArrayList<>();
        int pozitieHotel = 0;
        int rating = 0;
        Scanner keyboard = new Scanner(System.in);
        String hotel = null;
        String hotel2 = null;
        String[] elementLinie = new String[0];
        String[] element = new String[0];
        String linie = null;
        ArrayList<String> lista2 = new ArrayList<>();
        int pozitieLinie = 0;
        Double a = 0.0;
        try {
            try {
                FileReader fr = new FileReader(holiday);
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui la care ati fost cazat pentru a ii ofeiti rating");
                hotel = keyboard.nextLine();
                while ((linie = reader.nextLine()) != null) {
                    elementLinie = linie.split("-");
                    if (elementLinie[1].equals(hotel)) {
                        lista.add(elementLinie[0] + "-" + elementLinie[1]);
                        pozitieHotel = lista.indexOf(linie);
                    } else lista.add(linie);
                }
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu exista");
            }
        } catch (Exception e) {
        }
        try {
            try {

                FileReader fr = new FileReader(booking);
                Scanner reader = new Scanner(fr);
                while ((linie = reader.nextLine()) != null) {
                    lista2.add(linie);
                    if (linie.equals(hotel)) {
                        hotel2 = linie;
                        pozitieLinie = lista2.indexOf(linie);
                    }
                }
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu a fost gasit");
            }
        } catch (Exception e) {
        }
        try {
            Map<String, Set<String>> h = new HashMap<>();
            for (int i = 0; i < lista2.size(); i = i + 2) {
                if (h.get(lista2.get(i)) == null) {
                    h.put(lista2.get(i), new HashSet<>());
                    h.get(lista2.get(i)).add(lista2.get(i + 1));
                } else {
                    h.get(lista2.get(i)).add(lista2.get(i + 1));
                }
            }
            if (h.get(hotel) != null) {
                if (h.get(hotel).contains(user)) {
                    System.out.println("Ofera rating");
                    rating = keyboard.nextInt();
                    if (rating < 0) {
                        if (rating > 11) {
                            System.out.println("Ratingul trebuie sa fie cuprins intre 0 si 10");
                        }
                        System.out.println("Ratingul trebuie sa fie cuprins intre 0 si 10");
                    }
                } else {
                    System.out.println("Nu ati stat la acest hotel");
                }
                for (int i = 0; i < lista.size(); i++) {
                    if (pozitieHotel > 0) {
                        if (rating > 0 && rating < 11) {
                            element = lista.get(pozitieHotel + 1).split("-");
                            Double ratingInitial = Double.parseDouble(element[1]);
                            lista.remove(pozitieHotel + 1);
                            lista.add(pozitieHotel + 1, "R-" + (rating + ratingInitial) / 2);
                            a = (rating + ratingInitial) / 2;
                            break;

                        }
                    }
                }
            } else System.out.println("Nu exista hotelul");
        } catch (InputMismatchException e) {
            System.out.println("Trebuie introdusa o cifra");
        }

        try {
            try {
                if (pozitieHotel > 0 && rating > 0 && rating < 11) {
                    PrintWriter pr = new PrintWriter(holiday);
                    for (int i = 0; i < lista.size(); i++) {
                        pr.println((lista.get(i)));
                    }
                    System.out.println("Rating oferit!");
                    pr.close();
                    for (int k = 0; k < destinations.size(); k++) {
                        Destination d = destinations.get(k);
                        for (int l = 0; l < d.getCities().size(); l++) {
                            City c = d.getCities().get(l);
                            for (int b = 0; b < c.getHotels().size(); b++) {
                                if (c.getHotels().get(b).getName().equals("H-" + hotel)) {
                                    c.getHotels().get(b).setRating(a);
                                    //  System.out.println(c.getHotels().get(b).getName());
                                }
                            }
                        }
                    }
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Fisierul nu exista");
            }
        } catch (Exception e) {
        }
    }

    private static void rezervaCamere(String holiday, String booking) {
        ArrayList<String> lista = new ArrayList<>();
        int pozitieHotel = -1;
        String camere = null;
        Scanner keyboard = new Scanner(System.in);
        String linie = null;
        String[] elementLinie;
        String hotel = null;
        int nrCamereRezervate = 0;
        int rezultat = 0;
        boolean nuRezervare = false;
        try {
            try {
                FileReader fr = new FileReader(holiday);
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele Hotelui");
                hotel = keyboard.nextLine();
                while (reader.hasNextLine() && (linie = reader.nextLine()) != null) {
                    elementLinie = linie.split("-");
                    if (elementLinie[1].equals(hotel)) {
                        lista.add(elementLinie[0] + "-" + elementLinie[1]);
                        pozitieHotel = lista.indexOf(linie);
                    } else lista.add(linie);
                }
                fr.close();
            } catch (FileNotFoundException e) {
            }
        } catch (Exception e) {
        }
        if (pozitieHotel >= 0) {
            System.out.println("Introduceti cate camere doriti sa rezervati?");
            try {
                camere = keyboard.nextLine();
                nrCamereRezervate = Integer.parseInt(camere);

            } catch (NumberFormatException ex) {
                System.out.println("Trebuie introdusa cifra");
                nuRezervare = true;
            }

            for (int i = 0; i < lista.size(); i++) {
                elementLinie = lista.get(pozitieHotel + 2).split("-");
                if (elementLinie[1] != null) {
                    int nrCamereInitiale = (Integer.valueOf(elementLinie[1]));
                    lista.remove(pozitieHotel + 2);
                    rezultat = nrCamereInitiale - nrCamereRezervate;
                    if (rezultat >= 0) {
                        lista.add(pozitieHotel + 2, "NC-" + rezultat);
                        break;
                    } else {
                        System.out.println("Nu va putem caza, numarul de camere nu este disponibil, ne mai trebuie " + rezultat + " camere");
                        lista.add(pozitieHotel + 2, "NC-" + elementLinie[1]);
                        break;
                    }
                } else {
                    System.out.println("Nr invalid");
                }
            }
        } else {
            System.out.println("Nu exista hotelul");
        }
        try {
            try {
                PrintWriter pr = new PrintWriter(holiday);
                for (int i = 0; i < lista.size(); i++) {
                    pr.println((lista.get(i)));
                }
                pr.close();
            } catch (Exception e) {
                System.out.println("Nu s-a gasit fisierul");
            }
        } catch (Exception e) {
        }
        if (pozitieHotel >= 0 && nuRezervare == false && rezultat >= 0) {
            try {
                FileReader fisier = new FileReader(booking);
                ArrayList<String> lista2 = new ArrayList<>();
                lista2.add(hotel);
                lista2.add(user);
                System.out.println("Rezervat!");
                fisier.close();

                try {
                    try {
                        FileWriter fileWriter = new FileWriter(booking, true); //Set true for append mode
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        for (int i = 0; i < lista2.size(); i++) {
                            printWriter.println((lista2.get(i)));
                        }
                        printWriter.close();
                        for (int k = 0; k < destinations.size(); k++) {
                            Destination d = destinations.get(k);
                            for (int l = 0; l < d.getCities().size(); l++) {
                                City c = d.getCities().get(l);
                                for (int b = 0; b < c.getHotels().size(); b++) {
                                    if (c.getHotels().get(b).getName().equals("H-" + hotel)) {
                                        c.getHotels().get(b).setAvailableRooms(rezultat);
                                        // System.out.println(c.getHotels().get(b).getName());
                                    }
                                }
                            }
                        }

                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            } catch (FileNotFoundException e) {
                System.out.println("Nu exista fisierul");
                ;
            } catch (IOException e) {
            }
        } else
            System.out.println("Nu s-a adaugat rezervarea");
    }

}
