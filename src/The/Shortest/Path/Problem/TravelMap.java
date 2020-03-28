package The.Shortest.Path.Problem;

import java.util.ArrayList;
import java.util.HashMap;

public class TravelMap extends Nodes {
    ArrayList<Nodes> listOfNodes=new ArrayList<>();
    ArrayList<Edge> listOfEdges=new ArrayList<>();
    HashMap map=new HashMap();
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

    public String getNodes() {

       return listOfNodes.toString();
}
    public void addNode(Nodes n) {
        listOfNodes.add(n);
    }

}
