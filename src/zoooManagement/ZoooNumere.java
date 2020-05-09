package zoooManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import static zoooManagement.Zoo.Anime;


public class ZoooNumere{

    void adaugareLaZooAnimale() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("introdu un animal la zoo dintre urmatoarele: Cangur, Urs, Ras sau apasa tasta 1 pentru a iesi");
        boolean doit = true;
        HashMap<String, ArrayList<Animale>> hashMap = new HashMap<>();
        while (doit == true) {
            String obtiune = keyboard.nextLine();
            switch (obtiune) {
                case ("Urs"):
                    Urs u = new Urs();
                    if (hashMap.get("Urs") == null) {
                        hashMap.put("Urs", new ArrayList<Animale>());
                        hashMap.get("Urs").add(u);
                    } else hashMap.get("Urs").add(u);

                    Anime.add(u);
                    System.out.println("Introdu un animal la gradina zoologica sau apasa tasta 1 pentru a iesi ");
                    break;
                case ("Cangur"):
                    Cangur c = new Cangur();
                    Anime.add(c);
                    if (hashMap.get("Cangur") == null) {
                        hashMap.put("Cangur", new ArrayList<Animale>());
                        hashMap.get("Cangur").add(c);
                    } else hashMap.get("Urs").add(c);
                    System.out.println("Introdu un animal la gradina zoologica sau apasa tasta 1 pentru a iesi");

                    break;
                case ("Ras"):
                    Ras r = new Ras();
                    Anime.add(r);
                    if (hashMap.get("Ras") == null) {
                        hashMap.put("Ras", new ArrayList<Animale>());
                        hashMap.get("Ras").add(r);
                    } else hashMap.get("Ras").add(r);
                    System.out.println("Introdu un animal la gradina zoologica sau apasa tasta 1 pentru a iesi");

                    break;
                case ("1"):
                    doit = false;
                    System.out.println("La Revedere");
                    break;
                default:
                    System.out.println("introdu un animal dintre urmatoarele: Cangur, Urs, Ras sau apasa tasta 1 pentru a iesi");
                    break;
            }
        }


        Iterator entries = hashMap.entrySet().iterator();
        while (entries.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) entries.next();
            String key = (String) entry.getKey();
            ArrayList<Animale> value = (ArrayList<Animale>) entry.getValue();
            if (key == "Urs") {
                for (int i = 0; i < value.size(); i++) {
                    System.out.println("Tipul: " + value.get(i).getSpecie() + " culoare: " + value.get(i).getCuloare() + " " + value.get(i).mers());
                }
            }
            if (key == "Cangur") {
                for (int i = 0; i < value.size(); i++) {
                    System.out.println("Tipul: " + value.get(i).getSpecie() + " culoare: " + value.get(i).getCuloare() + " " + value.get(i).mers());
                }
            }
            if (key == "Ras") {
                for (int i = 0; i < value.size(); i++) {
                    System.out.println("Tipul: " + value.get(i).getSpecie() + " culoare: " + value.get(i).getCuloare() + " " + value.get(i).mers());
                }
            }
        }
        try{
        if (hashMap.get("Urs").size() > 0)
            System.out.println("La gradina zoologica sunt cazati: " + hashMap.get("Urs").size() + " Ursi ");
    }catch (NullPointerException e){}
        try{
        if(hashMap.get("Cangur").size() >0)
            System.out.println("La gradina zoologica sunt cazati: "+hashMap.get("Cangur").size()+" Canguri");
    }catch (NullPointerException e){}
        try{
        if(hashMap.get("Ras").size()>0 ) System.out.println("La gradina zoologica sunt cazati: "+hashMap.get("Ras").size()+" Rasi ");
        }catch (NullPointerException e){}
    }
}
