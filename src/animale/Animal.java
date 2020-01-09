package animale;

public class Animal {

    public String species_name;
    public String animal_name;
    String[] stomach_contents  =  new  String[ 30 ];
    int number_of_feedings  =  0;
    public Animal(String given_species_name, String name) {
        animal_name = name;
        species_name = given_species_name;
    }

    public Animal(Animal another_animal, String name) {
        animal_name = name;
        species_name = another_animal.species_name;
        //stomach_contents  =  another_animal.stomach_contents.clone() ;
    }

    public Animal() {
    }

    public void feed(String food_for_this_animal) {
        if (stomach_contents!=null){
            stomach_contents[number_of_feedings] = food_for_this_animal;
            number_of_feedings++;
    }
    }

    public void make_speak() {
        if(animal_name==null){
            System.out.println("Hello, I am a default animal called no name ");
        }
        if (stomach_contents==null&&animal_name!=null) {
            System.out.println("Hello, I am " + species_name + " called " + animal_name);
            System.out.println("My stomach is empty");
        }else {
            for (int i = 0; i < number_of_feedings; i++) {
                System.out.println("Hello, I am a " + species_name + " called " + animal_name);
                System.out.println("I have eaten:" + (i + 1) + " times " + " last meal was " + stomach_contents[i]);

            }
        }
    }

    public void make_stomach_empty() {
        stomach_contents= null;
    }
}

