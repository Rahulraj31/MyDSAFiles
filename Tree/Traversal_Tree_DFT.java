/*      === Tree Traversal  Depth-First===

Traversal Can be done in 3 types 
    1. Inorder -     <L N R>
    2. Pre Order -   <N L R>
    3. Post Order -  <L R N>

    L- left node , N- Root node, R - right node
These 3 are types of Depth-First-Traversal, There is another type called Breadth First or Level Order Traversal which is commonly used for searching    

*/
package Tree;
import java.util.*;
public class Traversal_Tree_DFT {
    static Scanner sc = null;
    public static void main(String[] args) {
        sc= new Scanner(System.in);
        Node parentNode =creatTree();
        System.out.print("Inorder traversal : ");
        inOrder(parentNode);
        System.out.print("\nPreorder traversal : ");
        preOrder(parentNode);
        System.out.print("\nPostorder traversal : ");
        postOrder(parentNode);
    }

    // ===  Traversals === 1
    static void inOrder(Node root){
        if(root == null) return;

        // outputing
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }
    static void preOrder(Node root){
        if(root == null) return;
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);     
        postOrder(root.right);
        System.out.print(root.data + " ");
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
