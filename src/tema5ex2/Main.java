package tema5ex2;

public class Main {
    public static void main(String[] args) {
        PowerPlant p = new PowerPlant(120);
        Reactor r = new Reactor(150);
//        if(r.isCriticalorNot()) System.out.println("este critical");
        PlantController p1 = new PlantController(r, p);
//        p1.shutdown();
        p1.runSystemMethod();
        System.out.println(r.throughput);
        System.out.println(p1.p.desire);
    }
}
