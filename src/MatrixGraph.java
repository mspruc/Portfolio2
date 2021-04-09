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
        int mst = 0;                                       //init the length of the mst.
        MinHeap<Vertex> vertexMinHeap = new MinHeap<>();   //init min heap
        for (Vertex v : vertices) vertexMinHeap.insert(v); //send all vertices to the minheap
        Vertex smallest = vertexMinHeap.extractMin();      //fetch the arbitrary first vertex
        smallest.isVisited = true;                         //set it to be visited

        for (Edge edge : smallest.OutEdges) {                                  //Then init all routes from that vertex
            if(edge.weight <= edge.to.dist){                                   //
                edge.to.dist = edge.weight;                                    //update the dist in the vertex we are travelling to.
                vertexMinHeap.decreaseKey(vertexMinHeap.getPosition(edge.to)); //decrease the key in the heap for the to-vertex.
            }
        }

        while (!vertexMinHeap.isEmpty()){          //so long as the heap is not empty
            smallest = vertexMinHeap.extractMin(); //we fetch the vertex with the smallest dist.
            Edge bestEdge = null;                  //init the best edge for the vertex to pick

            for (Edge edge : smallest.OutEdges) {                                  //scan through all the discovered edges
                if(edge.weight <= edge.to.dist){                                   //
                    edge.to.dist = edge.weight;                                    //update the dist in the vertex we are travelling to.
                    vertexMinHeap.decreaseKey(vertexMinHeap.getPosition(edge.to)); //decrease the key in the heap for the to-vertex.
                }

                if ((bestEdge == null || edge.weight < bestEdge.weight)
                        && ((!edge.to.isVisited && edge.from.isVisited)
                        || (!edge.from.isVisited && edge.to.isVisited))) bestEdge = edge; //set the edge that passes the conditionals to be the best edge

            } //when the forloop ends we should have the best edge to pick saved in bestEdge.

            if(bestEdge != null) {
                edgeTree.add(bestEdge); //add the edge to the spanning tree
                smallest.isVisited = true;
            }
        }

        for (Edge edge : edgeTree) { //sum the weights.
            mst += edge.weight;
        }

        System.out.println(mst);

        System.out.println("Price of stuff: " + mst*100000);
    }
}
