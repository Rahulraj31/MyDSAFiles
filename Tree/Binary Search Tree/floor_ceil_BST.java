/*          === Floor nd Ceil Value  in BST ===

https://youtu.be/Sgz3SF_0wOw
https://www.geeksforgeeks.org/floor-and-ceil-from-a-bst/#:~:text=Given%20a%20binary%20tree%20and,equal%20to%20the%20key%20value.


        40
    20      60
 10     30

 key= 22 so F =20 and C = 30
 key = 16 so F = 10 and C = 20

Recursion also takes space recusrion uses recursion stack.
Iterative method is way better than Recursion.  
Approach **Brute Force**
Do InOrder traversal we will  get sorted array and then we can use binary search to find floor and ceil.
This approch will use extra space of making array and extra time.

Approach **Optimised**
We will use interation (recursion can be used but iteration takes less time and space).
we are moving down the tree, and assume we are root node. 
    1. If tree is empty, i.e. root is null, return
    2. If current node address is not null
        (a) If current node data == key  
             We have found both our floor and ceil value. 
        (b) current node < key value- 
            We assign the current node data to the variable keeping
            track of current floor value and explore the right subtree,
            as it may contain nodes with values greater than key value.
        (c) If  current node > key  - 
            We assign the current node data to the variable keeping track
            of current ceil value and explore the left subtree, as it may
            contain nodes with values lesser than key value.    


**  Another Code at the end of file **
*/

package Tree.BinarySearchTree;

public class floor_ceil_BST {
    int ceil,floor;
    void floor_ceil(Node root,int key){
        while(root != null){
            if (root.data == key){
                ceil = root.data;
                floor = root.data;
                return;
            } 
            if(key > root.data){
                floor = root.data;
                root = root.right;
            }
            else{ //key < root.data
                ceil = root.data;
                root = root.left;
            }
        }
        return;
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

/*
  int floor(Node root, int key){
      int ans = Integer.MAX_VALUE
      while(root != null){
          if (root.data == key){
                return root.data;;
            } 
            if(key > root.data){
                ans = root.data;
                root = root.right;
            }
            else{ //key < root.data
                root = root.left;
            }
      }
  }

*/