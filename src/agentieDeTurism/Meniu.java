package agentieDeTurism;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static agentieDeTurism.AgentieDeTurismMain.*;
import static agentieDeTurism.Rating.capabilDeAOferiRating;

public class Meniu {
    public static void meniu(ArrayList<String> listaCuTipuriDeUseri, int pozitieTipUser) {
        try {
            while(true) {
                if (listaCuTipuriDeUseri.get(pozitieTipUser).equals("client") && AgentieDeTurismMain.validareAutentificare == true) {
                    Scanner keyboard = new Scanner(System.in);
                    while (true) {
                        meniulClientilor();
                        try {
                            System.out.println("Introduceti optiunea: ");
                            String n = keyboard.next();

                            if (n.equals("1")) {
                                afisareListeCreate(destinations);

                            }
                            if (n.equals("2")) {
                                problema1SortareDupaPretCrescator(sortarePret);
                            }
                            if (n.equals("3")) {
                                AgentieDeTurismMain.inchiereCamere();
                            }
                            if (n.equals("4")) {
                                capabilDeAOferiRating();
                            }
                            if (n.equals("5")) {
                                autentificareUseri(ListaCuUseri, ListaCuParole, ListaCuTipuriDeUseri);
                            }
                            if (n.equals("6")) {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Reintrodu o optiune ");
                        }
                    }
                }
                if (listaCuTipuriDeUseri.get(pozitieTipUser).equals("admin") && validareAutentificare == true) {
                    System.out.println();
                    Scanner keyboard = new Scanner(System.in);
                    while (true) {
                        meniulAdminilor();
                        try {
                            System.out.println("Introduceti optiunea: ");
                            String n = keyboard.next();
                            if (n.equals("1")) {
                                adaugareInFisierHotel();
                            }
                            if (n.equals("2")) {
                                adaugarePretInFisier();
                            }

                            if (n.equals("3")) {
                                adaugareNumarCamere();
                            }
                            if (n.equals("4")) {
                                afisareListeCreate(destinations);
                            }
                            if (n.equals("5")) {
                                autentificareUseri(ListaCuUseri, ListaCuParole, ListaCuTipuriDeUseri);
                            }
                            if (n.equals("6")) {
                            break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Reintrodu o optiune ");
                        }
                    }
                }
                break;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Username or password incorect");
        }
    }
    public static void meniulAdminilor() {
        System.out.println("1.Adauga Hotel");
        System.out.println("2.Modificare pret pentru un hotel existent");
        System.out.println("3.Modificare numar camere pentru un hotel existent");
        System.out.println("4.Afisare destinatii ");
        System.out.println("5.LogOut");
        System.out.println("6.Iesi din aplicatie");
    }

    public static void meniulClientilor() {
        System.out.println("1.Afisare destinatii ");
        System.out.println("2.Ordonare dupa pret");
        System.out.println("3.Inchiriere camere");
        System.out.println("4.Ofera rating");
        System.out.println("5.LogOut");
        System.out.println("6.Iesi din aplicatie");
    }
}
