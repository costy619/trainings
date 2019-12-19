package zoooManagement;

public class Cangur implements Animale {
    private final String culoare="maro";
    private final int numarPicioare=2;
    private final String specie="cangur";
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
