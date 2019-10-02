package inheritance;

public class Mamifer {
    String specie;

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }
    public Mamifer(){
        System.out.println("Mamifer");
    }
    public void w(){
        System.out.println("w");
    }
    public Mamifer(String [] classes){
        System.out.println("Mamifer is here");
    }
}
