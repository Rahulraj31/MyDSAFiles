/*      ===  Search a node in Binary Search Tree ===

https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
package Tree.BinarySearchTree;
import java.util.*;
public class SearchBST {
    public Node searchBST(Node root, int val) {
        
        if(root == null){
            return null;
        }
        else if(root.val == val){
            return root;
        }
        
        // As it is BST elements are in sorted manner i.e so if element is greater than target we got left else we go right
        else if(root.val > val){
            return searchBST(root.left,val);
        }
        return searchBST(root.right, val);
        
    }
}
