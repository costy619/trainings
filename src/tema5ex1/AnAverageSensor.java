package tema5ex1;

import java.util.ArrayList;

public class AnAverageSensor implements Sensor {
    ArrayList<Sensor> list = new ArrayList<>();

    public void adSensor(Sensor sensor) {
        list.add(sensor);
    }

    @Override
    public boolean isOn() {
        int a = 0;
        for (Sensor s : list) {
            if (s.isOn()) {
                a++;
            }

        }
        if (a == list.size()) return true;
        return false;
    }

    @Override
    public void on() {
        for (Sensor s : list) {
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor s : list) {
            s.off();
        }
    }

    @Override
    public int measure() {
        int avg = 0;
        int it = 0;
        for (Sensor s : list) {
            it++;
            avg = (avg + s.measure()) / it;
        }
        if (list.size() == 0) {
            throw new IllegalArgumentException("Avarage senzor is empty");
        }
        return avg;
    }
}
