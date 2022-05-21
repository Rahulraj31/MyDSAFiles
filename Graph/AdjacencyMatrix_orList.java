/*      === Adjacency List and Matrix ===

making for undirected
no of edges and vertices would be given

Adj List is Integer Arraylist of ArrayList
*/

package Graph;

import java.util.ArrayList;

public class AdjacencyMatrix_orList {
    
    public static void main(String[] args) {
        int v = 5;    // vertices
        int e = 10;   // edges  

        // adj. matrix
        int[][] a= new int[v][v];
        // adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        // initialising inner list
        for(int i=0; i<v; i++){
            adj.add( new ArrayList<>());
        }
    }
    static void addEdge(int[][]a, int source, int dest){
        a[source][dest] = 1;
        a[dest][source] = 1;
    }
    
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest){
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }

}
