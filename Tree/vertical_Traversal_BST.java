/*          === Print the Vertical Order Traversal of a Binary Tree ===

https://youtu.be/h7xALnzllec
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

          1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
                           
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9

Get the minimum and maximum horizontal distance with respect to root

Method 1 => O(n2) =>  https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
Once we have maximum and minimum distances from root, we iterate for each vertical line at distance 
minimum to maximum from root, and for each vertical line traverse the tree and print the nodes which 
lie on that vertical line.

Method 2 => Efficient O(nLogn) => HashMap
https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

We need to check the Horizontal Distances from the root for all nodes. 
If two nodes have the same Horizontal Distance (HD), then they are on the same vertical line. 
The idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree) 
is considered as +1 horizontal distance and a left edge is considered as -1 horizontal distance. 
For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 
and HD for node 7 is +2. We can do BFS traversal of the given Binary Tree. While traversing 
the tree, we can iteratively calculate HDs

Map would be key = HD and value = array list of values
*/

package Tree;
import java.util.*;
public class vertical_Traversal_BST {
    
    static void verticalOrder(Node root){
        Queue<Pair> q = new ArrayDeque<>();  // pair is of hd and node
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();  // so that it is key wise sorted

        q.add(new Pair(0,root));   // here root is parent Node of BST
        while( !q.isEmpty()){
            Pair cur = q.poll();
            // check if current value of HD is present in map 
            // if true add node data else add both hd and node data
            if(map.containsKey(cur.hd)){
                map.get(cur.hd).add(cur.node.data);  
                // read if from left to right unlike python
            }
            else{ // make array list ; add node data in it and then put into map
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(cur.node.data);
                map.put(cur.hd, temp);
            }

            // Left side traversal
            if(cur.node.left != null){
                // creat a pair add to queue
                Pair tempPair = new Pair( cur.hd -1, cur.node.left);
                q.add(tempPair);
            }
            // Right Side Traversal
            if(cur.node.right != null){
                // creat a pair add to queue
                Pair tempPair = new Pair(cur.hd + 1, cur.node.right);
                q.add(tempPair);
            }
        }    
            //ArrayList<Integer> ans = new ArrayList<>();
            for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
                //ans.addAll(entry.getValue()); to return an arrayof values
                System.out.println(entry.getValue());
            }
    }


    // pair template
    static class Pair{
        int hd;
        Node node;
        public Pair(int hd, Node node){
            this.node = node;
            this.hd = hd;
        }
    }
    // Node Template
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
        }
        
    }
}
