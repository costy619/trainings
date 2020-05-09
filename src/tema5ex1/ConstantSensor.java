package tema5ex1;

public class ConstantSensor implements Sensor {
    int constantValue;
    boolean b = true;

    ConstantSensor(int constantValue) {
        this.constantValue = constantValue;
    }

    @Override
    public boolean isOn() {
        if (b)
            return true;
        else
            return false;
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
        return constantValue;
    }
}
