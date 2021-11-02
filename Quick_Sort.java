

//                   === Quick Sort  Recussion ===

import java.util.Arrays;
public class Quick_Sort {
  public static void main(String[] args) {
      int[] arr ={5,4,3,2,1};
      int hi = arr.length-1;
      int low = 0;
      sort(arr, low, hi);

      System.out.print(Arrays.toString(arr));
  }  

  static void sort(int[] nums, int hi, int low){
    if(low >= hi){
        return;
    }

    int s =low;
    int e = hi;
    int m = s+ (e-s)/2;    

    int pivot = nums[m];

    while(s<=e){
        
        while(nums[s] < pivot) { 
            s++;
        }

        while(nums[e] > pivot) { 
            e--;
        }

        // when above 2 whiles will be false we need to swap it

        if(s <= e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }

    }

    // now my pivot is at correct index, please sort two halves now

    sort( nums, low, e);
    sort( nums, hi , s);
  }
}
