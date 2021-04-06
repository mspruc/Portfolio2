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
        int mst = 0;
        MinHeap<Vertex> vertexMinHeap = new MinHeap<>();

        for (Vertex v : vertices){
            vertexMinHeap.insert(v); //send all vertices to the minheap
        }

        Vertex v1 = vertices.get(0);
        v1.dist = 0;

        while (!vertexMinHeap.isEmpty()){
            Vertex smallest = vertexMinHeap.extractMin();

            System.out.println("Analysing vertex: " + smallest);

            Edge bestEdge = null;
            for (Edge edge : smallest.OutEdges) {
                //System.out.println(edge + " " + edge.to.dist);
                if(edge.weight < edge.to.dist){
                    if(!edge.to.isVisited) {
                        System.out.println("Replacing: " + bestEdge + " with: " + edge);
                        edge.to.dist = edge.weight;
                        bestEdge = edge;
                        vertexMinHeap.decreaseKey(vertexMinHeap.getPosition(edge.to));
                        edgeTree.add(bestEdge);
                        mst+=bestEdge.weight;
                        bestEdge.from.isVisited = true;
                    }
                }
            }
            if(bestEdge != null){
                System.out.println("picked edge: " + bestEdge);}
            System.out.println(" ");
        }
        System.out.println(mst);
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
