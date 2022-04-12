/*                                      === Left / Right View of Binary Tree === 

Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
Right view of a Binary Tree is set of nodes visible when tree is visited from Right side.

video link -  https://youtu.be/Lcre2oZh5YM

Appraoch - 
1. Use Level Order traversal with queue or recursion 
2. Use hashMap/Array (This way we don’t have to go to each node)

We will be using HashMap, where Key = level or Array with index = level and do InOrder Traversal

we insert lef view node in array/hashmap based on index/level. 
If Left == null we go to right node and check if at that level any node is present in the array or hashmap if yes move to next level else insert right node.


        4 
       / \
      7    6
            \
              2
             / \
            5   1
               / 
              3 
 
Left View is - 4, 7, 2, 5, 3              
Right View is - 4, 6, 2, 1, 3

 Do IN ORDER TRAVERSAL for this 

we will make left view fuction and a util function that will recursive for traversal
list.get(level) == null will give index out of bound error use condition list.size() == level
Or use hashmap to avoid this.
*/

package Tree;
import java.util.*;
public class Left_RightViewBT {
    static Scanner sc = null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node parentNode = creatTree();

        printLeftView(parentNode);
        System.out.println();
        printRightView(parentNode);
    }
    // Left View of Binary Tree
    static void printLeftView(Node root){
        HashMap<Integer,Integer> hm =  new HashMap<>();     // key = level, value = node data
        leftViewUtil(root, hm, 0);
        System.out.println("Left View is : ");
        for(Map.Entry m : hm.entrySet()){    
            System.out.print(m.getValue()+" ");    
        }
    }
    // util function for Left view 
    static void leftViewUtil(Node root, HashMap<Integer,Integer> hm, int level){
        if(root == null) return;
        // check if there is any node on that index for that level
        if(hm.get(level) == null){
            hm.put(level,root.data);
        }
        leftViewUtil(root.left, hm, level+1);
        leftViewUtil(root.right, hm, level+1);
    }

    // Right View of Binary Tree
    static void printRightView(Node root){
        HashMap<Integer,Integer> hm =  new HashMap<>();
        rightViewUtil(root, hm, 0);
        System.out.println("Right View is : ");
        for(Map.Entry m : hm.entrySet()){    
            System.out.print(m.getValue()+" ");    
        }
    }

    // util function for Left view 
    static void rightViewUtil(Node root, HashMap<Integer,Integer> hm, int level){
        if(root == null) return;
        // check if there is any node on that index for that level
        if(hm.get(level) == null){
            hm.put(level,root.data);
        }
        rightViewUtil(root.right, hm, level+1);
        rightViewUtil(root.left, hm, level+1);
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

