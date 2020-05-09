package problemaFiguri;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Scanner;

public class FiguriGeometrice {
    static double raza=0;
    static double lungimea=0;
    static double latimea=0;
    public static double latura=0;
    static ArrayList <FG>listaDate = new ArrayList();
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("daca apesi tasta 1 iesi din aplicatie");
        System.out.println(" Bine ai venit alege o obtiune ");
        citireTastaturaParametrii(keyboard);
        parcurgereArraylist();

    }
    private static void parcurgereArraylist() {

        for (int i = 0; i < listaDate.size(); i++) {
            System.out.println(listaDate.get(i).toString()+" "+listaDate.get(i).aria());
        }
    }

    private static void citireTastaturaParametrii(Scanner keyboard) {
boolean doit=true;
        while (doit==true) {
            String obtiune = keyboard.nextLine();

            switch (obtiune) {
                case ("patrat"):
                    System.out.println("acesta este un patrat te rugam introdu latura");
                    System.out.print("latura:");
                    latura = keyboard.nextInt();
                    System.out.println();
                    listaDate.add(new Patrat(latura));
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");
                    break;
                case ("dreptunghi"):
                    System.out.println("Acesta este un dreptunghi te rugam introdu lungimea si latimea");
                    System.out.print("lungiume:");
                    lungimea = keyboard.nextInt();
                    System.out.println();
                    System.out.print("latimea:");
                    latimea = keyboard.nextInt();
                    System.out.println();
                    listaDate.add(new Dreptunghi(lungimea, latimea));
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");
                    break;
                case ("cerc"):
                    System.out.println("Acesta este un cerc te rugam introdu raza cercului");
                    System.out.print("raza:");
                    raza = keyboard.nextInt();
                    listaDate.add(new Cerc(raza));
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");
                    break;
                case ("1"):doit=false;
                break;
                default: System.out.println("introdu o figura valida");
                break;
            }


        }

    }
}

