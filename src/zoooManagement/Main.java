package zoooManagement;

import org.omg.CORBA.portable.ValueInputStream;

import java.util.Scanner;

import static zoooManagement.Zoo.Anime;

public class Main {
    static int nrUrsi=0;
    static int nrCanguri=0;
     static int nrRasi=0;
    public static void main(String[] args) {

        adaugareLaZooAnimale();
        afisareaInformatiilorRelevante();
    }

    private static void afisareaInformatiilorRelevante() {
        for (int i = 0; i < Anime.size(); i++) {
            System.out.println("Tipul: " +Anime.get(i).getSpecie()+ " culoare: "+Anime.get(i).getCuloare()+" "+Anime.get(i).mers());
        }
        if(nrUrsi>0) System.out.println("La gradina zoologica sunt cazati: "+nrUrsi+" Ursi ");
        if(nrCanguri>0) System.out.println("La gradina zoologica sunt cazati: "+nrCanguri+" Canguri");
        if(nrRasi>0) System.out.println("La gradina zoologica sunt cazati: "+nrRasi+" Rasi ");
    }

    private static void adaugareLaZooAnimale() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("introdu un animal la zoo dintre urmatoarele: Cangur, Urs, Ras sau apasa tasta 1 pentru a iesi");
        boolean doit = true;
        while (doit == true) {
            String obtiune = keyboard.nextLine();
            switch (obtiune) {
                case ("Urs"):
                    Urs u = new Urs();
                    Anime.add(u);
                    System.out.println("Introdu un animal la gradina zoologica sau apasa tasta 1 pentru a iesi ");
                    nrUrsi++;
                    break;
                case ("Cangur"):
                    Cangur c = new Cangur();
                    Anime.add(c);
                    System.out.println("Introdu un animal la gradina zoologica sau apasa tasta 1 pentru a iesi");
                    nrCanguri++;
                    break;
                case ("Ras"):
                    Ras r = new Ras();
                    Anime.add(r);
                    System.out.println("Introdu un animal la gradina zoologica sau apasa tasta 1 pentru a iesi");
                    nrRasi++;
                    break;
                case ("1"):
                    doit = false;
                    System.out.println("La Revedere");
                    break;
                default:
                    System.out.println("introdu un animal dintre urmatoarele: Cangur, Urs, Ras sau apasa tasta 1 pentru a iesi");
                    break;
            }
        }
    }
}
