/*

======  Floor Of a Number =========

Do binary search in a acsending order array and 
instead of returning -1 return  START



*/


public class Floor_Of_Number {
    public static void main(String[] args) {
        int[] arr = { -22, -18, -1, 0, 23, 34, 45, 56, 67, 78, 89 };
       int target = 20;
   
       int index = binarySearch(arr, target);
   
       System.out.println("Floor of the number is = " + arr[index]);
     }
   
     static int binarySearch(int[] arr, int target) {
       int start = 0;
       int end = arr.length - 1;


         // What if target is samller than the samllesy element in the array
         if(target<arr[start]){
            return -1;
        }
   
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
       return end;
     }
    
}
