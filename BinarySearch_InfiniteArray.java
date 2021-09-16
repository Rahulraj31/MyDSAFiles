/*

 ======== Find position of an element in a sorted array of infinite numbers =========

Link - https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/#
Source: Amazon Interview Experience. 

Video Solution - 1:28:33 https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=3561s

Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of array. 
If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key
first we find bounds and then apply binary search algorithm.

*/




public class BinarySearch_InfiniteArray {
    public static void main(String[] args) {
   
    int[] arr={1,2,3,4,5,6,7,8,9,11,12,23,34,45,67,89,90,99};
    int target=2;

     
    int index = findingRange( arr,target);

    System.out.println("Element found at index= " + index);
        
    }

    static int findingRange(int[] arr,int target){

        // first find range start with the box of size 2 
        int start=0; int end=1;

        // condition fir target to lie in range

        while(arr[end]<target)
        {
           int newstart=end+1;
            end= end+ (end-start+1)*2;   // doubling box size
            start=newstart;
        }

        return binarySearch(arr, target,start,end);

    }


    static int binarySearch(int[] arr, int target,int start,int end) {
    
        while (start <= end) {
          int mid = start + (end - start) / 2;
          if (arr[mid] == target) {
            return mid;
          } else if (target < arr[mid]) {
            end = mid - 1;
          } else { // target>mid
            start = mid + 1;
          }
        }
        return -1;
      }
}
