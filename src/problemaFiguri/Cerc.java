package problemaFiguri;

public class Cerc implements FG {
    private double raza = 0;

    public Cerc(double raza) {
        this.raza = raza;
    }

    @Override

    public double aria() {
        double a = 3.14 * raza * raza;
        return a;
    }
}
