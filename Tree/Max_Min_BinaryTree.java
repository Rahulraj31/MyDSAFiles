/*  === Min and Max value in a Binary Tree

Concept is to use recusrion and return max/ min value from a sub-tree
i.e root, left and right node value. And if node is null we return 
Intger.Max(+ infinity) in case of min and Integer.Min(- negative) in case of Max values.

Space Complexity => O(h) h= height of tree
Time Complexity => O(n)  n = no of nodes

Note :- In Binary Search Tree, we can find maximum by traversing right pointers until we reach the rightmost node

      1
     / \
    6   7
   / \  
  11   3
      /
     2
  return 11 as ans    
*/

package Tree;
import java.util.*;
public class Max_Min_BinaryTree {
    static Scanner sc = null;
    public static void main(String[] args) {
        sc= new Scanner(System.in);
        Node parentNode =creatTree();

        int min = minValue(parentNode); 
        int max = maxValue(parentNode);

        System.out.println("Min Value of the Binary Tree is " + min);
        System.out.println("Max value of the Binary Tree is " + max);
    }

    // Finding Max Value in a tree
    public static int maxValue(Node root){
        if(root == null){
            return Integer.MIN_VALUE;   // returning smallest possible int value
        }

        int subTreeValue = Math.max(maxValue(root.left), maxValue(root.right));
        
        return Math.max( root.data, subTreeValue);
    }

    // Finding Min Value in a tree
    public static int minValue(Node root){
        if(root == null){
            return Integer.MAX_VALUE;   // returning smallest possible int value
        }

        int subTreeValue = Math.min(minValue(root.left), minValue(root.right));
        
        return Math.min( root.data, subTreeValue);
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
