import java.util.regex.Pattern;

public class Student {
    private String nume;
    private int[] note;
    private double medie;
    public static Biblioteca biblioteca;

    public Student(String nume, int[] note) {
        if (esteCorect(nume)) {
            this.nume = nume;
            this.note = note;
        } else {
            System.out.println("Nume incorect");
        }
    }

    public boolean esteCorect(String name) {

        return (Pattern.matches(".*^[a-z-A-Z]*$", name));
    }

    public Student(String nume) {

        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNote(int[] note) {

        this.note = note;
    }

    public int[] getNote() {

        return note;
    }

    public void setMedie(double medie) {
        double suma = 0;
        double media = 0;

        this.medie = medie;

    }

    public double getMedie() {
        return medie;
    }

}