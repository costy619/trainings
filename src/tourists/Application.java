package tourists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Integer.*;

public class Application {
     public static ArrayList<Hotel> hotels = new ArrayList<>();
    public static void main(String[] args) throws NullPointerException {

        ArrayList<String> fisier = new ArrayList<>();
        creareListaCuDate(fisier);
        ArrayList<Destination> destinations = new ArrayList<>();
        ArrayList<Hotel> sortarePret=new ArrayList<>() ;
        ArrayList<Hotel> sortareRating =new ArrayList<>();


        creareListe(fisier, destinations, hotels);
        afisareListeCreate(destinations);
//        System.out.println("Introduceti tara pe care sa o cauti ");
//        String g = introducereDeLaTastatura();
//        existentaTara(destinations, g);
        hoteluriCuAcelasiPret(hotels);
        problema1SortareDupaPretCrescator(sortarePret);
//        problema2SortareDupaRating(sortareRating);
        problema3AdaugareInFisier();

       Set<Double> map=new HashSet<>();
        Iterator<Hotel> iterator1 = hotels.iterator();

        while(iterator1.hasNext()){
            Hotel el=iterator1.next();
                map.add(el.getPrice());
        }

        Iterator<Double> iterator = map.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }


    private static void problema3AdaugareInFisier() {
        ArrayList<String> tempArray=new ArrayList<>();
        try{
            try{
                FileReader fr=new FileReader("C:\\Users\\constantinb\\Documents\\ana.txt");
                Scanner reader=new Scanner(fr);
                Scanner keyboard=new Scanner(System.in);
                System.out.println("Introduceti orasul unde vreti sa adaugati hotelul");
                String oras=keyboard.nextLine();
                System.out.println("Introduceti numele Hotelui nou");
                String hotel=keyboard.nextLine();
                System.out.println("Introduceti ratingul hotelului");
                String rating=keyboard.nextLine();
                System.out.println("Introduceti numarul de camere disponibile");
                String numarCamere=keyboard.nextLine();
                System.out.println("Introduceti pretul hotelului");
                String pret=keyboard.nextLine();
                String line;
                String[] lineArr;
                while((line=reader.nextLine())!=null){
                    lineArr=line.split("-");
                    if(lineArr[1].equals(oras)){
                        tempArray.add(lineArr[0]+"-"+lineArr[1]);
                        tempArray.add("H-"+hotel);
                        tempArray.add("R-"+rating);
                        tempArray.add("NC-"+numarCamere);
                        tempArray.add("P-"+pret);

                    }else tempArray.add(line);
                }
                fr.close();

            } catch (FileNotFoundException e) {
            }
        } catch (Exception e){

        }
        try {
            try {
                PrintWriter pr=new PrintWriter("C:\\Users\\constantinb\\Documents\\ana.txt");
                for(int i=0;i<tempArray.size();i++){
                    pr.println((tempArray.get(i)));
                }
                pr.close();

            } catch (Exception e) {

            }
        }catch (Exception e){

        }
    }

    private static void problema2SortareDupaRating(ArrayList<Hotel> sortareRating) {
        System.out.println(" Afisare Hoteluri In Functie De rating ");
        for (int i= 0; i < hotels.size(); i++) {
            for (int j = i + 1; j < hotels.size(); j++) {
                if (Integer.parseInt(hotels.get(i).getRating()) > Integer.parseInt(hotels.get(j).getRating())) {
                    Hotel temp = hotels.get(i);
                    hotels.set(i, hotels.get(j));
                    hotels.set(j, temp);
                }
            }
            sortareRating.add(hotels.get(i));
        }
        for (int i= 0; i < sortareRating.size(); i++){
            System.out.println(sortareRating.get(i).getName());
            System.out.println(sortareRating.get(i).getRating());
        }
    }


    private static void problema1SortareDupaPretCrescator(ArrayList<Hotel> sortarePret) {
        System.out.println(" Afisare Hoteluri In Functie De Preturi Crescatoare ");
        for (int i= 0; i < hotels.size(); i++) {
            for (int j = i + 1; j < hotels.size(); j++) {
                if (hotels.get(i).getPrice() > hotels.get(j).getPrice()) {
                    Hotel temp = hotels.get(i);
                    hotels.set(i, hotels.get(j));
                    hotels.set(j, temp);
                }
            }
            sortarePret.add(hotels.get(i));
        }
        for (int i= 0; i < sortarePret.size(); i++){
            System.out.println(sortarePret.get(i).getName());
            System.out.println(sortarePret.get(i).getPrice());
        }

    }


    private static void creareListaCuDate(ArrayList<String> fisier) {
        File file = new File("C:\\Users\\constantinb\\Documents\\Destination.txt");
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


    private static void hoteluriCuAcelasiPret(ArrayList<Hotel> hotels) {
        System.out.println(" Afisare hoteluri cu acelasi pret");
        for (int y = 0; y < hotels.size(); y++) {
            for (int b = y+1; b < hotels.size(); b++) {
                if (hotels.get(y).getPrice() == hotels.get(b).getPrice()) {
                    System.out.println(hotels.get(y).getName()+ " "+ hotels.get(b).getName());
                }
            }

        }
    }

    private static void existentaTara(ArrayList<Destination> destinations, String g) {
        Boolean x = true;
        for (int k = 0; k < destinations.size(); k++) {
            String[] v = (destinations.get(k).getCountry().split("-"));
            if (v[1].equals(g)) {
                x = false;
            }
        }
        if (x == false) {
            System.out.println("Tara exista in lista de destinatii ");
        } else System.out.println("Tara nu exista in lista de destinatii");
    }

    private static String introducereDeLaTastatura() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
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
                                        h.setRating((v[1]));

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

    private static void afisareListeCreate(ArrayList<Destination> destinations) {
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
}





