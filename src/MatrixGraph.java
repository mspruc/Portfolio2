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

    public void mst3(){
        int mst = 0;                                         //init the length of the mst.
        MinHeap<Vertex> vertexMinHeap = new MinHeap<>();     //init min heap
        for (Vertex v : vertices) vertexMinHeap.insert(v);   //send all vertices to the minheap
        Vertex v1 = vertices.get(0);                         //fetch the first arbitrary vertex
        v1.dist = 0;                                         //set the dist to zero so it is the first vertex to be found by the minheap
        ArrayList<Edge> discoveredEdges = new ArrayList<>(); //add all the out edges to a list of all discovered out edges

        while (!vertexMinHeap.isEmpty()){                 //so long as the heap is not empty
            Vertex smallest = vertexMinHeap.extractMin(); //we fetch the vertex with the smallest dist.
            Edge bestEdge = null;                         //init the best edge for the vertex to pick
            discoveredEdges.addAll(smallest.OutEdges);    //add all the edges from the vertex to a list of discovered edges.

            for (Edge edge : discoveredEdges) { //scan through all the discovered edges
                System.out.println("Analysing edge: " + edge + " with: " + bestEdge + " saved vertex to.dist: " + edge.to.dist);
                if(edge.weight <= edge.to.dist && (bestEdge == null || edge.weight < bestEdge.weight) && !edge.to.isVisited){
                    bestEdge = edge;            //set the edge that passes the conditionals to be the best edge
                    edge.to.dist = edge.weight; //update the dist in the vertex we are travelling to.
                }
            } //when the forloop ends we should have the best edge to pick saved in bestEdge.

            if(bestEdge != null){
                vertexMinHeap.decreaseKey(vertexMinHeap.getPosition(bestEdge.to)); //decrease the key in the heap for the to-vertex.
                bestEdge.to.isVisited = true;                                      //it is now visited
                edgeTree.add(bestEdge);                                            //add the edge to the spanning tree
                System.out.println("picking edge: " + bestEdge);
                System.out.println();
            }
        }

        for (Edge edge : edgeTree) { //sum the weights.
            mst += edge.weight;
        }
        System.out.println(mst);
    }
}
