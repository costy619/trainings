package tema5ex2;

public class PowerPlant {
    int desire;

    PowerPlant(int desire) {
        this.desire = desire;
    }

    void alarm() {
        System.out.println("Alarm");
    }

    void desireOutput() {
        System.out.println(desire);
    }
}
