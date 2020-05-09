package zoooManagement;

public class Urs extends Animale {
    private String culoare="brun";
    private int numarPicioare=4;
    private String specie="urs";

    @Override
    public String getCuloare() {
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

    @Override
    public String toString() {
        return getSpecie();
    }
}
