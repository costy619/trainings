package The.Shortest.Path.Problem;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        TravelMap map = new TravelMap();
        Hotel v1 = new Hotel("Hotel");
        v1.setOpeningAndClosingTime(7, 23);
        v1.setStars(8);
        Museum v2 = new Museum("MuseumA");
        v2.setPrice(20.89);
        v2.setVisitable();
        Museum v3 = new Museum("MuseumB");
        v3.setOpeningAndClosingTime(9, 16);
        v3.setPrice(50.89);
        v3.setVisitable();
        Church v4 = new Church("ChurchA");
        v4.setOpeningAndClosingTime(8, 12);
        v4.setVisitable();
        Church v5 = new Church("ChurchB");
        v5.setOpeningAndClosingTime(8, 13);
        v5.setVisitable();
        Restaurant v6 = new Restaurant("Restaurant");
        v6.setOpeningAndClosingTime(10, 24);
        v6.setPrice(300);
        map.addNode(v1);
        map.addNode(v2);
        map.addNode(v3);
        map.addNode(v4);
        map.addNode(v5);
        map.addNode(v6);
        map.addEdge(v1, v2, 15); //two way street by default
        map.addEdge(v3, v2, 1, false); //one-way street
        map.addEdge(v3, v4, 14); //two way street by default
        map.addEdge(v4, v5, 12, false); //one-way street
        map.addEdge(v4, v6, 17); //two way street by default
        map.addEdge(v1, v6, 14, false); //one-way street
//        Collections.sort(map.listOfNodes);
        System.out.println("Mapa este ");
        map.listOfEdges.forEach(i-> System.out.println(i.toString()));
//        ex6(map);
//        ex7(map);
//        ex9();
    }
    public static void ex9(){
        Nodes n=new Nodes();
        Duration d=n.getVisitingDuration();
        System.out.println("Programul de vizitare este de "+n.getVisitingDuration().toHours() +" hours "+n.getVisitingDuration().toMinutes()%60+" minute");
    }

    private static void ex7(TravelMap map){
        map.listOfNodes.stream()
                .filter((u)->u.payable)//
                .mapToDouble(j -> j.getTicketPrice()) //
                .average() //
                .ifPresent(avg -> System.out.println("Average found is " + avg));
    }
    private static void ex6(TravelMap map) {
        System.out.println("Aranjare dupa criterii la ex 6  Visitable and not payable ");
        map.listOfNodes.forEach(i -> {
            if (i.visitable && !i.payable) System.out.println( i.getName());
        });


    }


}

