/*      === BFS Traversal, Breadth First Search in Graph ===

Uses :- 
1. traversal and searching
2. Find minimum distance between source and point
3. Find Number of connected components

*/

package Graph;
import java.util.*;

import javax.swing.border.LineBorder;
public class BFS_Traversal_graph {
    public static void main(String[] args) {
        int v = 5;    // vertices
        int e = 10;   // edges  
        // adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        // initialising inner list
        for(int i=0; i<v; i++){
            adj.add( new ArrayList<>());
        }

        // Either adj list will be given or u need to take from user input

        // To check Number of component array, Check if element is false in visited array
        // and run bfs func that many time unless whole array is True, we know in java 
        // arrays are passed as reference in func(as array is object in java) hence any change
        // thoughout will be reflected in the original array
        boolean vis[] = new boolean[v];
        int pred[] = new int[v];
        int dist[] = new int[v];

        int components = 0;  // counter variable
        for(int i=0; i<v; i++){
            if(!vis[i]){
                components++;
                bfs(adj,1,6,v,pred,dist,vis);
            }
        }
    }

// In this function we will see all the concepts

    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, int dest,int v, int pred[], int dist[]){
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean visited[]  = new boolean[v];

        for(int i=0; i<v; i++){
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;  //predecessor array
        }

        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        while(!queue.isEmpty()){
            int curr = queue.poll(); 
            for(int i=0; i<adj.get(curr).size(); i++){
                int ngh  = adj.get(curr).get(i);  // getting neighbor or connected elements
                if(visited[ngh] == false){
                    visited[ngh] = true;
                    dist[ngh] = dist[curr]+1;
                    pred[ngh] = dist[curr];
                    queue.add(ngh);

                    if(ngh == dest)    
                        return true;
                    // same IF block can be used for searching  
                    // Can also check path using predecessor array 
                }
            }
        }

        return false;
    }
}
