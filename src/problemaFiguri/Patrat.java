package problemaFiguri;


public class Patrat implements FG {
    private static double latura=0;
    public Patrat(double latura) {
this.latura=latura;
    }
    @Override
    public double aria() {
        double a = latura * latura;
        return a;
    }
    @Override
    public String toString(){
        return "patrat";
    }
}
