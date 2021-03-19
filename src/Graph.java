import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    Vertex[] graph;

    Graph () {


    }

    ArrayList<Vertex> findMST (Vertex[] graph){
        //step 1 of prims
        List<Vertex> unreachedNodes = Arrays.asList(graph);
        ArrayList<Vertex> MST = new ArrayList<>();
        MST.add(graph[0]);
        unreachedNodes.remove(graph[0]);

        //step 2 of prims


        return null;
    }
}

class Edge implements Comparable<Edge>{
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
    Edge[] adjVertex;

    Vertex (String name, Edge[] adjVertices){
        this.adjVertex = adjVertices.clone();
        this.name = name;
    }
}