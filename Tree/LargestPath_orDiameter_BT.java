/*      Largest Path between twp leaf Nodes 
===                or                        ===
.        Diameter of Binary tree  
                    
video link - https://youtu.be/Toe0UQMWhjM

Using recursion
Method 1 => O(n2) - 
we go to each sub tree and run a funtion that will return the diameter of left and right side
then we do int curr =(1 + height of left + height of right) . And return max values between curr, 
diameter of left and diameter of right.
Basically we are going in a subtree callig height func  then again going in a subtree to call height func.
hence giving O(n2).


Method 2 => O(n) [Efficient]

We just Modify the height function of the binary tree, we will add one line only
which is ans = Math.max(ans, lh+rh+1) which will give us the diameter also.
*/

package Tree;
import java.util.*;
public class LargestPath_orDiameter_BT {
    static Scanner sc = null;
    static int dia = 0;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node parentNode = creatTree();
        Diameter( parentNode);
        System.out.println("The Diameter/longest path is " + dia);
    }
    
    
    // the modified height function to find Diameter
    static int Diameter( Node root){
        if( root == null ) return 0;

        // find height of left and right side
        int lh = Diameter(root.left);
        int rh = Diameter(root.right);

        //finding diameter i.e. the line which modified height func
        dia = Math.max( dia, 1+lh+rh);
        return 1+Math.max(lh,rh); 
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
