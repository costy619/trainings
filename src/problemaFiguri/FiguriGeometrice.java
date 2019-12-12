package problemaFiguri;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Scanner;

public class FiguriGeometrice {
    static double raza=0;
    static double lungimea=0;
    static double latimea=0;
    static double latura=0;
    static ArrayList listaDate = new ArrayList();
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("daca apesi tasta 1 iesi din aplicatie");
        System.out.println(" Bine ai venit alege o obtiune ");
        citireTastaturaParametrii(keyboard);
        parcurgereArraylist();
    }
    private static void parcurgereArraylist() {
        for (int i = 0; i < listaDate.size(); i++) {
            String[] lineArr;
            String linie = listaDate.get(i).toString();
            lineArr = linie.split("-");
            String forme=null;
            switch (forme){
                case ("patrat"):{
                    Patrat p=new Patrat(latura);
                    p.aria();
                    System.out.println(p.aria());
                }
            }
            if (lineArr[0].equals("patrat")) {
                Patrat p=new Patrat(latura);
                p.aria();
                System.out.println(p.aria());
            }
            if (lineArr[0].equals("dreptunghi")) {
                Dreptunghi d=new Dreptunghi(lungimea,latimea);
                d.aria();
                System.out.println(d.aria());
            }
            if (lineArr[0].equals("cerc")) {
                Cerc c=new Cerc(raza);
                c.aria();
                System.out.println(c.aria());
            }
        }
    }

    private static void citireTastaturaParametrii(Scanner keyboard) {
        while (true) {
            String obtiune = keyboard.nextLine();
            if (obtiune.equals("patrat")) {
                System.out.println("acesta este un patrat te rugam introdu latura");
                System.out.print("latura:");
                latura = keyboard.nextInt();
                System.out.println();
                listaDate.add(obtiune+"-"+new Patrat(latura));
                System.out.println("daca apesi tasta 1 iesi din aplicatie");
                System.out.println("Introdu o figura geometrica");
            }
            if (obtiune.equals("dreptunghi")) {
                System.out.println("Acesta este un dreptunghi te rugam introdu lungimea si latimea");
                System.out.print("lungiume:");
                 lungimea = keyboard.nextInt();
                System.out.println();
                System.out.print("latimea:");
                latimea = keyboard.nextInt();
                System.out.println();
                listaDate.add(obtiune+"-"+new Dreptunghi(lungimea,latimea));
                System.out.println("daca apesi tasta 1 iesi din aplicatie");
                System.out.println("Introdu o figura geometrica");
            }
            if (obtiune.equals("cerc")) {
                System.out.println("Acesta este un cerc te rugam introdu raza cercului");
                System.out.print("raza:");
                raza = keyboard.nextInt();
                listaDate.add(obtiune+"-"+new Cerc(raza));
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");
            }
            if (obtiune.equals("1")) {
                break;
            }

        }
    }
}

