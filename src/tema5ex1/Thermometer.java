package tema5ex1;

public class Thermometer implements Sensor {
    boolean b = false;

    @Override
    public boolean isOn() {
        return b;
    }

    @Override
    public void on() {
        b = true;
    }

    @Override
    public void off() {

        b = false;
    }

    @Override
    public int measure() {
        if (b == false) {
            throw new IllegalArgumentException("Sensor is off");
        }
        double x = (int) (Math.random() * ((36 + 30)) + 1) - 30;
        int y = (int) x;
        return y;
    }
}
