package file;
import javax.management.StringValueExp;
import javax.swing.text.Position;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tempArray = new ArrayList<>();
        int y = 1;
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
                        System.out.println(y);
                    } else tempArray.add(line);
                }
                fr.close();


            } catch (FileNotFoundException e) {
            }
        } catch (Exception e) {

        }
        if (y > 0) {
            for (int i = 0; i < tempArray.size(); i++) {
                if (tempArray.get(y + 1).equals("ionut")) {
                    System.out.println("yayayay");
                    poateDaRating = true;
                    break;
                }
            }
        } else
            System.out.println("Nu puteti oferi rating pentru hotelul" + hotel);
    }


}