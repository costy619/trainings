package inheritance;

public class Person extends Mamifer{
    protected String nume;
    protected String getNume(){
        return nume;
    }

  public void setNume(String nume) {
        this.nume = nume;
    }

    public void walk(){
        System.out.println("Person is walking");
    }
    public Person(){
        super();
        System.out.println("Person");
    }
public Person(String nume){
        this.nume=nume;
    System.out.println("Person is here");
}
}
