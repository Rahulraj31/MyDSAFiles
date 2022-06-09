/* === Inserting a Node in BST  Iterative and Recursive===
 https://youtu.be/jQS5IC9Gmm0
 https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
 
Recursive - Time - O(h) h is height O(LogN) avg
            Space - O(h)

Iterative has better space complexity O(N)
*/

package Tree.BinarySearchTree;
import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class insertionBST {
    Node insertRecur(Node root, int key){
        if (root == null) return new Node(key);
        if(root.data > key){
            root.left = insert(root.left,key);
        }
        else if (root.data < key){
            root.right = insert(root.right,key);
        }
        
        return root;
    }

    Node insertIterative(Node root, int key){
        Node newNode = new Node(key);
        Node curr = root;
        Node parent = null;
        // traverse in BST ; at last curr will be null
        while(curr != null){
            parent = curr;
            if(key < curr.data) curr = curr.left;
            else  curr = curr.right;
        }
        // if given BST is only null
        if(parent == null){
            parent = newNode; 
            return parent;
        }       
        else if (key < parent.data)
            parent.left = newNode;
        else   
            parent.right = newNode;  

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
