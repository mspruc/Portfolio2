import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Importer dataGirl = new Importer("src/data");

        AdjacencyGraph adjacencyGraph = new AdjacencyGraph();

        for (Map.Entry<String, Vertex> stringVertexEntry : dataGirl.nameToVertex.entrySet()) { // for every entry in the nametovertex hashmap
            adjacencyGraph.addVertex(stringVertexEntry.getValue()); //fetch the value from the key-value pair which is a vertex and add it to the adjacency graph
        }

        MatrixGraph matrixGraph = new MatrixGraph(dataGirl.edges,adjacencyGraph);
        matrixGraph.mst3();
        System.out.println(matrixGraph.edgeTree.toString());
    }
}
