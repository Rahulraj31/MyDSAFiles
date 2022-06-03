/*                  === Delete a Node in BST ===

https://youtu.be/petKaikRiIA
https://leetcode.com/problems/delete-node-in-a-bst/

There can be 3 cases
CASE- 1 Both Left and Right of Node is null <Leaf Node>
CASE- 2 Either Left or Right of Node is null

now both case can be solved easily, solving case 2 alone solves case 1

CASE- 3  Both Left and Right are non-null i.e both have Subtree
Then we can either replace the deleted node with left side greatest element or 
right side smallest element.
We do know InOrder traversal of BST gives sorted array. 
So we either replace the deleted node with Inorder predecessor or Inorder successor.

So here we will go with Inorder successor. replace it with deleted node and then delete the sucvessor 
from it's original location and left of inorder successor is always null

*/

package Tree.BinarySearchTree;

public class deleteNodeBST {
    
    Node deleteNode(Node root, int key){
        if( root == null) return root;

        if(key < root.data)
            root.left = deleteNode(root.left, key);
        else if( key > root.data)
            root.right = deleteNode(root.right, key);
        
        // when key == value    
        else{
            // when the node is leaf node Case 1 or Case 2
            if ( root.left == null)
                return root.right;
            else if ( root.right == null)
                return root.left;   
            // if both left anf right are not null i.e contains a subtree
            root.data = minValue(root.right);
            
            root.right = deleteNode(root.right, root.data); //deleting from original position
        }  
        return root;      // returning modified BST
    }

    // func to find min value in right subtree for In-order traversal
    int minValue(Node root){
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
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
