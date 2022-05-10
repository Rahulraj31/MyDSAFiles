/*          Reversing Linked List Recursion and Iterative

Google Amazon
Leetcode Question - https://leetcode.com/problems/reverse-linked-list/
Video Solutions - [1:47:28] https://www.youtube.com/watch?v=70tx7KcMROc&t=6199s
*/

package LinkedList;

public class Reversing_LL {

// printing recursively
     public void recurReverse(Node node){
         if(node.next!=null ){
             head=tail;
            return;
         }
         recurReverse(node.next);
         tail.next=node;
         tail=node;
         tail.next=null;
     }
	public void  iterReverse(Node head){
        if(head==null){
            return head;
        }      
        Node curr = head;
        Node prev = null;
        Node after = curr.next;
             
        while(curr!=null){     // means prev will go till last element     
            curr.next = prev;  // changing the direction of arrow
            prev = curr;
            curr = after;
            if(after != null){ //  null pointer exception  check for after
                after = after.next;
            }
        }       
        head = prev;
        return head;
    }	
}

