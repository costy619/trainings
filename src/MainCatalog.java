import java.util.Scanner;

public class MainCatalog {

    public static void main(String[] args) {
        Catalog cat1 = setFirstCatalog();
        Catalog cat2 = setSecondCatalog();
        printCatalogs(cat1, cat2);
        readStudentsForTransfer(cat1, cat2);
        cat1.schimbare(cat2);
        cat1.media();
    }
    private static Catalog setSecondCatalog() {
        Catalog cat2 = new Catalog();
        cat2.setClasa("11A");
        int note4[] = {6, 6, 9, 5, 6};
        int note5[] = {3, 10, 3, 8, 9};
        int note6[] = {7, 8, 9, 6, 2};

        Student s4 = new Student("Marcu", note4);
        Student s5 = new Student("Andrei", note5);
        Student s6 = new Student("Maria", note6);

        Student stud2[] = {s4, s5, s6};
        cat2.setStud(stud2);
        return cat2;
    }

    private static Catalog setFirstCatalog() {
        Catalog cat1 = new Catalog();
        cat1.setClasa("11D");
        int note1[] = {6, 8, 9, 5, 6};
        int note2[] = {6, 8, 9, 5, 4};
        int note3[] = {7, 9, 9, 6, 9};

        Student s1 = new Student("Ionel", note1);
        Student s2 = new Student("Georgel", note2);
        Student s3 = new Student("Alex", note3);

        Student stud[] = {s1, s2, s3};
        cat1.setStud(stud);
        return cat1;
    }

    private static void printCatalogs(Catalog cat1, Catalog cat2) {
        System.out.println("Catalogul clasei  " + cat2.getClasa() + " contine " + cat2.getStud().length + " elevi");
        System.out.println("Catalogul clasei  " + cat1.getClasa() + " contine " + cat1.getStud().length + " elevi");
        System.out.println("Elevii clasei 11D si notele lor sunt: ");
        //cat1.afisareNote();
        System.out.println("Elevii clasei 11A si notele lor sunt: ");
       // cat2.afisareNote();
        System.out.println("Elevii alfabetic catalog 1: ");
        cat1.afisareAlfabetic();
        System.out.println("Elevii alfabetic catalog 2: ");
        cat2.afisareAlfabetic();

        System.out.println("Elevii 11A si mediile lor: ");
        cat1.media();
        System.out.println("Elevii 11D si mediile lor: ");
        cat2.media();

        System.out.println("Ordonare crescatoare in functie de medie 11A: ");
        cat1.afisareCrescatoare();
        System.out.println("Ordonare crescatoare in functie de medie 11D: ");
        cat2.afisareCrescatoare();

        System.out.println("Transfer de elevi: ");
        System.out.println("Introdu un elev=");
    }

    private static void readStudentsForTransfer(Catalog cat1, Catalog cat2) {
        Scanner keyboard = new Scanner(System.in);
        cat1.elevCePoateFiTransferat(keyboard.next());
        System.out.println("introdu alt elev");
        cat2.setElevDeTransferat(keyboard.next());
    }
}

