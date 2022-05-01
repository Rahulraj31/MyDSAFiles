/*  Lowest Common Ancestor in a Binary Tree
video - https://youtu.be/cOjLyASDJcc
https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
  
      5
    2  3
  4 
    1
  7    6
 
now LCA(7,6) =1  LCA(6,4) = 4  LCA(1,3) = 5

Cases :- 1. current Node == a or b
         2. a is in left subtree and b in right
         3. both in same subtree
         4. none of them is present in any subtree


*/

package Tree;
import java.util.*;
public class LowestCommon_AncestorBT {
    static Scanner sc= null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node parent = creatTree();
        int n1 = 1;
        int n2 = 3;
        Node lca = LCA(parent, n1, n2); 
        System.out.println("Lowest Common Ancestor is "+ lca.data);
    }
    // func to return least common ancestor
    static Node LCA(Node root, int n1, int n2){
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);
        
        // if we get null from left side it means n1,n2 are in right and vicaversa
        if(left == null) return right;
        if(right == null) return left;
        // means left and right got the value and root is the LCA
        return root;
    }

//=========================================================================    
    // creating tree (binary in this case)
    static Node creatTree(){
        System.out.println("Enter root node data ");
        int data = sc.nextInt();

        // breaking condition; if entered -1 return null 
        //i.e no need to creat that node
        if(data == -1){
            return null;
        }

        // if not -1 enter data to root node
        Node root = new Node(data);

        // Entering child node data
        System.out.println("Enter left for "+ data);
        root.left = creatTree();
        System.out.println("Enter right for "+ data);
        root.right = creatTree();
        return root;
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
