package problemaFiguri;

public class Dreptunghi implements FG {
    private double lungimea = 0;
    private double latimea = 0;

    public Dreptunghi(double lungimea, double latimea) {
        this.latimea = latimea;
        this.lungimea = lungimea;
    }

    @Override
    public double aria() {
        double a = lungimea * latimea;
        return a;
    }
}
