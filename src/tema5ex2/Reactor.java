package tema5ex2;

public class Reactor {
    int levelOfCritical;
    int throughput = 0;

    Reactor(int levelOfCritical) {
        this.levelOfCritical = levelOfCritical;
    }

    void increase() {
        this.throughput = throughput + (int) (Math.random() * 100);
//    if(throughput>levelOfCritical) throw new IllegalArgumentException("A trecut de pragul critical");
    }

    void decrease() {
        int x = (int) (Math.random() * 100);
        if ((throughput - x) >= 0) {
            this.throughput = throughput - x;
        }
    }

    boolean isCriticalorNot() {
        if (throughput > levelOfCritical) return true;
        else
            return false;

    }
}
