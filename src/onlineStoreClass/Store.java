package onlineStoreClass;

import java.util.ArrayList;

public class Store{

    public static ArrayList<Product> produsele= new ArrayList<>();
    public void depozitProduse () {
        Product p1= new Product();
        p1.setType("Electrocasnic");
        p1.setColor("Alb");
        p1.setName("TelefonApple");
        p1.setPrice(1000);
        p1.setId(90);
        produsele.add(p1);
        Product p2= new Product();
        p2.setType("Electrocasnic");
        p2.setColor("Negru");
        p2.setName("TelefonSamsung");
        p2.setPrice(5600);
        p2.setId(91);
        produsele.add(p2);
        Product p3= new Product();
        p3.setType("Electrocasnic");
        p3.setColor("Alb");
        p3.setName("TelevizorSamsung");
        p3.setPrice(8009);
        p3.setId(92);
        produsele.add(p3);
        }

    }

