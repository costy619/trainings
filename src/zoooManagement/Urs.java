package zoooManagement;

public class Urs implements Animale {
    public static final String culoare="brun";
    public static final int numarPicioare=4;
    public static final String specie="urs";
    @Override
    public String mers() {
        return "merge in "+numarPicioare+" picioare";
    }


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
}
