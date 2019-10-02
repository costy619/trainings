import java.util.Scanner;

class Catalog {
    Student[] studs;
    String clasa;
    private String elevCePoateFiTransferat;
    private String elevDeTransferat;

    public void setClasa(String clasa) {

        this.clasa = clasa;
    }

    public String getClasa() {

        return clasa;
    }

    public void setStud(Student[] studs) {
        this.studs = studs;
    }

    public Student[] getStud() {
        return studs;
    }

 /*   public void afisareNote() {
        for (int i = 0; i < studs.length; i++) {
            System.out.println(getStud()[i].getNume() + " ");
            for (int j = 0; j < studs.length; j++) {
                System.out.println(getStud()[j].getNote() + " ");
            }
        }
    }*/

    public void afisareAlfabetic() {
        for (int i = 0; i < studs.length; i++) {
            for (int j = i + 1; j < studs.length; j++) {
                if (studs[i].getNume().compareTo(studs[j].getNume()) > 0) {
                    Student aux = getStud()[i];
                    getStud()[i] = getStud()[j];
                    getStud()[j] = aux;
                }
            }
            System.out.println(getStud()[i].getNume());
        }
    }

    public void media() {
        double s = 0;
        double media = 0;
        for (int i = 0; i < studs.length; i++) {
            s = 0;
            for (int j = 0; j < getStud()[i].getNote().length; j++) {
                s = s + getStud()[i].getNote()[j];
                media = s / getStud()[i].getNote().length;
            }
            System.out.println(getStud()[i].getNume() + " " + media);
            getStud()[i].setMedie(media);
        }
    }

    public void afisareCrescatoare() {
        for (int i = 0; i < studs.length; i++) {
            for (int j = i + 1; j < studs.length; j++) {
                if (studs[i].getMedie() > studs[j].getMedie()) {
                    Student aux = getStud()[i];
                    getStud()[i] = getStud()[j];
                    getStud()[j] = aux;
                }
            }
            System.out.println(getStud()[i].getNume() + " " + getStud()[i].getMedie());
        }
    }

    public void elevCePoateFiTransferat(String elev) {
        this.elevCePoateFiTransferat = elev;
    }

    public String getElev() {
        return elevCePoateFiTransferat;
    }

    public String getElevDeTransferat() {
        return elevDeTransferat;
    }

    public void setElevDeTransferat(String elevDeTransferat) {
        this.elevDeTransferat = elevDeTransferat;
    }

    public void schimbare(Catalog cat2) {
        for (int i = 0; i < studs.length; i++) {
            if (this.studs[i].getNume().equals(elevCePoateFiTransferat)) {
                for (int j = 0; j < cat2.studs.length; j++) {
                    if (cat2.studs[j].getNume().equals(cat2.elevDeTransferat)) {
                        Student aux = this.getStud()[i];
                        this.getStud()[i] = cat2.getStud()[j];
                        cat2.getStud()[j] = aux;
                        System.out.println(cat2.getStud()[j].getNume() + " a fost schimbat cu " + this.getStud()[i].getNume());
                        break;
                    }
                }
            }
        }
    }
}

