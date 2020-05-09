package inheritance;

import java.sql.SQLOutput;

public class Teacher extends Person{
   protected String [] classes;
   protected String[] getClasses(){
       return classes;
   }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }
    @Override
    public void walk(){
        System.out.println("Teacher is walking");
    }

    public Teacher(){

        super();
        System.out.println("teacher");

    }
    public Teacher(String [] classes){
       super("ion");
       this.classes=classes;
        System.out.println("teacher is here");
    }
    public void tralala(){
        System.out.println("Teacher is walking");
        super.walk();
    }
    public Teacher(String nume,String[] classes){
       this.nume=nume;
       this.classes=classes;
    }

}
