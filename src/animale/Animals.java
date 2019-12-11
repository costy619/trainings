package animale;

   public class  Animals{
        public static void main( String[] not_in_use )
        {
            Animal  cat_object  =  new Animal( "cat", "Ludwig") ;
            Animal  dog_object  =  new Animal( "vegetarian dog","Berlin" ) ;
            Animal  another_cat  =  new Animal( cat_object, "Ionel") ;
            Animal  some_animal  =  new  Animal();
            some_animal.make_speak();
//            cat_object.make_stomach_empty();
            cat_object.feed( "fish" ) ;
            cat_object.feed( "chicken" ) ;
            dog_object.feed( "salad" ) ;
            dog_object.feed( "potatoes" ) ;
            another_cat.feed( "milk" ) ;
            cat_object.make_speak() ;
            dog_object.make_speak() ;
            another_cat.make_speak() ;
            Zoo  test_zoo  =  new  Zoo() ;
            test_zoo.add_animal(cat_object ) ;
            test_zoo.add_animal(dog_object ) ;
            test_zoo.add_animal(another_cat ) ;
            test_zoo.add_animal(some_animal ) ;
            test_zoo.make_animals_speak();

        }
    }
