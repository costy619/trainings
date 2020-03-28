package The.Shortest.Path.Problem;

public class Nodes implements Comparable<Nodes> {
    String name;
     String getName(){
        return this.name;
    }
    
    void setName(String name){
         this.name=name;
    }
 public String toString(){
     return this.name;
    }

    @Override
    public int compareTo(Nodes o) {
        return getName().compareTo(o.getName());
    }
}
