/*        === Subarray with given sum === 

Given an unsorted array A of size N that contains only non-negative integers,
find a continuous sub-array which adds to a given number S.

https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/

Brute force method 
run a for loop from i=0 to n then inside it run again a for loop from j=i to n 
the find the sum for the subarray hence O(n2)

Using hashing O(n)
we store sum as key to index as value like
a0 = 0
a0+a1=1
a0+a1+a2=2

 every index stores the sum of elements up to that index hashmap. 
 So to check if there is a subarray with a sum equal to s, check for every index i, and sum up to that index as curr_sum. 
 If there is a prefix with a sum equal to curr_sum – target, then the subarray with the given sum is found. 
 i.e if urr_sum – target is at Kth index then we will return (K+1)th index to k+ith index .
 */


package Hashing;
import java.util.*;
public class subArray_withgiven_sum {
   public static void main(String[] args) {
        int[] a = {10, 2, -2, -20, 10};
        int target = -10;
        int n = a.length;
        int curr_sum=0;
        int start=0;
        int end = -1; // if it remains -1 then subarray not found
        HashMap<Integer,Integer> hs = new HashMap<>();

        for(int i=0;i<n;i++){
            curr_sum += a[i];

            // if curr_sum becomes equal to target sum
            if(curr_sum == target){ 
                start =0; end=i;   
                break;
            }

            // if curr_sum - target is present 

            if(hs.containsKey(curr_sum - target)){
                start = hs.get(curr_sum - target)+1;
                end=i;
                break;
            }
            // if found nothing add curr_sum and i to hashmap
            hs.put(curr_sum, i);  
        }
        System.out.println(start + " "+ end);
    }
}
