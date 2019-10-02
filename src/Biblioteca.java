public class Biblioteca {
    Carte[] carte;

    public void setCarte(Carte[] carti) {
        this.carte = carti;
    }

    public Carte[] getCarte() {

        return carte;
    }

    public void afisare2() {
        for (int i = 0; i < carte.length; i++) {
            if (getCarte()[i] != null) {
                System.out.println(getCarte()[i].getTitlu() + " scrisa de " + getCarte()[i].getAutor());
            }
        }
    }

    public Carte imprumut(Carte cartedeluat) {
        Carte val = null;
        for (int i = 0; i < carte.length; i++) {
            if ((carte[i] != null) && (getCarte()[i].getTitlu().equals(cartedeluat.getTitlu()) && (getCarte()[i].getAutor().equals(cartedeluat.getAutor())))) {
                val = getCarte()[i];
                getCarte()[i] = null;
                break;
            }
        }
        if(val==null) {
            System.out.println();
            System.out.println("Cartea " + cartedeluat.getTitlu()+ " cu autorul "+cartedeluat.getAutor()+" nu este in biblioteca");
        }
        return val;
    }



    public Carte retur1(Carte carteDeAdus) {
        for (int i = 0; i < carte.length; i++) {
            if (carte[i] == null) {
                carte[i] = carteDeAdus;
                break;
            }
        }
        return carteDeAdus;
    }

    public int nrRamase(){
        int ramase = carte.length;
        for(int i = 0;i < carte.length; i++){
            if(carte[i] == null){
                ramase--;
                break;
            }
        }
        return ramase;
    }

    public int nrImprumutate(){
        int impr = 0;
        for(int i = 0;i < carte.length; i++){
            if(carte[i] == null){
                impr++;
                break;
            }
        }
        return impr;
    }

    public void titluAlfabetic() {
        for (int i = 0; i < carte.length; i++) {
            for (int j = i + 1; j < carte.length; j++) {

                if (getCarte()[i].getTitlu().compareTo(getCarte()[j].getTitlu()) > 0) {
                    Carte aux = getCarte()[i];
                    getCarte()[i] = getCarte()[j];
                    getCarte()[j] = aux;
                }
            }
            System.out.println(getCarte()[i].getTitlu() + " ");

        }
    }
    public void autoriAlfabetic() {
        for (int i = 0; i < carte.length; i++) {
            for (int j = i + 1; j < carte.length; j++) {

                if (getCarte()[i].getAutor().compareTo(getCarte()[j].getAutor()) > 0) {
                    Carte aux = getCarte()[i];
                    getCarte()[i] = getCarte()[j];
                    getCarte()[j] = aux;
                }
            }
            System.out.println(getCarte()[i].getAutor() + " ");

        }
    }
}

