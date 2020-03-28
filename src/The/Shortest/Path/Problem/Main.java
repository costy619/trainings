package The.Shortest.Path.Problem;



import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        TravelMap map = new TravelMap();
        Hotel v1 = new Hotel("Hotel");
        Museum v2 = new Museum("MuseumA");
        Museum v3 = new Museum("MuseumB");
        Church v4 = new Church("ChurchA");
        Church v5 = new Church("ChurchB");
        Restaurant v6 = new Restaurant("Restaurant");
        map.addNode(v1);
        map.addNode(v2);
        map.addNode(v3);
        map.addNode(v4);
        map.addNode(v5);
        map.addNode(v6);
        map.addEdge(v1, v2, 15); //two way street by default
        map.addEdge(v3, v2, 1, false); //one-way street
         if(map.listOfEdges.get(0).distance==15 && map.listOfEdges.get(0).twoWaySens==false){
             System.out.println("yeeee");
         }
        Collections.sort(map.listOfNodes);

        System.out.println("The map is: \n" + map.listOfNodes);
    }
}

