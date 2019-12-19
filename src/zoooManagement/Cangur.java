package zoooManagement;

public class Cangur implements Animale {
    public static final String culoare="maro";
    public static final int numarPicioare=2;
    public static final String specie="cangur";
    @Override
    public String mers() {
        return "merge in salturi";
    }

    public  String getCuloare(){
        return culoare;
    }

    @Override
    public String getSpecie() {
        return specie;
    }

    @Override
    public int getNumarPicioare() {
        return numarPicioare;
    }
}
