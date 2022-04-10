/*   === Implementing Priority Queue ===

It is a queue with priorities implemented on heap data structure
video-link = https://youtu.be/yAs3tONaf3s

By default it follows Min Heap (in JAVA , in C++ it's opposite)

To implement Max Heap , while inserting  elements instead of pushing A push -A 
and while printing invert the sign
Or use this syntax

PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder())
*/


package Stack_Queue.Priority_Queue;
import java.util.*;
public class priorityQueue {
    public static void main(String[] args) {
        System.out.println("Min heap / Printing smallest elements in order");
        minHeap();
        System.out.println("\n-----");
        System.out.println("Max heap / Printing largest elements in order");
        maxHeap();
    }

    // Implementing Min Heap 
    static void minHeap(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(15);
        pq.add(10);
        System.out.println("Size of Prior. Queue "+ pq.size());
        while(!pq.isEmpty()){
            System.out.print(pq.peek() + " ");
            pq.poll();
        }
    }
    // Implementing Max Heap 
    static void maxHeap(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(-5);
        pq.add(-15);
        pq.add(-10);
        System.out.println("Size of Prior. Queue "+ pq.size());
        while(!pq.isEmpty()){
            System.out.print(-pq.peek() + " ");
            pq.poll();
        }
    }
}
