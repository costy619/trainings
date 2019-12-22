package OnlineStoreClass;

import javax.smartcardio.CardTerminal;

public class Cart extends OnlineStore implements C{

    @Override
    public void addProduct(Product p) {
       products.add(p);
    }

    @Override
    public void removeProduct(Product p) {
products.remove(p);
    }
    @Override
    public void discount() {
        for(int i=0;i<products.size();i++){
            double discount1=products.get(i).getPrice()-100;
            double discount2=((discount1/100)*5)+discount1;
            products.get(i).setPrice(discount2);

        }

    }

    @Override
    public double computeTotalPrice(Cart c) {
        double sum=0;
        for(int i=0;i<c.products.size();i++){
             sum =sum +c.products.get(i).getPrice();
        }
            return sum;
    }
    public void afisare(Cart c){
        for(int i=0;i<c.products.size();i++) {
            System.out.println(c.products.get(i).getName()+ " " +c.products.get(i).getPrice());
        }
    }


}
