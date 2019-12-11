package animale;

class Zoo {

    Animal[] animals_in_zoo = new Animal[20];
    static int number_of_animals_in_zoo = 0;
    public void add_animal(Animal new_animal_to_zoo) {

        animals_in_zoo[number_of_animals_in_zoo]=new_animal_to_zoo;
        number_of_animals_in_zoo ++;
    }

    public void make_animals_speak() {
        System.out.println("We are in a ZOO and we can speak ");
        for (int animal_index = 0; animal_index < number_of_animals_in_zoo; animal_index++) {
              animals_in_zoo[animal_index].make_speak();
//            if(animals_in_zoo[animal_index].animal_name==null){
//                System.out.println("Hello, I am a default animal called no name ");
//            }
//            if (animals_in_zoo[animal_index].stomach_contents == null&&animals_in_zoo[animal_index].animal_name!=null) {
//                System.out.println("Hello, I am "+animals_in_zoo[animal_index].species_name +" called " +animals_in_zoo[animal_index].animal_name);
//                System.out.println("My stomach is empty");
//            } else if(animals_in_zoo[animal_index].stomach_contents != null){
//                System.out.println("Hello, I am a "+animals_in_zoo[animal_index].species_name +" called " + animals_in_zoo[animal_index].animal_name);
//                System.out.println("I have eaten:" + animals_in_zoo[animal_index].stomach_contents);
//
//            }
        }
    }
}