package tema5ex2;

public class PlantController {
    Reactor r;
    PowerPlant p;

    PlantController(Reactor r, PowerPlant p) {
        this.p = p;
        this.r = r;
    }

    boolean adjustment() {
        if (r.throughput - p.desire > 10) return true;
        else return false;
    }

    void adjust() {
        while (true) {
            if (r.throughput - p.desire >= 10) {
                r.decrease();
                if (r.throughput - p.desire <= 10 && r.throughput - p.desire >= 0) {
                    break;
                }
            }
            if (r.throughput - p.desire < 0) {
                r.increase();
                if (r.throughput - p.desire >= -10 && r.throughput - p.desire <= 0) {
                    break;
                }
            }
        }

    }

    void shutdown() {
        while (true) {
            r.decrease();

            if (r.throughput == 0) {
                System.out.println("reactor inchis");
                break;
            }
        }
    }

    void runSystemMethod() {

        if ((r.throughput - p.desire <= -10 || r.throughput - p.desire > 10)) {
            System.out.println("este nevoie de ajustare");
            if (r.isCriticalorNot()) {
                p.alarm();
                shutdown();
                return;
            }
            adjust();
        }
    }
}
