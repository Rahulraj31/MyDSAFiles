/*      === Check if a tree is BST ===

https://youtu.be/9btwHI_84DM
https://leetcode.com/problems/validate-binary-search-tree/

Method 1 Recursive Inorder Traversal
Do inorder traversal and make a pointer prev now always check that current node should be less than prev
and return false if it is not

Method 2 Recursive Traversal with Valid Range
The idea above could be implemented as a recursion. One compares the node value with its upper and lower limits 
if they are available. Then one repeats the same step recursively for left and right subtrees.
means parent node should be upper bound for Left child (-infinity, parent node) and for Right it should be lower bound
(parent node,infinity)
*/

package Tree.BinarySearchTree;

public class check_if_BST {
//                   ===  Method 2  ===
    boolean isBST2(Node root){
        return isBSTutil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTutil(Node node, int min, int max){
        if (node == null) return true;

        if (node.data < min || node.data > max) return false;

        return( isBSTutil(node.left, min, node.data) &&       
        isBSTutil(node.left, node.data, max));
    }


//    ======= === Method 1 === =========

Node prev = null;
    boolean isBST1(Node node){
        if ( node != null){
            if( !isBST1(node.left))
                return false;
            if (prev != null && node.data <= prev.data)
                return false;
            
            prev = node;
            return isBST1(node.right);    
        }
        
        return true;
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
