package The.Shortest.Path.Problem;

public interface Classifiable {
    Nodes n=new Nodes();
    default void setStars(int stars){
        n.stars= stars;
    }
    default int getStars(){
        return n.stars;
    }
}
