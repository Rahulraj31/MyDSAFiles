package Stack_Queue.Priority_Queue;
import java.util.*;
public class connect_NRopes {
   public static void main(String[] args) {
    int[] a = {2,5,4,8,6,9};
    int min_cost  =  minCost(a);

    System.out.println("Minimum cost to connect N ropes is " + min_cost);
   }
   static int minCost(int[] a){
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for (int i = 0; i < a.length; i++) {
           pq.add(a[i]);
       }
       int ans = 0;
       while(pq.size() > 1){
            int f = pq.poll();
            int s = pq.poll();
            int sum  = f + s;
            ans +=sum;
            pq.add(sum);
       }
       return ans;
   }
}

