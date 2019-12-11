package problemaFiguri;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Scanner;

public class FiguriGeometrice {
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
            if (lineArr[0].equals("patrat")) {
                int aria = Integer.parseInt(lineArr[1]) * Integer.parseInt(lineArr[1]);
                System.out.println(lineArr[0]+" cu latura "+lineArr[1] +" aria este= " + aria);
            }
            if (lineArr[0].equals("dreptunghi")) {
                int aria = Integer.parseInt(lineArr[1]) * Integer.parseInt(lineArr[2]);
                System.out.println(lineArr[0]+" cu latura "+lineArr[1] +" si "+lineArr[2] +" aria este= " + aria);
            }
            if (lineArr[0].equals("cerc")){
                double aria = 3.14 * Integer.parseInt(lineArr[1])*Integer.parseInt(lineArr[1]);
                System.out.println(lineArr[0]+" cu raza "+lineArr[1] +" aria este= " + aria);
            }
        }
    }

    private static void citireTastaturaParametrii(Scanner keyboard) {
        while (true) {
            String obtiune = keyboard.nextLine();
            if (obtiune.equals("patrat")) {
                System.out.println("acesta este un patrat te rugam introdu latura");
                System.out.print("latura:");
                int latura = keyboard.nextInt();
                System.out.println();
                System.out.print("Introdu formula arie");

                String formula = keyboard.next();
                String lineArr[];
                lineArr = formula.split("[*]");
                if (lineArr[0].equals("latura") && lineArr[1].equals("latura")) {
                    listaDate.add(obtiune + "-" + latura);
                    System.out.println("Introdu o figura geometrica");
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                } else{
                    System.out.println("trebuie introdusa formula corecta");
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");
                }


            }
            if (obtiune.equals("dreptunghi")) {
                System.out.println("Acesta este un dreptunghi te rugam introdu lungimea si latimea");
                System.out.print("lungiume:");
                int lungimea = keyboard.nextInt();
                System.out.println();
                System.out.print("latimea:");
                int latimea = keyboard.nextInt();
                System.out.println();
                System.out.print("Introdu formula arie");
                String formula = keyboard.next();
                String lineArr[];
                lineArr = formula.split("[*]");

                if (lineArr[0].equals("lungimea") && lineArr[1].equals("latimea") || lineArr[0].equals("latimea") && lineArr[1].equals("lungimea")) {
                    listaDate.add(obtiune + "-" + lungimea + "-" + latimea);
                    System.out.println("Introdu o figura geometrica");
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                } else {
                    System.out.println("trebuie introdusa formula corecta");
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");
                }

            }
            if (obtiune.equals("cerc")) {
                System.out.println("Acesta este un triunghi te rugam introdu raza cercului");
                System.out.print("raza:");
                int raza = keyboard.nextInt();
                System.out.println();
                System.out.print("Introdu formula arie");
                String formula = keyboard.next();

                String lineArr[];
                lineArr = formula.split("[*]");
                if (lineArr[0].equals("3.14") && lineArr[1].equals("raza") && lineArr[1].equals("raza")) {
                    listaDate.add(obtiune + "-" + raza);
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");

                } else {
                    System.out.println("trebuie introdusa formula corecta");
                    System.out.println("daca apesi tasta 1 iesi din aplicatie");
                    System.out.println("Introdu o figura geometrica");
                }
            }
            if (obtiune.equals("1")) {
                break;
            }

        }
    }
}

