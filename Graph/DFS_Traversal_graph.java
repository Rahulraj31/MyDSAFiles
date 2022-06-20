package Graph;
import java.util.*;
public class DFS_Traversal_graph {
    public static void main(String[] args) {
        int n_vertex = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i=0; i<n_vertex; i++){
            adj.add( new ArrayList<>());
        }
        // make adj list via calling add edge function.
        boolean vis[] = new boolean[n_vertex];
        // to store path of traversal
        ArrayList<Integer> ans= new ArrayList<>(); 
        
        // use this loop to visit all connected unconnected vertices and to count no. of unconnected graph
        for(int i=0; i<n_vertex; i++){        
            dfs(i, adj, vis, ans);  
        }
     
    }
    public static void dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean vis[], ArrayList<Integer> ans ){
        vis[v] = true;  //starting vertex
        ans.add(v);
        for(Integer neighbor : adj.get(v)){
            if(!vis[neighbor]){
                dfs(neighbor, adj, vis, ans);
            }
        }
    }
}
/*  ====     Making Graph  ====


public class Graph
{   private static int V;
    static LinkedList<LinkedList<Integer>> adj = new LinkedList<>() ;
    Graph(int v){
        V = v;
        for (int i = 0; i < v; i++)
            adj.add(new LinkedList<>());
    }
    
    static void addEdge(int v, int w)
    {
        adj.get(v).add(w); // Add w to v's list.    // it is making directed grapg for now 
    }
 public static void main(String[] args) {
		Graph g =new Main(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
       for(int i=0; i<4; i++){
        for(Integer neighbor : g.adj.get(i)){
            System.out.print( neighbor);
        }
        System.out.println();
       }    
	}   
}
*/