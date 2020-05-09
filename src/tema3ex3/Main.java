package tema3ex3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        creareArhiva(library.archive);
        library.archive.sort(new NoofDownloadsSort());
        adaugareInTop20(library.archive, library.top20);
//         show(library.top20);
        modificareNumarDownload(library.archive, library.top20, "Baltagul", 19078);
        show(library.top20);


    }

    private static void modificareNumarDownload(ArrayList<MediaEntity> arrayList, ArrayList<MediaEntity> arrayList1, String title, int numarulNoudeDescarcari) {

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getTitle().equals(title)) {
                arrayList.get(i).setNoOfDownloads(numarulNoudeDescarcari);
            }
        }
        arrayList.sort(new NoofDownloadsSort());
        adaugareInTop20(arrayList, arrayList1);
    }

    private static void creareArhiva(ArrayList<MediaEntity> arrayList) {

        Library library = new Library();
        library.archive = arrayList;
        Book b1 = new Book(7, "Asa si Asa", "Aventura", "Ion Rebreanu", "Aula");
        Book b2 = new Book(8, "Baltagul", "Aventura", "Ion Rebreanu", "Teora");
        Book b3 = new Book(89, "LA LA", "Aventura", "Ion Luca Caragiale", "Aula");
        Book b4 = new Book(34, "Asa si?", "Aventura", "Ion Rebreanu", "Aula");
        Book b5 = new Book(33, "Asa da", "Poezie", "Eminescu", "Aula");
        Book b6 = new Book(32, "Asa nu", "Aventura", "Ion Luca Caragiale", "Aula");
        Book b7 = new Book(324, "Asa si acum ce?", "Aventura", "Ion Rebreanu", "Aula");
        Book b8 = new Book(23, "Doi frati", "Novela", "Ion Luca Caragiale", "Teora");
        Book b9 = new Book(253, "Ba da", "Aventura", "Ion Rebreanu", "Aula");
        Book b10 = new Book(35, "Da da", "Aventura", "Ion Luca Caragiale", "Aula");
        Book b11 = new Book(33, "4 camere", "Aventura", "Ion Rebreanu", "Teora");
        Book b12 = new Book(334, "Doi pereti", "Aventura", "Ion Luca Caragiale", "Aula");
        Book b13 = new Book(453, "Asa si ce daca", "Poezie", "Eminescu", "Aula");
        Book b14 = new Book(325, "Noi si ei", "Aventura", "Ion Rebreanu", "Teora");
        Book b15 = new Book(38, "Ioi Ioi", "Poezie", "Eminescu", "Aula");
        Mp3 mp1 = new Mp3(10, "La la", "tehno", "Irina Rimes", "Flori de catifea");
        Mp3 mp2 = new Mp3(11, "La lo,lo", "tehno", "Irina Rimes", "Flori de catifea");
        Mp3 mp3 = new Mp3(12, "Nu nU", "tehno", "Irina Rimes", "Flori de catifea");
        Mp3 mp4 = new Mp3(13, "Da da la", "tehno", "Irina Rimes", "Flori de catifea");
        Mp3 mp5 = new Mp3(15, "Tralala", "tehno", "Irina Rimes", "Flori de catifea");
        Mp3 mp6 = new Mp3(116, "Mimo", "tehno", "Irina Rimes", "Flori de catifea");
        Mp3 mp7 = new Mp3(119, "Momo", "tehno", "Irina Rimes", "Flori de catifea");
        Video v1 = new Video(71, "Foc", "Actiune", "1h -2min", true);
        Video v2 = new Video(72, "Foc-apa", "Actiune", "4h -2min", true);
        Video v3 = new Video(74, "Gaste", "Documentar", "8h -2min", true);
        Video v4 = new Video(76, "Rate", "Documentar", "19h -2min", true);
        Video v5 = new Video(79, "Porc", "Documentar", "9h -2min", true);
        library.archive.add(b1);
        library.archive.add(b2);
        library.archive.add(b3);
        library.archive.add(b4);
        library.archive.add(b5);
        library.archive.add(b6);
        library.archive.add(b7);
        library.archive.add(b8);
        library.archive.add(b9);
        library.archive.add(b10);
        library.archive.add(b11);
        library.archive.add(b12);
        library.archive.add(b13);
        library.archive.add(b14);
        library.archive.add(b15);
        library.archive.add(mp1);
        library.archive.add(mp2);
        library.archive.add(mp3);
        library.archive.add(mp4);
        library.archive.add(mp5);
        library.archive.add(mp6);
        library.archive.add(mp7);
        library.archive.add(v1);
        library.archive.add(v2);
        library.archive.add(v3);
        library.archive.add(v4);
        library.archive.add(v5);
    }

    private static void show(ArrayList<MediaEntity> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getNoOfDownloads());
        }
    }

    private static void adaugareInTop20(ArrayList<MediaEntity> arrayList, ArrayList<MediaEntity> arrayList1) {
        arrayList1.removeAll(arrayList1);
        for (int i = 0; i < 20; i++) {
            arrayList1.add(arrayList.get(i));
        }

    }
}
