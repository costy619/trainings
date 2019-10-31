package tourists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.*;

public class Application {
    public static void main(String[] args) throws NullPointerException {

        ArrayList<String> fisier = new ArrayList<>();
        creareListaCuDate(fisier);
        ArrayList<Destination> destinations = new ArrayList<>();
        ArrayList<Hotel> hotels = new ArrayList<>();
        creareListe(fisier, destinations, hotels);
//        afisareListeCreate(destinations);
//        System.out.println("Introduceti tara pe care sa o cauti ");
//        String g = introducereDeLaTastatura();
//        existentaTara(destinations, g);
//        hoteluriCuAcelasiPret(hotels);
        AfisareHoteluriInFunctieDePret(hotels);
//        System.out.println("introdu suma pe care vrei sa o folosesti pentru a gasi combinatia de hoteluri");
//        problema1(hotels);
//        System.out.println(" introdu pretul pe care vrei sa in vezi de cate ori se repeta");
//        problema2(hotels);
//        System.out.println(" situatia preturilor care se repeta");
//        problema3primaVarianta(hotels);
//        ArrayList<String>hoteluri=new ArrayList<>();
//        problema3Adouavarianta(hotels, hoteluri);
        Problema6(hotels);
    }

    private static void Problema6(ArrayList<Hotel> hotels) {
        //trebuia sa pui sau sa scoti din comentariu metoda  AfisareHoteluriInFunctieDePret(hotels);
        //cand o scoti din comentariu trebuie sa arate ca e sortata
        int c = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < hotels.size() - 1; i++) {
            if (hotels.get(0).getPrice() < hotels.get(i + 1).getPrice()) {
                if (hotels.get(i).getPrice() > hotels.get(i + 1).getPrice()) {
                    break;
                }
                c++;
                a++;

            } else {
                if (hotels.get(i).getPrice() < hotels.get(i + 1).getPrice()) {
                    break;
                }
                c++;
                b++;
            }
        }
        if (c == hotels.size() - 1 && a == hotels.size() - 1) {
            System.out.println(" lista sortata Crescator");

        } else {
            if (c == hotels.size() - 1 && b== hotels.size() - 1) {
                System.out.println(" lista sortata Descrescator");
            } else System.out.println("lista nesortata");
        }
    }


    private static void problema3Adouavarianta(ArrayList<Hotel> hotels, ArrayList<String> hoteluri) {

        System.out.println(" a doua varianta a problemei 3");
        for(int i=0; i<hotels.size(); i++) {
            int c=0;
            for (int k = 1; k < hotels.size(); k++) {
                if (hotels.get(i).getPrice() == hotels.get(k).getPrice()) {
                    c++;

                } else {

                }
            }
            hoteluri.add("Pretul  "+ hotels.get(i).getPrice()+" al hotelului " +hotels.get(i).getName()+ " se repeta de " +String.valueOf(c)+" ori");
        }

        for (int i= 0; i < hoteluri.size(); i++) {
            System.out.println(hoteluri.get(i));
        }
    }

    private static void problema3primaVarianta(ArrayList<Hotel> hotels) {
        System.out.println(" prima varianta");
        for (int i= 0; i < hotels.size(); i++) {
            int c=0;
            for (int k =1; k < hotels.size(); k++) {
                if (hotels.get(i).getPrice() == hotels.get(k).getPrice()) {
                    c++;
                }
            }
            System.out.println( "Pretul  "+ hotels.get(i).getPrice()+" al hotelului " +hotels.get(i).getName()+ " se repeta de " +c+" ori");
        }
    }

    private static void problema2(ArrayList<Hotel> hotels) {
       try {
           int r = parseInt(introducereDeLaTastatura());
           int c = 0;
           int m;
           for (int i = 0; i < hotels.size(); i++) {
               if (hotels.get(i).getPrice() == r) {
                   c++;
               }
           }
           if (c > 0) {
               System.out.println(" Pretul " + r + " apare de " + c + " ori");
           } else System.out.println(" Elementul nu apare niciodata ");
       }catch (NumberFormatException e) {
            System.out.println("caracter invalid");
        }
    }

    private static void problema1(ArrayList<Hotel> hotels) {
      try {
          try {
              double n = Double.parseDouble(introducereDeLaTastatura());

              boolean v = true;
              for (int i = 0; i < hotels.size(); i++) {
                  for (int k = 1; k < hotels.size(); k++) {
                      if (hotels.get(i).getPrice() + hotels.get(k).getPrice() == n) {
                          if (hotels.get(i).getName().equals(hotels.get(k).getName())) {

                          } else {
                              System.out.println(hotels.get(i).getName() + " " + hotels.get(k).getName() + " au suma " + n);
                          }
                          v = false;
                      }
                  }
              }
              if (v == true) {
                  System.out.println(" nu exista hoteluri cu suma preturilor " + n);
              }
          }catch (NumberFormatException e){
              System.out.println("caracter invalid");
          }
      }catch (NoSuchElementException e) {
          System.out.println("suma nu poate fi compusa");
      }
    }

    private static void AfisareHoteluriInFunctieDePret(ArrayList<Hotel> hotels) {
        System.out.println(" Afisare Hoteluri In Functie De Preturi Crescatoare ");
        for (int i= 0; i < hotels.size(); i++) {
            for (int j = i + 1; j < hotels.size(); j++) {
                if (hotels.get(i).getPrice() > hotels.get(j).getPrice()) {
                    Hotel temp = hotels.get(i);
                    hotels.set(i, hotels.get(j));
                    hotels.set(j, temp);
                }
            }
        }
        for (int i= 0; i < hotels.size(); i++){
            System.out.println(hotels.get(i).getName());
            System.out.println(hotels.get(i).getPrice());
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
                                        h.setRating(Integer.parseInt(v[1]));

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





