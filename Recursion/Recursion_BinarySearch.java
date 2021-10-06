/*                                === Recursion Binary Search ===
 */
package Recursion;
public class Recursion_BinarySearch {
public static void main(String[] args) {
    int[] arr={1,2,3,4,9,10,11};    
    int target=3;
    int start=0 , end=arr.length-1;
    System.out.println("target found at index :" + search(arr,target,start,end));
    System.out.print("target found at index :" + search(arr,target=6,start,end));
}
static int search(int[] arr, int target, int start, int end)
    {
          
        if(start<=end){                     // base condition to end recusion
            int mid=start+(end-start)/2;
            if(target==arr[mid]){
                return mid;
            }

            else if(target<arr[mid]){
                end=mid-1;
                return search(arr,target,start,end);
            }
            else{
                start=mid+1;
                return search(arr,target,start,end);
            }
        }
           return -1;
    }
}