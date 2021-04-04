import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MatrixGraph {
    ArrayList<Edge> edges;
    ArrayList<Vertex> vertices;
    ArrayList<Edge> edgeTree = new ArrayList<>();

    MatrixGraph(ArrayList<Edge> edges, AdjacencyGraph adjacencyGraph) {
        this.edges = edges;
        this.vertices = adjacencyGraph.vertices;
    }

    public void MST2ElECTRICBOOGALOO(){

        MinHeap<Edge> edgeMinHeap = new MinHeap<>();
        int treeDist = 0;                   //init tree distance as 0 so it can be fetched l8r

        Vertex v = vertices.get(0); //fetch the arbitrary first town
        v.isVisited = true;

        for (Edge edge : v.OutEdges) {
            edgeMinHeap.insert(edge); //add all the edges from the vertex to the minheap
        }

        while(!edgeMinHeap.isEmpty()){
            Edge bestEdge;                       //arbitrary edge init
            bestEdge = edgeMinHeap.extractMin(); //get the smallest edge


            if (!bestEdge.to.isVisited) {            //if the town is not visited
                System.out.println(edgeMinHeap.minheap);
                System.out.println();
                System.out.println(bestEdge);
                bestEdge.isFound = true;             //then edge is found
                edgeTree.add(bestEdge);              //save the best edge in the MST
                bestEdge.to.isVisited = true;        //the town is now visited

                for (Edge edge : bestEdge.to.OutEdges) {
                    edgeMinHeap.insert(edge);
                }
            }

              /*
            for (Edge edge : v.OutEdges) {
                System.out.println("out edge: " + edge);
                System.out.println("weight: " + edge.weight);
                System.out.println("dist saved in v: " + v.dist);
                System.out.println("is to visitied: " + edge.to.isVisited);
                System.out.println("");


                if (edge.weight <= v.dist && (!edge.to.isVisited || !v.isVisited)) {
                    bestEdge = edge;
                    v.dist = edge.weight;
                    edge.to.dist = edge.weight;

                    //System.out.println(edge.to);
                    //System.out.println(vertexMinHeap.getPosition(edge.to));
                    vertexMinHeap.decreaseKey(vertexMinHeap.getPosition(edge.to));
                    //System.out.println(vertexMinHeap.getPosition(edge.to));
                    //System.out.println("");
                }
            }*/


            //System.out.println(bestEdge);
            //if(bestEdge != null){
            //treeDist += bestEdge.weight;
            //bestEdge.to.isVisited = true;
            //edgeTree.add(bestEdge);
            //}

        }

        System.out.println("");
        System.out.println("graph: " + edgeTree);
        for (Edge edge: edgeTree) {
            treeDist += edge.weight;
        }
        System.out.println(treeDist);
    }
}
