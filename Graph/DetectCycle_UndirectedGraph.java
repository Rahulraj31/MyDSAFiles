/*              === Detecting Cycle in Undirected Graph ===

https://youtu.be/UPfUFoWjk5w
We implement DFS traversal here. 
The concept here is similar to the detection of cycle in LL if a node appears 
twice while traversing we say there is a cycle.
Because It's undirected we need to maintain a variable that we will tell us 
the parent node or node visited before the current node so as to exclude a case where the previous node is traversed
and considered as cycle even though it's not

V -. no of vertices
*/

package Graph;
import java.util.*;
public class DetectCycle_UndirectedGraph {
    int parent = -1;
    // can declare adj list here also then no need to pass it in every function;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];

        // for loop for unconnected component of part that may also contain cycle
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i=0; i<V; i++){
            if( !vis[i]){
                if( dfs(i, adj, vis, parent))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs( int ver, ArrayList<ArrayList<Integer>> adj, boolean vis[], int parent){
        vis[ver] = true;
        for(Integer neighbor : adj.get(ver)){
            if(!vis[neighbor]){   // if neighbor vertex not visited
                if(dfs(neighbor, adj, vis, ver)){
                    return true;
                }
                else if(neighbor != parent){// if neighbor  vertex visited
                    return true;
                }
            }
        }
        return false;
    }
    /*
    public static void main(String[] args){
        int V = 4; 
        for(int i=0; i<v; i++){
            adj.add( new ArrayList<>());
        }
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);

        isCycle(V, adj);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest){
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }
    */
}
