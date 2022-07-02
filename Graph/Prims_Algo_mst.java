/*              === Prim's Algorithm ===
https://youtu.be/kXiqvMykeJA
*/
package Graph;
import java.util.*;
public class Prims_Algo_mst {
    static ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    // on 0th index we will have vertex pair and on 1st index we will have weight
    // can also use adj matrix
    static int PrimsAlgo(int V){

        boolean vis[] = new boolean[V];

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));     // vertex, weighted distance sum
        int ans =0;
        while(q.size()!=0){
            Pair curr = q.remove();

            int u = curr.v;
            if(vis[u]){
                continue;  // means already in minimum spanning tree / queue
            }
            ans += curr.wt;
            vis[u] = true;
            // getting neighbors of vertex u 
            ArrayList<ArrayList<Integer>> neigh = adj.get(u);

            for(ArrayList<Integer> list : neigh){
                int vertex = list.get(0);
                int wt = list.get(1);
                if(vis[vertex] == false){
                    q.add(new Pair(vertex, wt));
                }
            }
        }
    }




    class Pair implements Comparable<Pair>{
        int wt;
        int v;
        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Pair that){
            return this.wt - that.wt;
        }
    } 
    //=======================================
    public static void main(String[] args) {
        int V = 6;
       
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

        System.out.println(PrimsAlgo(V));
    }
    
    static void addEdge(int source, int dest){
        adj.get(source).add(dest);
    }
}
