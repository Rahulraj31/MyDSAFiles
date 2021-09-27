/*                   ==== Insertion Sort ====
 */

import java.util.*;
public class Insertion_Sort {
        public static void main(String[] args) {

        int[] arr ={5,4,3,2,1,8};
        InsertionSort(arr);       
        System.out.println(Arrays.toString(arr));
    }
    static void InsertionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) { 
            for (int j = i+1; j>0; j--) {
                if (arr[j]<arr[j-1])
                 {
                    //swap
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
                else{
                    break;
                }
            }
        }
    }
}
