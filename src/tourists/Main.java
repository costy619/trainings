package tourists;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Hotel c = new Hotel();

        c.setName("Sally");

        calculate(c);
        System.out.println((c.getName()));

    }

    public static void calculate(Hotel c) {
        c.setName("Diane");
    }
}

