package OnlineStoreClass;

import static OnlineStoreClass.OnlineStore.products;

public class DepozitProduse{
    public void depozitProduse () {
        Cart c = new Cart();
        Product p1= new Product();
        p1.setType("Electrocasnic");
        p1.setColor("Alb");
        p1.setName("TelefonApple");
        p1.setPrice(1000);
        p1.setId(90);
        c.addProduct(p1);
        Product p2= new Product();
        p2.setType("Electrocasnic");
        p2.setColor("Negru");
        p2.setName("TelefonSamsung");
        p2.setPrice(5600);
        p2.setId(91);
        c.addProduct(p2);
        Product p3= new Product();
        p3.setType("Electrocasnic");
        p3.setColor("Alb");
        p3.setName("TelevizorSamsung");
        p3.setPrice(8009);
        p3.setId(92);
        c.addProduct(p3);
    }
}
