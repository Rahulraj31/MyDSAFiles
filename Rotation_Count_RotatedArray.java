/*
                              ===========  Rotation Count in Rotated Array =============



 Rotation would be equal to how many elements we have in pivot element i.e. 
 finding the peak index or pivot index adding 1 to it returns the number of  elements and hence rotations
 
 Ex-  [1,2,3,4,5,6,7] => [4,5,6,7, 1,2,3] Now index of 7 is 3 means it has 4 pivoted elements and hence went through 4 rotations

       Rotation steps -   1. [7, 1,2,3,4,5,6]
                          2. [6,7, 1,2,3,4,5]
                          3. [5,6,7, 1,2,3,4]
                          4. [4,5,6,7, 1,2,3] ===>  Final Array





 */

public class Rotation_Count_RotatedArray {

    public static void main(String[] args) {

        int[] arr={4,5,6,7,1,2,3};

       int ans= countRotation(arr);

       System.out.println("Rotation Count-" + ans);
        
         
    }

    public static int countRotation(int[] arr) {
        int pivot = findPivot(arr); // returns index

        return pivot+1;
    }
        // Use this for Distinct

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) { // mid < end cos what if mid is last element
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {   // what if mid is start element 
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    // USe this  For Duplicate 

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
        
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}