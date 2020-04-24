package The.Shortest.Path.Problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nodes implements Comparable<Nodes>,Payable,Visitable{
    String name;
    double price;
    int stars;
    boolean visitable;
    boolean payable;
    private List<Nodes> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    Map<Nodes, Integer> adiacentNodes = new HashMap<>();



     String getName(){
        return this.name;
    }
    int fromHour;
    int toHour;

    
    void setName(String name){
         this.name=name;
    }
 public String toString(){
     return this.name;
    }
    void setOpeningAndClosingTime(int fromHour,int toHour){
        this.fromHour=fromHour;
        this.toHour=toHour;
    }

    @Override
    public int compareTo(Nodes o) {
        return getName().compareTo(o.getName());
    }


    @Override
    public void setPrice(double price) {
        this.price=price;
        payable=true;
    }

    @Override
    public double getTicketPrice() {
        return this.price;
    }

    @Override
    public void setVisitable() {
        visitable=true;
    }
}
