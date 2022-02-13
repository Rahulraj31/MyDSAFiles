/*                      === Reverse alternate K nodes in a Singly Linked List ===

https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
https://www.youtube.com/watch?v=70tx7KcMROc&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=44&t=8235s&ab_channel=KunalKushwaha
*/

package LinkedList;

public class K_Alternate_Reversal {
    
        // node template nested class
        private class Node{
            private int value;
            private Node next;    
        
            public Node(int val){
                this.value = val;
                this.next  = null;
            }
        } 
         
        public Node reverseKalt(Node head, int k){
            if (k <= 1 || head == null) {
                return head;
            }
    
            // skip the first left-1 nodes
            Node current = head;
            Node prev = null;
    
            while (current != null) {
                Node last = prev;
                Node newEnd = current;
    
                // reverse between left and right
                Node next = current.next;
                for (int i = 0; current != null && i < k; i++) {
                    current.next = prev;
                    prev = current;
                    current = next;
                    if (next != null) {
                        next = next.next;
                    }
                }
    
                if (last != null) {
                    last.next = prev;
                } else {
                    head = prev;
                }
    
                newEnd.next = current;
    
                // skip the k nodes
                for (int i = 0; current != null && i < k; i++) {
                    prev = current;
                    current = current.next;
                }
            }
            return head;
         }

}
