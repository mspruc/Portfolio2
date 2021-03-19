import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.management.GarbageCollectorMXBean;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Importer {
    String fileName = "";
    FileReader fileReader;

    public Importer(String fileName) {
        try {
            PriorityQueue<Edge> test = new PriorityQueue<>();
            fileReader = new FileReader(fileName);
            this.fileName = fileName;
            Scanner scanner = new Scanner(fileReader);
            scanner.nextLine(); //skip first line :)
            while (scanner.hasNext()) {
                String[] splitLine = scanner.nextLine().split(" ");

                Edge edge = new Edge(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]));

                test.add(edge);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file could not be parsed");
        }
    }
}
