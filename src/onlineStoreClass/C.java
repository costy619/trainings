package onlineStoreClass;

import java.util.ArrayList;

public interface C {
    void addProduct(Product p);
    void removeProduct(Product p);
    double computeTotalPrice(Cart c);
    public void discount();
    public static ArrayList<Product> products=new ArrayList<Product>();
    Customer p=new Customer();
    Adress adress=new Adress();
}

