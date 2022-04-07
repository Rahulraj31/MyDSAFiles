/*         ===  Height  and Size of a Binary Tree ===

      1
     / \
    2   3
   / \  
  4   5
      /
     6
     
 Now if we see here if our node is null we return zero else
 We need to find height of left side of node and right side 
 of node and find max of height of left and right and add 1
 to it (root node).


=== Size === 
 Size means finding the number of nodes in a binary tree 
 we will find recursivly , if node = null return zero 
 else return size(left subtree) + size(right subtree) + 1 which is that node)
*/


package Tree;
import java.util.*;
public class Height_Size_BinaryTree {
    static Scanner sc = null;
    public static void main(String[] args) {
        sc= new Scanner(System.in);
        Node parentNode =creatTree();

        int height = height(parentNode); 
        int size = size(parentNode);

        System.out.println("Height of the Binary Tree is " + height);
        System.out.println("Size of the Binary Tree is " + size);
    }
    
    // Function to Find Height of tree
    public static int height(Node root){
        if( root == null )
            return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;           
    }
    public static int size(Node root){
        if( root == null )
            return 0;
        
        return (size(root.left) + size(root.right) + 1);           
    }

//------------------------------------
    // creating tree
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
