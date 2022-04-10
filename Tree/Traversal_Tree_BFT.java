/*  ===Tree Traversal  breadth-First===
      5
     / \
    1   7
   / \  
  2   4
     / \
    3   6

Output :- 5,2,7,1,3,6     
video link - https://youtu.be/ICpp88mcB-k
For to do this in O(n) we use queue data structure, we will make Queue of Node i.e
Queue<Node> q = new LinkedList<>()

Now we are asked either to present output in line(1,2,3,4,5) or as tree
5
1 7
2 4
3 6
So we print output by both methods   
*/


package Tree;
import java.util.*;
public class Traversal_Tree_BFT {
    static Scanner sc = null;
      public static void main(String[] args) {
        sc= new Scanner(System.in);
        Node parentNode =creatTree();

        bft_inline_output(parentNode);
        System.out.println("----");
        bft_treelike_output(parentNode);
    }
// Traversal :- prints all node in one line
     static void bft_inline_output(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while( !q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if(curr.left != null){
                q.add(curr.left);   
            }
            if(curr.right != null){
                q.add(curr.right);   
            }
        }
    }
// Traversal :- prints node level wise in new line
    static void bft_treelike_output(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);  // null will tell when new level is introduced

        while( !q.isEmpty()){
            Node curr = q.poll(); 
            if(curr == null){
                if(q.isEmpty())
                    return;
                q.add(null);
                System.out.println();
                continue;    
            }
            System.out.print(curr.data + " ");

            if(curr.left != null){
                q.add(curr.left);   
            }
            if(curr.right != null){
                q.add(curr.right);   
            }
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
