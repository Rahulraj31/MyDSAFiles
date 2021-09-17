/*

Order Agnostic Binary Search - if you don't know your array is sorted in which way asc or desc


*/



public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {

        int[] arr = { 
             // asc -22, -18, -1, 0, 23, 34, 45, 56, 67, 78, 89
             89,78,67,56,45,34,23,0,-1,-18,-22 
         };


      int target = 47;
  
      int index = orderAgnosticBS(arr, target);
  
      System.out.println("Element found at index= " + index);
    
    }
    
    static int orderAgnosticBS(int[] arr, int target){
    
     int start =0 ,  end= arr.length-1;   

     // finding array is asc or desc

     boolean isAsc = arr[start]< arr[end];

     while(start<= end){
        int mid = start + (end-start)/2;

        if(arr[mid]==target)
        {
            return mid;
        }
        if(isAsc)
        {
            if (target < arr[mid]) {
                end = mid - 1;
              } else { 
                start = mid + 1;
              }
        }
        else
        {
            if (target > arr[mid]) {
                end = mid - 1;
              } else { 
                start = mid + 1;
              }
        }
        
     }

    return -1;    
    }

}
  
  