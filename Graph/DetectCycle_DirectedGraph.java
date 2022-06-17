/*              === Detecting Cycle in Directed Graph ===

Again we use DFS. The concept used for undirected graph is not applicable here.

For Eg :-   0 -> 1 <- 2 
Now for vertex 2 parent vertex would be -1(New DFS recursive stack is started) and next is 1 . Hence the concept will show cycle is present 
even though it's not. 

Hence here we use two arrays 1. visited array 2. rescur array which will tell us which all vertexs are in
same recursive call func stack. 
Eg 
               0 -> 1 <- 2 <-- 
                         |    |
                         v    |
                         3 -> 4

So here there would be 2 different recursive function call stack 
 1.  dfs(0) -> dfs(1)
 2.  dfs(2) -> dfs(3) -> dfs(4) -> dfs(2)

Now in second stack 2 is reached again and all vertex are in same call function 
stack hence cycle is detected 
 
Note :-  We are not using stack here we are using array to show all the vertex that function will be called 
recursively while compiling in recursive stack;                       

https://youtu.be/GLxfoaZlRqs
 */
package Graph;

import java.util.*;

public class DetectCycle_DirectedGraph {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
    static boolean isCycle(int V) {
        boolean []visited = new boolean[V];
        boolean []recS = new boolean[V];  // recursion stack; storing vertex that are visited within this stack

        for (int vertex = 0; vertex < V; vertex++) {
            if(!visited[vertex]){
                if( dfs(vertex, visited, recS ) )
                    return true;
            }
        }
        return false;
    }
    
    static boolean dfs(int vertex, boolean []visited, boolean []recS){
        visited[vertex] = true;
        recS[vertex] = true;

        for (Integer neighbor : adj.get(vertex)) {
            if( !visited[neighbor]){
                if( dfs(neighbor, visited, recS)) //  and if there is a cycle return true
                   return true;
            }
            else if(recS[neighbor]) //  if  element is visited check if it is in recS array
                return true;
        }
        // Now recursion is over so we undo the changes(backtrack concept) so that for the next Iteration
        // from isCycle for loop our recS can be used again for different components.
        recS[vertex] =false;

        return false;
    }
    
    
    
    
//=======================================
    public static void main(String[] args) {
        int V = 5;
        for(int i=0; i<V; i++){
            adj.add( new ArrayList<>());
        }
        addEdge(0, 1);
        addEdge(2, 1);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 2);

        System.out.print(isCycle(V));
    }
    
    static void addEdge(int source, int dest){
        adj.get(source).add(dest);
    }
}
 