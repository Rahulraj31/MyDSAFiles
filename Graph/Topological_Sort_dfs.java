/*                        === Topological Sort ===

Application of DFS 
https://youtu.be/Zbbe9FYVnM4
*/

package Graph;
import java.util.*;
public class Topological_Sort_dfs {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static int[] topoSort(int V){
       boolean visi[] =  new boolean[V];
       Stack<Integer> stack = new Stack<>();

       // for disconnected components
       for (int vertex = 0; vertex < V; vertex++) {
            if(!visi[vertex]){
                dfs_topo(vertex, visi, stack);
            }
        }
        int[] ans = new int[V];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
    static void dfs_topo(int v, boolean visi[], Stack<Integer> stack ){
        visi[v] =true;

        for(Integer neighbor : adj.get(v)){
            if(!visi[neighbor]){
                dfs_topo(neighbor, visi, stack);
            }
        }
        stack.push(v);
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

        int[] ans = topoSort(V);
        System.out.print(Arrays.toString(ans));
    }
    
    static void addEdge(int source, int dest){
        adj.get(source).add(dest);
    }
}
