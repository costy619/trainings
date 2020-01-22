package Tema3Ex2;


import java.sql.SQLOutput;
import java.util.ArrayList;
public class MainEx2 {
    public static void main(String[] args) {
        CardDeck cardDeck= new CardDeck();
        cardDeck.createArraylistWith52cards();
        cardDeck.markAsAvailable();
//        cardDeck.dealHand(55);
//        cardDeck.dealHand(4);
//        cardDeck.shuffle();
//        System.out.println("Pachetul amestecat este");
//        showCards(cardDeck.availablecards);
//        cardDeck.dealHand(8);
//        System.out.println("marimea lui used este "+cardDeck.used.size());
//        System.out.println(cardDeck.getAvailableCardCount());
//        System.out.println(cardDeck.getUsedCardCount());
        System.out.println(cardDeck.dealHand(5)); // <- print 5 cards 3 times
        System.out.println(cardDeck.dealHand(5));
        System.out.println(cardDeck.dealHand(5));
        System.out.println(cardDeck.dealHand(50)); // <- only 39 cards should be printed here
        System.out.println(cardDeck.dealHand(50)); // <- and empty list should be printed
        cardDeck.shuffle();
        System.out.println("cartile scoase sunt");
        System.out.println(cardDeck.dealHand(5)); // <- another 5 cards

    }

    private static void showCards( ArrayList<Card> arrayList) {
        if(arrayList.size()>0) {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i).getNumber());
                System.out.println(CardDeck.typeOfCard(i, arrayList));
            }
        }else System.out.println("lista goala");
    }


}
