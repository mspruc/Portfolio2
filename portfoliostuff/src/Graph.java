import java.util.*;

public class Graph {



    public void findMST (PriorityQueue<Edge> graph, HashMap<String, Boolean> isReached){
        //step 1 of prims
        Edge shortestEdge = graph.poll();
        ArrayList<Edge> MST = new ArrayList<>();
        assert shortestEdge != null;
        System.out.println(shortestEdge.destination);
        if(isReached.get(shortestEdge.destination).equals(false)){
           MST.add(shortestEdge);
           isReached.put(shortestEdge.destination,true);
        }


        //step 2 of prims
    }
}

class Edge implements Comparable<Edge>{
    @Override
    public String toString() {
        return "Edge{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                '}';
    }

    String source;
    String destination;
    int distance;

    public Edge (String source,String destination, int distance){
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.distance < o.distance) return -1;
        else if (this.distance > o.distance) return 1;
        return 0;
    }

}

class Vertex{
    String name;

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", isReached=" + isReached +
                '}';
    }

    public boolean isReached = false;

    Vertex (String name){
        this.name = name;
    }
}