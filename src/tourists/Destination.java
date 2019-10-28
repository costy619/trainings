package tourists;

import java.util.ArrayList;

public class Destination {

    private String country;
    private ArrayList<City> cities;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }


}
