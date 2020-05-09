package The.Shortest.Path.Problem;

public class Hotel extends Nodes implements Classifiable, Payable{


    public Hotel(String name){
        this.name=name;
    }

    @Override
    public double getTicketPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
        payable=true;
    }


}
