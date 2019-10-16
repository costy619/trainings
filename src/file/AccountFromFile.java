package file;

import inheritance.Bank;
import inheritance.Account;
import inheritance.CurrentAccount;
import inheritance.SavingsAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountFromFile {
    public static void main(String[] args) {

        Bank brd = getBankAndSetList();
        Scanner sc = getScannerFromPath();
        readingFromFile(brd, sc);
        afisare(brd);
    }

    private static void afisare(Bank brd) {
        for (int i = 0; i < brd.getAccs().size(); i++) {
            System.out.println(brd.getAccs().get(i));
        }
    }

    private static void readingFromFile(Bank brd, Scanner sc) {

           while (sc.hasNextLine()) {
               try {
                   String g = sc.nextLine();
                   String s = sc.nextLine();
                   int accs = Integer.parseInt(s);
                   Account a;
                   a = getAccount(sc, g, accs);
                   brd.getAccs().add(a);
               }catch (NumberFormatException s) {
                   System.out.println("ceva ai gresit");
                   sc.nextLine();
               }
           }
       }


    private static Account getAccount(Scanner sc, String g, int accs) {
        Account a;
        if (g.equals("A")) {
            a = new Account(accs);
            a.bal = Double.parseDouble(sc.nextLine());
        } else if (g.equals("B")) {
            a = new SavingsAccount(accs);
            a.bal = Double.parseDouble(sc.nextLine());
            ((SavingsAccount) a).interest = Double.parseDouble(sc.nextLine());
        } else {
            a = new CurrentAccount(accs);
            a.bal = Double.parseDouble(sc.nextLine());
            ((CurrentAccount) a).limit = Double.parseDouble(sc.nextLine());
        }
        return a;
    }


    private static Scanner getScannerFromPath() {
        while (true) {
            try {
                Scanner keyboard = new Scanner(System.in);
                File file = new File(keyboard.next());
                return new Scanner(file);

            } catch (FileNotFoundException file) {
                System.out.println("reintrodu path");
            }
        }
    }
    private static Bank getBankAndSetList() {
        Bank brd = new Bank("Brd");
        brd.setAccs(new ArrayList<>());
        return brd;
    }
}

