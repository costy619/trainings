package The.Shortest.Path.Problem;

public class Church extends Nodes implements Visitable {

    public Church(String name){
        this.name=name;
    }

    @Override
    public void setVisitable() {
        this.visitable=true;    }
}
