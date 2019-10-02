public class MainBiblioteca {
    public static void main(String[] mm) {
        Biblioteca biblioteca = creareBibliotecaCarti();
        afisari(biblioteca);
        Imprumut(biblioteca);
        retur(biblioteca);
    }
    private static Biblioteca creareBibliotecaCarti() {
        Biblioteca biblioteca = new Biblioteca();
        Carte c1 = new Carte("Romana", "Eminescu");
        Carte c2 = new Carte("Mate", "Pitagora");
        Carte c3 = new Carte("Informatica", "Prof x");
        Carte c4 = new Carte("Engleza", "Ciubotaru");
        Carte[] carti = {c1, c2, c3, c4};
        biblioteca.setCarte(carti);
        return biblioteca;
    }
    private static void retur(Biblioteca biblioteca) {
        Carte adus = new Carte("Romana", "Eminescu");
        biblioteca.retur1(adus);

        System.out.println("Cartea adusa este: " + adus.getTitlu());
        System.out.println();

        System.out.println("Cartile ramase dupa retur sunt:");
        biblioteca.afisare2();
        System.out.println();

        System.out.println("Numarul de carti ramase este: ");
        int r = biblioteca.nrRamase();
        System.out.println(r);

        System.out.println("Numarul de carti imprumutate este: ");
        int n = biblioteca.nrImprumutate();
        System.out.println(n);
    }

    private static void Imprumut(Biblioteca biblioteca) {
        Carte imprumut1 = new Carte("Romana", "Eminescu");
        Carte imprumut2 = new Carte("Mate", "Pita");
        biblioteca.imprumut(imprumut1);
        biblioteca.imprumut(imprumut2);
        System.out.println();
        System.out.println("Cartile ramase dupa imprumut sunt:");
        biblioteca.afisare2();
        System.out.println();
    }

    private static void afisari(Biblioteca biblioteca) {
        System.out.println("Afisarea cartilor din biblioteca: ");
        biblioteca.afisare2();
        System.out.println();

        System.out.println("Tilurile sortate in ordine alfabetica: ");
        biblioteca.titluAlfabetic();
        System.out.println();

        System.out.println("Autorii sortati in ordine alfabetica: ");
        biblioteca.autoriAlfabetic();
    }

}
