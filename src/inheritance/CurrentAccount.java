package inheritance;

public class CurrentAccount extends Account {
    public double limit = -300;

    public CurrentAccount(int a) {
        super(a);
    }

    @Override
    public void withdraw(double sumImprumutata) {

        if (sumImprumutata < 0) {
            System.err.println("Account.withdraw(...): "
                    + "cannot withdraw negative amount.");
        }
        else if (this.bal-sumImprumutata >= limit) {
            System.out.println("you can withdraw " + sumImprumutata);
            bal -= sumImprumutata;
        }
        else {
            System.out.println("Cannot withdraw " + sumImprumutata + " because the limit is " + limit);
        }
    }


    @Override
    public String toString() {
        return "Acc " + accnum + ": " + "balance = " + bal+":"+ " limit= "+limit;
    }


}
