package OnlineStoreClass;

import java.util.Scanner;

public class Meniu {
    public void meniu() {

        System.out.println();
        Scanner keyboard = new Scanner(System.in);
        boolean doit = true;
        colectaredateClient(keyboard);
        while (doit == true) {
            String obtiune = keyboard.nextLine();
            switch (obtiune) {
                case ("1"):
                    Cart c = new Cart();
//                    Product prod= new Product();
//                    System.out.println("Intruduceti ID-ul produsului");
//                    prod.setId(keyboard.nextInt());
//                    System.out.println("Introduceti numele produsului");
//                    prod.setName(keyboard.next());
//                    System.out.println("Introduceti culoarea produsului");
//                    prod.setColor(keyboard.next());
//                    System.out.println("introduceti tipul produsului ex:clothing, electronics");
//                    prod.setType(keyboard.next());
//                    System.out.println("Introduceti pretul produsului ");
//                    prod.setPrice(keyboard.nextDouble());
//                    c.addProduct();
                    break;
                case ("2"):
                    Cart c1 = new Cart();
                    System.out.println("Introdu produsul pe care vrei sa il scoti din cos");
                    String nume = keyboard.next();
                    for (int i = 0; i < c1.products.size(); i++) {
                        if (c1.products.get(i).getName().equals(nume)) {
                            c1.removeProduct(c1.products.get(i));
                            System.out.println("produsul "+ c1.products.get(i).getName()+" a fost scos din cos");
                        }
                    }
                    break;
                case ("3"):
                    Cart c2 = new Cart();
                    c2.afisare(c2);
                    System.out.println("Totalul cumparturilor este "+c2.computeTotalPrice(c2));
                    meniul();
                    break;
                case("4"):
                    Cart cart=new Cart();
                    cart.discount();
                    cart.afisare(cart);
                    System.out.println("Totalul cumparturilor este "+cart.computeTotalPrice(cart));
                    meniul();
                    break;
                case ("5"):
                    doit = false;
                    break;
                default:
                    meniul();
                    break;
            }
        }
    }

    private void colectaredateClient(Scanner keyboard) {
        System.out.println("logheaza-te ca sa poti intra");
        System.out.println("introdu prenumele");
        Cart cart=new Cart();
        cart.p.setFirstName(keyboard.next());
        System.out.println("introdu numele");
        cart.p.setLastName(keyboard.next());
        System.out.println("Introdu CNP-ul");
        cart.p.setCnp(keyboard.nextInt());
        System.out.println("Introdu adresa ta din iasi ca sa zice ionut");
        System.out.println("Introdu Tara");
        cart.p.address.setCountry(keyboard.next());
        System.out.println("Introdu orasul");
        cart.p.address.setCity(keyboard.next());
        System.out.println("Introdu Strada");
        cart.p.address.setStreet(keyboard.next());
        System.out.println("Salutare " +cart.p.getFirstName()+"cu adresa: "+cart.p.address.getCountry()+" orasul: "+cart.p.address.getCity()+" Strada:"+cart.p.address.getStreet());
    }

    private void meniul () {
        System.out.println("Apasa tasta 1 pentru a introduce in cos");
        System.out.println("Apasa tasta 2 pentru scaote un produs din cos introducand numele acelui produs");
        System.out.println("Apasa tasta 3 pentru a vizualiza cosul");
        System.out.println("Apasa tasta 4 pentru a vizualiza cosul cu mega reducerea de 100 de lei si un 5% asa ca esti baiat fain");
        System.out.println("Apasa tasta 5 pentru a iesi din aplicatie");
    }
}
