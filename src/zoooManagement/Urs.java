package zoooManagement;

public class Urs implements Animale {
    private String culoare="brun";
    private int numarPicioare=4;
    private String specie="urs";
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
