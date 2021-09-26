/*              ==== Selection Sort Code ====
 */

import java.util.*;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        selectionSort(arr);       
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) { // or j<=arr.length-i-1
                
                // find max item in remaining array and swap to correct index
                int last=arr.length-i-1;
                int maxIndex= getMaxindex(arr,0,last);

                //swap
                int temp=arr[maxIndex];
                arr[maxIndex]=arr[last];
                arr[last]=temp;

            }
        }
        
    }

    static int getMaxindex(int[] arr, int start, int end) {
        int max=start;
        for (int j = 0; j <=end; j++) {
            if (arr[j]>arr[max]) {
                max=j;
            }
        }
        return max;
    }
    
}
