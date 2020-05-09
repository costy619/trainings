package onlineStoreClass;

import java.util.Scanner;

import static onlineStoreClass.Store.produsele;
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
                    for (int i = 0; i < produsele.size(); i++) {
                        System.out.println(produsele.get(i).getName()+ " Id: "+ produsele.get(i).getId()+
                                " Culoare:"+produsele.get(i).getColor()+" Pret:"+produsele.get(i).getPrice()+
                                " Tip "+produsele.get(i).getType());
                    }
                    meniul();
                    break;
                case ("2"):
                    Cart c1 = new Cart();
                    System.out.println("Introdu produsul pe care vrei sa il cumperi");
                    String nume = keyboard.next();
                    for (int i = 0; i < produsele.size(); i++) {
                        if (produsele.get(i).getName().equals(nume)) {
                            System.out.println("produsul "+ produsele.get(i).getName()+" a fost adaugat in cos");
                            c1.addProduct(produsele.get(i));
                        }
                    }
                    break;
                case ("3"):
                    for (int i = 0; i < produsele.size(); i++) {
                        System.out.println("produsul " + produsele.get(i).getName() +" pret: "+ produsele.get(i).getPrice());
                    }
                    meniul();
                    break;
                case("4"):
                    Cart cart = new Cart();
                    System.out.println("Introdu culoarea dupa care vrei sa faci selectia");
                    String culoare = keyboard.next();
                    System.out.println("Produsele ordonate dupa culoare");
                    for (int i = 0; i < produsele.size(); i++) {
                        if (produsele.get(i).getColor().equals(culoare)) {
                            System.out.println( produsele.get(i).getName()+" culoare "+produsele.get(i).getColor());
                        }
                    }
                    break;
                case("5"):
                    Cart cart1=new Cart();
                    cart1.discount();
                    cart1.afisare(cart1);
                    System.out.println("Totalul cumparturilor este "+cart1.computeTotalPrice(cart1));
                    meniul();
                    break;
                case ("6"):
                    doit = false;
                    break;
                case ("7"):
                    Product prod= new Product();
                    System.out.println("Intruduceti ID-ul produsului");
                    prod.setId(keyboard.nextInt());
                    System.out.println("Introduceti numele produsului");
                    prod.setName(keyboard.next());
                    System.out.println("Introduceti culoarea produsului");
                    prod.setColor(keyboard.next());
                    System.out.println("introduceti tipul produsului ex:clothing, electronics");
                    prod.setType(keyboard.next());
                    System.out.println("Introduceti pretul produsului ");
                    prod.setPrice(keyboard.nextDouble());
                    produsele.add(prod);
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
        System.out.println("Salutare " +cart.p.getFirstName()+" cu adresa: "+cart.p.address.getCountry()+" orasul: "+cart.p.address.getCity()+" Strada:"+cart.p.address.getStreet());
    }

    private void meniul () {
        System.out.println("Apasa tasta 1 pentru a vedea produsele magazinului  a.have all products listed");
        System.out.println("Apasa tasta 2 pentru cumpara produs b.Buy one product");
        System.out.println("Apasa tasta 3 pentru a vedea produsele cu preturile c.List products by price");
        System.out.println("Apasa tasta 4 pentru a filtra produsele in functie de culoare d.Select only specific products ( filtered by color) ");
        System.out.println("Apasa tasta 5 pentru a vizualiza cosul cu mega reducerea de 100 de lei si un 5% asa ca esti baiat fain");
        System.out.println("Apasa tasta 6 pentru a iesi din aplicatie");
        System.out.println("Apasa tasta 7 pentru pentru a introduce un produs in depozit");
    }
}
