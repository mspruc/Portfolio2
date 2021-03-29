import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MatrixGraph {
    //int[][] matrixegdegraph;
    //int[][] matrixweightgraph;
    ArrayList<Edge> edges;
    ArrayList<Vertex> vertices;
    MatrixGraph(ArrayList<Edge> edges, ArrayList<Vertex> vertices) {
        this.edges = edges;
        this.vertices = vertices;
       //matrixegdegraph   = new int[vertices][vertices];
        //matrixweightgraph = new int[vertices][vertices];
    }

    public void addEdge(int from, int to, int weight) {
        //matrixegdegraph[from][to]=1;
        //matrixweightgraph[from][to]=weight;
    }

    public void MSTPrims(){
        //int[] Distance    = new int[matrixegdegraph.length];
        int[] predecessor = new int[edges.size()];
        boolean[] visited = new boolean[edges.size()];
        MinHeap<Vertex> Q   = new MinHeap<>();
        PriorityQueue<Vertex> PQ = new PriorityQueue<>(); // offer (add) poll (extactmin)

        //Arrays.fill(Distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor,-1);
        Arrays.fill(visited,false);

        //if (matrixegdegraph.length>0) Distance[0]=0;

        for (Vertex vertex: vertices)
        {
            Q.Insert(vertex);
        }

        int MST=0;
        while(!Q.isEmpty()){
            Vertex u = Q.extractMin();
            for(int v=0;v<edges.size()-1;v++){
                if(edges.get(v).weight<vertices.get(v).dist)
                {
                    if(!visited[v]) {
                        vertices.get(v).dist = edges.get(v).weight;
                        predecessor[v] = vertices.indexOf(u); //TODO find a better index
                        int pos = Q.getPosition(vertices.get(v));
                        Q.decreaseKey(pos);
                    }
                }
            }
            MST+=vertices.get(vertices.indexOf(u)).dist;
        }

        System.out.println("Minimum spanning tree Dsitance: " +MST);

        //for(int i=0; i< matrixegdegraph.length;i++)
        //{
        //    System.out.println(" parent "+ predecessor[i] + " to " + i + " EdgeWeight: " + Distance[i]);
        //}
    }

}

class Pair implements Comparable<Pair>{
   Integer distance;
   Integer index;

   public Pair(Integer distance, Integer index){
       this.distance=distance;
       this.index = index;
   }

   @Override
   public int compareTo(Pair p){
       return this.distance.compareTo(p.distance);
   }
}