/*          === Find Kth Largest/ Smallest Element === 

https://youtu.be/yAs3tONaf3s
if Largest Use min Heap
a = 20, 10, 40, 60, 50,30
k = 3
O/p = 40

Make Priority Queue of size = k. Then enter first k elements to the queue
After adding make a for loop from i=k to end, inside that make a if statement 
that if peek of queue is less then a[i] we pop it and add a[i] to queue

In last we return pq.peek()

if Smallest Use max Heap
a = 20, 10, 40, 60, 50,30
k = 3
O/p = 30
 */

package Stack_Queue.Priority_Queue;
import java.util.*;
public class Kth_LargestSmallest_Array {
    public static void main(String[] args) {
        int arr[] = {20,10,60,30,50,40};
        int k=3;
        int kthLarge = kthLargest( arr, k);
        int kthSmall = kthSmall(arr, k);

        System.out.println(k+"th largest is "+kthLarge);
        System.out.println(k+"th smallest is "+kthSmall);
    }

    static int kthLargest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        for(int i=k; i<arr.length; i++){
            if(pq.peek() < arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }
    static int kthSmall(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        for(int i=k; i<arr.length; i++){
            if(pq.peek() > arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
    

}
