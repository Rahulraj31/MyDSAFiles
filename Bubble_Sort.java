/*                 ===  Bubble Sort Code ===
 */

import java.util.*;

public class Bubble_Sort {
public static void main(String[] args) {
    
    int[] arr ={5,4,3,2,1};
    bubbleSort(arr);        // in java array passed as cal by referencing thus no need to return the arry all changes will be made  
    System.out.println(Arrays.toString(arr));

}   

static void bubbleSort(int[] arr){

    // making boolean value for the condition that if array is already sorted 
    //and no need to run every pass

    boolean swapped =false;

    // run the steps n-1 times

    for (int i=0; i<arr.length; i++){
        // for each step max item will come atlast of unsorted part of array 
        
        for (int j=1; j< arr.length -i; j++)  // or j<= arr.length-1-i
        {
            //swap if item is smaller then previous 

            if(arr[j]<arr[j-1])
            {
                int temp =arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                swapped=true;
            }
        }

// if you did not swap for a particular value of i, it means array is sorted 
//and hence stop the program (Just for the case if array is already sorted) just to save time no the part of actual algo
        if(!swapped){
            break;
        }
    }
}

}