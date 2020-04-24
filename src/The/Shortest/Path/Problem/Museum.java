package The.Shortest.Path.Problem;

public class Museum extends Nodes implements Visitable,Payable {
    public void setPrice(double ticketprice){
        this.price=ticketprice;
        this.payable=true;
    }
    public void setVisitable(){
        this.visitable=true;
    }
    public Museum(String name){
        this.name=name;
    }

    @Override
    public double getTicketPrice() {
        return this.price;
    }
}
