package Tema3Ex2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    static ArrayList<Card> allcards = new ArrayList<>();
    static ArrayList<Card> availablecards = new ArrayList<>();
    static ArrayList<Card> used = new ArrayList<>();
    int howMany = 0;

    void addallcards(){
        availablecards.addAll(allcards);
    }
    public int dealHand(int cards) {
        int d = availablecards.size();
        if (d > 0) {
            for (int i = 0; i < cards; i++) {
                double x = (Math.random() * ((d - 1) + 1)) + 0;
                int j = (int) x;
                if (d > 0) {
                    System.out.println("cartea soasa este " + availablecards.get(j).getNumber() + " de " + typeOfCard(j, availablecards));
                    used.add(availablecards.get(j));
                    availablecards.remove(j);
                    d--;
                    howMany++;
                } else System.out.println("lista este goala pachetul e gol");
            }
        } else {
            System.out.println("Lista goala");
            return 0;
        }
        return cards;
    }

    void shuffle() {
        availablecards.addAll(allcards);
        used.removeAll(used);
        Collections.shuffle(availablecards);

    }

    static void createArraylistWith52cards() {
        for (int i = 2; i <= 14; i++) {
            Card c = new Card();
            c.setNumber(i);
            c.setDiamonds(true);
            allcards.add(c);
            Card c1 = new Card();
            c1.setNumber(i);
            c1.setClubs(true);
            allcards.add(c1);
            Card c2 = new Card();
            c2.setNumber(i);
            c2.setHearts(true);
            allcards.add(c2);
            Card c3 = new Card();
            c3.setNumber(i);
            c3.setSpades(true);
            allcards.add(c3);
        }

    }


    static String typeOfCard(int i, ArrayList<Card> arrayList) {
        if (arrayList.get(i).isDiamonds())
            return " de romb";
        if (arrayList.get(i).isHearts())
            return " de inima";
        if (arrayList.get(i).isClubs())
            return " de trefla";
        if (arrayList.get(i).isSpades())
            return " de frunza";
        else return null;
    }

    public int getAvailableCardCount() {

        return availablecards.size();
    }

    public int getUsedCardCount() {
        return used.size();
    }
}
