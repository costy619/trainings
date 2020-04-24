package The.Shortest.Path.Problem;

public class Restaurant extends Nodes implements Payable {

    public Restaurant(String name){
        this.name=name;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
        this.payable=true;
    }

    @Override
    public double getTicketPrice() {
        return this.price;
    }
}
