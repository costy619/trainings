package tourists;

import javax.management.StringValueExp;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static tourists.AgentieDeTurismMain.*;

public class Rating {
    static boolean toateConditiileInordine=false;
    public static void capabilDeAOferiRating() {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = -1;

        String hotel = null;
        Scanner keyboard = new Scanner(System.in);
        boolean poateDaRating = false;
        String ratingFinal=null;
        try {
            try {
                FileReader fr = new FileReader(booking);
                Scanner reader = new Scanner(fr);
                System.out.println("Introduceti numele hotelului pentru care vreti sa introduceti ratingul ");
                hotel =keyboard.nextLine();
                String line;
                while (reader.hasNextLine() && (line = reader.nextLine()) != null) {
                    tempArray.add(line);
                }
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("fisierul nu a fost gasit");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu poate fi inchis");
        }
//            for (int i = 0; i < tempArray.size()-1; i++) {
//                for (int j = i + 1; j < tempArray.size(); j++) {
//                    if (tempArray.get(i).equals(hotel) && tempArray.get(i+1).equals(ListaCuUseri.get(pozitieTipUser))) {
//                        poateDaRating = true;
//                    }
//                }
//            }
        Set<String> hset = new HashSet<String>();
        HashMap<String, Set> hmap = new HashMap<String, Set>();
        ArrayList temp= new ArrayList();
        for(int i=0;i<tempArray.size();i++){
            if(tempArray.get(i).equals(hotel)){
                if(hmap.get(i)==null) {
                    hmap.put(hotel, hset);
                    hmap.get(hotel).add(tempArray.get(i + 1));
                }
                else hmap.get(hotel).add(tempArray.get(i+1));
            }
        }

if(hset.contains(ListaCuUseri.get(pozitieTipUser))){
            poateDaRating = true;
        }

        if (poateDaRating == true) {

            ArrayList<String> tempArray1 = new ArrayList<>();
            int pozitiaHotelului =0;

            pozitiaHotelului = getPozitiaHotelului(hotel, tempArray1, pozitiaHotelului);
            ratingFinal = introducereNoulRating(keyboard, ratingFinal, tempArray1, pozitiaHotelului);
           if(toateConditiileInordine==true){
                modificareDestinatiiCuRating(hotel, ratingFinal);
                rescriereListaInFisier(tempArray1);
            }
        } else
            System.out.println("Nu puteti oferi rating pentru hotelul" + hotel);
    }

    public static int getPozitiaHotelului(String hotel, ArrayList<String> tempArray1, int pozitiaHotelului) {
        try {
            try {

                FileReader fr = new FileReader(allDestinations);
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr1;
                while (reader.hasNextLine() && (line = reader.nextLine()) != null) {
                    lineArr1 = line.split("-");
                    if (lineArr1[1].equals(hotel)) {
                        tempArray1.add(lineArr1[0] + "-" + lineArr1[1]);
                        pozitiaHotelului = tempArray1.indexOf(line);
                    } else tempArray1.add(line);
                }
                fr.close();

            } catch (FileNotFoundException e) {
                System.out.println("fisierul nu a fost gasit");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu poate fi inchis");
        }
        return pozitiaHotelului;
    }

    private static String introducereNoulRating(Scanner keyboard, String ratingFinal, ArrayList<String> tempArray1, int pozitiaHotelului) {
        double rating;
        try {
            try {
                if (pozitiaHotelului > 0) {
                    System.out.println("Introduceti noul rating al hotelului");
                    rating = Double.parseDouble(keyboard.nextLine());
                    if (rating > 0 && rating < 11) {
                        String[] lineArr;
                         toateConditiileInordine=true;
                        for (int i = 0; i < tempArray1.size(); i++) {
                            lineArr = tempArray1.get(pozitiaHotelului + 1).split("-");
                            Double c = Double.parseDouble(lineArr[2]);
                            Double b = Double.parseDouble(lineArr[1]);
                            tempArray1.remove(tempArray1.get(pozitiaHotelului + 1));
                            if (c == 0) {
                                tempArray1.add(pozitiaHotelului + 1, "R-" + rating + "-" + (1 + c));
                                ratingFinal="R-" + rating + "-" + (1 + c);
                            } else {
                                tempArray1.add(pozitiaHotelului + 1, "R-" + (rating + b) / 2 + "-" + (1 + c));
                                ratingFinal="R-" + (rating + b) / 2 + "-" + (1 + c);
                            }
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
        return ratingFinal;
    }

    private static void modificareDestinatiiCuRating(String hotel, String ratingFinal) {
        for (int k = 0; k < destinations.size(); k++) {
            Destination d = destinations.get(k);
            for (int l = 0; l < d.getCities().size(); l++) {
                City c = d.getCities().get(l);
                for (int b = 0; b < c.getHotels().size(); b++) {
                    if (c.getHotels().get(b).getName().equals("H-"+hotel)) {
                        c.getHotels().get(b).setRating(ratingFinal);
                    }
                }
            }
        }
    }
}
