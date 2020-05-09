package tema4ex1;

import java.util.ArrayList;
import java.util.Locale;

import static tema4ex1.Building.Category.*;

public class Building {
    String name;
    public enum Category {RESIDENTIAL, OFFICE, HOSPITAL, RELIGIOUS}
    int price;
    String neighborhood;
Category category;
    Building(String name, int price, String neighborhood, Category category) {
        this.name = name;
        this.price = price;
        this.neighborhood = neighborhood;
       this.category=category;
    }

    public Category getCategoryAsString() {
            switch (category) {
                case RESIDENTIAL:
                    return category;
                case OFFICE:
                    return category;
                case HOSPITAL:
                    return category;
                case RELIGIOUS:
                    return category;

                default:
                    System.out.println("empty");
            }
        return category;
        }

}
