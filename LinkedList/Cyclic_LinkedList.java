/*           ===   Linked List Cycle and Length of Cycle ===

Amazon and Microsoft 
Leetcode => https://leetcode.com/problems/linked-list-cycle/
Video So =>[45:40]https://www.youtube.com/watch?v=70tx7KcMROc&t=2629s&ab_channel=KunalKushwaha
 
We use Fast Slow pointer method to find if a list has cycle.
Fast pointer moves 2 block and slow pointer moves 1 block and when 
fast and slow meets at a block/node there is a cycle and if any one 
them becomes null no cycle exist. 

And we also be finding the no. of ele/ length of cycle 
Once fast == slow we again move slow from there  and use a counter to count
until it again becomes fast==slow 
*/

package LinkedList;

public class Cyclic_LinkedList {
    public static void main(String[] args) {
        
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
    // now fast can't be null as it means LL is empty but 
    //also fast.next/slow.next can't be null as it means there is no cycle
       
        while(fast!=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    // Find Length of Cycle

    public int cyclen(ListNode head){
        int ctr=0;
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow){
                ListNode temp =slow;
                /* now eiter move temp ahead by 1 because it is same now and while loop will never 
                run as condtion is false or use do while loop as it runs 1 time even if condition is false
                */
                do{
                    temp=temp.next;
                    ctr++;
                }while(temp == slow);
            }
        }
        
        return ctr;
    }
}

class ListNode {
        int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
