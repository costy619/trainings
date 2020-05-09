package gradinaZoo;

public class Carnivore extends Animal{
    public void feed( Animal animal_to_be_eaten ) {
        if (stomach_contents!=null) {
            stomach_contents[number_of_feedings] = animal_to_be_eaten.species_name;
            number_of_feedings++;
        }
    }
   public Carnivore (String given_species_name, String name){
       animal_name = name;
       species_name = given_species_name;
   }
}
