package inheritance;

import java.util.ArrayList;

public class MainAccount {
    public static void main(String[] args) {

        SavingsAccount savings1 = new SavingsAccount(1);
        SavingsAccount savings2 = new SavingsAccount(2);
        SavingsAccount savings3 = new SavingsAccount(3);
        CurrentAccount current1 = new CurrentAccount(4);
        CurrentAccount current2 = new CurrentAccount(5);
        CurrentAccount current3 = new CurrentAccount(6);

        savings1.deposit(100);
        current1.withdraw(200);

        Bank b = new Bank("BCR");
        b.setAccs(new ArrayList<>()) ;
        b.getAccs().add(savings1);
        b.getAccs().add(savings2);
        b.getAccs().add(savings3);
        b.getAccs().add(current1);
        b.getAccs().add(current2);
        b.getAccs().add(current3);

        b.getAccs().size();
       savings2.deposit(300);
        b.show();
        scrisoare(b);
        System.out.println("contul de economii este " + savings2);
    }
    public static void scrisoare(Bank b){
        for (int i = 0; i < b.getAccs().size(); i++) {
            if (b.getAccs().get(i).getBalance() < 0){
                System.out.println(b.getAccs().get(i) + " are contul pe minus ");
            }
        }
    }
}


