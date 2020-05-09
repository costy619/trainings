package The.Shortest.Path.Problem;

public class Edge {
    Nodes varfStanga;
    Nodes varfDreapta;
    Boolean twoWaySens=true;
    double distance;
    public String toString(){
          if(twoWaySens) {
              return ("De la "+this.varfStanga + " sens dublu pana la " + this.varfDreapta + " distanta este de " + distance + " kilometri");
          }
          if(twoWaySens==false){
              return ("De la "+this.varfStanga + " sens unic pana la " + this.varfDreapta + " distanta este de " + distance+ " kilometri");
          }
          return null;
    }
//    public  Edge(Nodes varfStanga, Nodes varfDreapta,double distance){
//        this.varfStanga=varfStanga;
//        this.varfDreapta=varfDreapta;
//       this.distance=distance;
}
