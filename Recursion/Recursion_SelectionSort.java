//                  === Recursion Selection Sort ===

/*
We will be maintaing a max index variable also for current row and will swap it at the end
 */

package Recursion;

import java.util.Arrays;

public class Recursion_SelectionSort {
    public static void main(String[] args) {
        int arr[]={4,3,2,1,0,8,6};
        int maxIndex=0;

        Sort(arr ,arr.length-1,0,maxIndex);     // passing last row and 1st column index
        
        System.out.println(Arrays.toString(arr));
    }

    public static void Sort( int[] arr ,int r ,int c,int max){

        if(r==0){
            return;
        }

        if(c <= r){     //c<=r to go till last element

            if(arr[c]>arr[max]){
                //max will become c
                Sort(arr,r,c=c+1,c);
            }
            else{
                Sort(arr,r,c=c+1,max);
            }   
        }
        else{
            //swap max element to last
            int temp = arr[max];
            arr[max]=arr[r];
            arr[r]=temp;
            Sort(arr,r=r-1,0,0);     // we let maxindex=0 again and then it will find max index for the nxt iteration   
        }
    }
}
