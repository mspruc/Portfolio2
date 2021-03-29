import java.lang.reflect.Array;
import java.util.*;

public class Graph {
    HashSet<Vertex> unvisitedTowns;

    Graph(HashSet<Vertex> towns){
        this.unvisitedTowns = towns;

        Vertex[] test = findMST((unvisitedTowns.toArray(new Vertex[0])));

        //System.out.println(unvisitedTowns.toString());
        //System.out.println(Arrays.toString(unvisitedTowns.toArray(new Vertex[0])));
    }

    Vertex[] findMST (Vertex[] graph){
        //step 1 of prims
        ArrayList<Vertex> MST = new ArrayList<>(); //init our MST that we will return
        MST.add(graph[0]);//fetch the arbitrary first vertex
        unvisitedTowns.remove(graph[0]); //remove it from unvisited towns as it is now visited.

        //while we still have towns that we haven't connected via an edge we continue to find towns and connect them to our MST
        //while(!unvisitedTowns.isEmpty()){

        //}

        //step 2 of prims

        return MST.toArray(new Vertex[0]);
    }
}

class Edge implements Comparable<Edge>{
    String source; //town from
    String destination; //town to
    int distance; // euclidean distance between source and destination

    public Edge (String source,String destination, int distance){
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                '}';
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
    PriorityQueue<Edge> edgeQ = new PriorityQueue<>();
    int best = Integer.MAX_VALUE;
    Edge[] adjVertex;

    Vertex (String name, Edge[] adjVertices){
        this.adjVertex = adjVertices;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", adjVertex=" + Arrays.toString(adjVertex) +
                '}';
    }
}