/*   === Flatten a Binary Tree to a Double Linked List In Place===

important concept

Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
Order of Node should be same as InOrder Traversal.
he first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL. 

https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
Video exp = https://youtu.be/nGNoTdav5bQ

We will apply recursion.
So we treat ** Left pointer as previous and right pointer as next.**
We will keep track of previous visited node so as to link that with the current
via prev.right = curr; curr.left = prev and then move previous to next node;

            3
           / \
          5   2
             /
            1
           / \
          4   6

Output :- 5 <=> 3 <=> 4 <=> 1 <=> 6 <=> 2

*/


package Tree;
import java.util.*;
public class BinaryTree2DLL {
    static Scanner sc = null;
    static Node prev = null;
    static Node head=null;
    public static void main(String[] args) {
        sc= new Scanner(System.in);
        Node parentNode = creatTree();
        convert2Dll(parentNode);
        printDLL();  
    }

//flattening
    static void convert2Dll(Node root){
        if(root == null ) return;
        // doing InOrder now
        convert2Dll(root.left);

        if(prev == null) head = root;  //if node is the first node to be visited in the tree
        else{
            // linking previous node with current
            root.left = prev;
            prev.right = root;
        }
        prev=root;
        convert2Dll(root.right);
    }
    
// printing DLL
    static void printDLL(){
        Node temp  = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.right;
        }
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
