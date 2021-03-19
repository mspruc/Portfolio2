import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Importer {
    String fileName = "";
    FileReader fileReader;

    public Importer(String fileName) {
        try {
            HashSet<String> testSet = new HashSet<String>();
            PriorityQueue<Edge> test = new PriorityQueue<>();
            fileReader = new FileReader(fileName);
            this.fileName = fileName;
            Scanner scanner = new Scanner(fileReader);
            scanner.nextLine(); //skip first line :)
            while (scanner.hasNext()) {
                String[] splitLine = scanner.nextLine().split(" ");
                Edge edge = new Edge(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]));

                testSet.add(splitLine[0]);
                test.add(edge);
            }

            ArrayList<Vertex> tempList = new ArrayList<>();

            for (String string : testSet) {
                Vertex vertex = new Vertex(string, null);
                tempList.add(vertex);
            }

            //System.out.println(tempList.toString());
            //System.out.println(test.peek());
            //System.out.println(testSet.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file could not be parsed");
        }
    }
}
