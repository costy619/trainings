package zoooManagement;

public class Ras implements Animale{
    private final String culoare="maro cu alb";
    private final int numarPicioare=4;
    private final String specie="ras";
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
