/*                   === CYCLIC SORT ===

video link - https://youtu.be/JfinxytTYFQ
 */

import java.util.*;
public class Cyclic_Sort {
    public static void main(String[] args) {

        int[] arr ={5,4,3,2,1};   // should be cont. element range.
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
 
    static void cyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correctIndex= arr[i]-1;

            if(arr[i]!= arr[correctIndex])
            {
                int temp=arr[correctIndex];
                arr[correctIndex]=arr[i];
                arr[i]=temp;
            }
            else{
                i++;
            }
        }
    }
}
