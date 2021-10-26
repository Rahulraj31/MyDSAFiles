
//                         === Merge Sort Recursive ===

// This method uses making new array not inplace method i.e. will make new array instead of doing it in same .


import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int arr[]={8,3,4,12,5,6};

        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    static int[] mergeSort(int[] arr){

        if(arr.length ==1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left= mergeSort(Arrays.copyOfRange(arr, 0, mid));  // make a copy of array of a certain range
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));  // from mid not from mid+1 cause it is exclusive
    
        return merge(left,right);   // for merging sorted parts
    }

    static int[] merge(int[]left, int[] right){
        int[] mix = new int[left.length+right.length];

        int i=0;
        int j=0;
        int k=0;

        while(i< left.length && j< right.length){
            
            if(left[i]<right[j]){
                mix[k]=left[i];
                i++;
                
            }
            else{
                mix[k]=right[j];
                j++;
            }
            k++;
        }

        // it maybe possible that  one of the arrays is not complete i.e. 
        //add remaining element , only one of the while run

        while(i< left.length){
            mix[k]=left[i];
            i++;
            k++;
        }

        while(j< right.length){
            mix[k]=right[j];
            j++;
            k++;
        }

        return mix;
    }
}


