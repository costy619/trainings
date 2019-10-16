package inheritance;

public class SavingsAccount extends Account {
    public double interest = 0.1;

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public SavingsAccount(int a) {
        super(a);
    }

    public String toString() {

        return super.toString() + " interest "+interest;
    }

    @Override
    public void deposit(double sum) {
        if (sum > 0) {
            bal += sum + (sum * this.interest);
        } else {
            System.err.println("Account.deposit(...): "
                    + "cannot deposit negative amount.");
        }
    }
}
