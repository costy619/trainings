package The.Shortest.Path.Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TravelMap extends Nodes {
    Set<Nodes> listOfNodes=new HashSet<>();
    ArrayList<Edge> listOfEdges=new ArrayList<>();

int i=0;
    public void  addEdge(Nodes varfStanga, Nodes varfDreapta, double distance, boolean sens){
        Edge e=new Edge();
       e.varfStanga=varfStanga;
        e.varfDreapta=varfDreapta;
        e.distance=distance;
        e.twoWaySens=sens;
        listOfEdges.add(e);
    }
    public void  addEdge(Nodes varfStanga, Nodes varfDreapta, double distance){
        Edge e=new Edge();
        e.varfStanga=varfStanga;
        e.varfDreapta=varfDreapta;
        e.distance=distance;
        listOfEdges.add(e);
    }
    public String toString() {
        i++;
    return listOfEdges.get(i-1).toString();
    }

    public String getNodes() {

       return listOfNodes.toString();
}
    public void addNode(Nodes n) {
        listOfNodes.add(n);
    }

}
