package tourists;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Hotel> hotels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
         return name;
    }
}