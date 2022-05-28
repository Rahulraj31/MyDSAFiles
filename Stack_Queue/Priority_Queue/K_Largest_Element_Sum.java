/* 	=== Sum of K Largest Elements in an Array ===

N number of people participated in a coding marathon where they were asked to solve some problems. Each problem carried 1 mark and at the end of the marathon, the total marks that each person achieved was calculated. As an organizer, you have the list of the total marks that each person achieved. You have to calculate the sum of the marks of top K scorers from the list.

Input format 
input1: N, Total number of participants 
input2: K, Top scorers 
input3: An array of length N with the scores of all N participants

Example 1 
Input 
input1: 4 
input2: 2 
input3: {4, 1, 2, 5}
Output - 9  coz top 2 scorer are 4 and 5 


Make a min heap and solve like finding the Kth largest element then make a for loop and pop K elements from the minheap
*/

package Stack_Queue.Priority_Queue;
import java.util.*;
public class K_Largest_Element_Sum{
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0; i<k; i++){
            int x  = sc.nextInt();
            pq.add(x);
        }
        for(int i=k; i<n; i++){
            int x  = sc.nextInt();
            if(pq.peek()<x){
                pq.poll();
                pq.add(x);
            }
            
        }
        int sum=0;
        for(int j=0; j<k;j++){
            sum += pq.poll();
        }
        System.out.print(sum);
        
    }
}