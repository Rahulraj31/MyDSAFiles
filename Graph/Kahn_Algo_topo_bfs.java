/*           === kahn Algorithm or Topological Sort using BFS for DAG ===
 https://youtu.be/XMiIk1B0v-w

 WE will use queue. First we will find number of edges incoming to a vertex. Then we will add the vertex with 
 0 incoming edges. Then we run a while loop untill a queue is empty then we pop the element and subtract 1 in all the neighbor
 vertices incoming edge count and then again add all the neighbors with 0 count. For maintaing the count we will declare an array inDeg
 storing the count.
 
 */
package Graph;
import java.util.*;

public class Kahn_Algo_topo_bfs {
    public static int inDeg[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
    public static ArrayList<Integer> kahnAlgo(int V){
        for(ArrayList<Integer> list : adj){
            for(Integer e : list){
                inDeg[e]++;
            }
        }
        boolean vis[] = new boolean[V];
        ArrayList<Integer> ansList = new ArrayList<>();

        bfs_util(V, vis, ansList);
        return ansList;
    }

    static void bfs_util(int V,boolean[] vis, ArrayList<Integer> ansList){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ;i<V; i++){
            if( inDeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            ansList.add(cur);
            for(int neighbor : adj.get(cur)){
                inDeg[neighbor]--;
                if(inDeg[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
    }



    //=======================================
    public static void main(String[] args) {
        int V = 6;
        inDeg = new int[V];
        for(int i=0; i<V; i++){
            adj.add( new ArrayList<>());
        }
        addEdge(0, 3);
        addEdge(0, 2);
        addEdge(1, 4);
        addEdge(2, 1);
        addEdge(2, 3);
        addEdge(3, 1);
        addEdge(5, 1);
        addEdge(5, 4);

        System.out.println(kahnAlgo(V));
    }
    
    static void addEdge(int source, int dest){
        adj.get(source).add(dest);
    }
}