import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Importer {
    String fileName = "";
    FileReader fileReader;

    public Importer(String fileName) {
        try {
            HashMap<String, Boolean> isReached = new HashMap<>();
            HashSet<String> vertexList = new HashSet<>();
            ArrayList<Edge> tempList = new ArrayList<>();
            fileReader = new FileReader(fileName);
            this.fileName = fileName;
            Scanner scanner = new Scanner(fileReader);
            scanner.nextLine(); //skip first line :)

            while (scanner.hasNext()) {
                String[] splitLine = scanner.nextLine().split(" ");
                Edge edge = new Edge(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]));

                vertexList.add(splitLine[0]);
                vertexList.add(splitLine[1]);
                tempList.add(edge);
            }

            PriorityQueue<Edge> minEdge = new PriorityQueue<>(tempList);

            System.out.println(vertexList);
            for (String string : vertexList) {
                isReached.put(string, false);
            }
            System.out.println(isReached);
            new Graph().findMST(minEdge,isReached);


            //System.out.println(tempList.toString());
            //System.out.println(minEdge.peek());
            //System.out.println(vertexList.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file could not be parsed");
        }
    }
}
