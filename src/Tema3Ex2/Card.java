package Tema3Ex2;

public class Card {
    //number (2 - 14) and suit (​diamonds (​♦)​ , clubs (♣), hearts (​♥​) and spades (♠) ).
    private int number;
    private boolean diamonds;
    private boolean clubs;
    private boolean hearts;
    private boolean spades;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number >= 2 && number <= 14) {
            this.number = number;
        }
    }

    public boolean isDiamonds() {
        if (this.diamonds) {
            return true;
        } else return false;
    }

    public void setDiamonds(Boolean diamonds) {
        if (this.number >= 2 && this.number <= 14) {
            this.diamonds = diamonds;
        } else System.out.println("Nu indeplineste conditia necesara de a fi carte de joc");
    }

    public boolean isClubs() {
        if (this.clubs) {
            return true;
        } else return false;
    }

    public void setClubs(boolean clubs) {
        if (this.number >= 2 && this.number <= 14) {
            this.clubs = clubs;
        } else System.out.println("Nu indeplineste conditia necesara de a fi carte de joc");
    }

    public boolean isHearts() {
        if (this.hearts) {
            return true;
        } else return false;
    }

    public void setHearts(boolean hearts) {
        if (this.number >= 2 && this.number <= 14) {
            this.hearts = hearts;
        } else System.out.println("Nu indeplineste conditia necesara de a fi carte de joc");
    }

    public boolean isSpades() {
        if (this.spades) {
            return true;
        } else return false;
    }

    public void setSpades(boolean spades) {
        if (this.number >= 2 && this.number <= 14) {
            this.spades = spades;
        } else System.out.println("Nu indeplineste conditia necesara de a fi carte de joc");
    }
}
