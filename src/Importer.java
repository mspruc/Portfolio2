import org.w3c.dom.xpath.XPathResult;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Importer {
    String fileName = "";
    FileReader fileReader;
    public HashMap<String, Vertex> nameToVertex = new HashMap<>(); //map from town name to specific vertex.
    ArrayList<Edge> edges = new ArrayList<>(); //list of all edges.

    public Importer(String fileName) {
        try {
            fileReader = new FileReader(fileName);
            this.fileName = fileName;
            Scanner scanner = new Scanner(fileReader);
            scanner.nextLine(); //skip first line :)

            while (scanner.hasNext()) {
                String[] splitLine = scanner.nextLine().split(" "); //parse data into 3 categories v1,v2,dist
                String from = splitLine[0]; //first town in the data
                String to = splitLine[1]; //second town
                int cost = Integer.parseInt(splitLine[2]); //distance between towns

                fetchNewTown(nameToVertex, from); //check if the town is saved, if not save it
                fetchNewTown(nameToVertex, to); //

                Edge edge = new Edge (nameToVertex.get(from),nameToVertex.get(to),cost); // create an edge between the 2 towns fetched from the map
                Edge edge2 = new Edge (nameToVertex.get(to),nameToVertex.get(from),cost); //bidirectional

                edges.add(edge); //add the edge to a list of edges
                edges.add(edge2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file could not be parsed");
        }

        System.out.println(nameToVertex.toString());
    }

    private void fetchNewTown(HashMap<String, Vertex> nameToVertex, String v) {
        if (nameToVertex.get(v) == null) { //if the first parsed town doesnt exist in the nameToVertex map
            Vertex v1 = new Vertex(v); //add the vertex to the graph
            nameToVertex.put(v1.name, v1); //add the vertex and its name to the map
        }
    }
}
