package tema5ex1;

public class Main {
    public static void main(String[] args) {
        ConstantSensor cs = new ConstantSensor(60);
        System.out.println(cs.measure());
        Thermometer t = new Thermometer();
        t.on();
        System.out.println(t.measure());
        AnAverageSensor av = new AnAverageSensor();
//        av.adSensor(t);
//        av.adSensor(cs);
        av.on();
        if (av.isOn()) System.out.println("este on");
        if (av.isOn()) System.out.println("este on");

        System.out.println(av.measure());
    }
}
