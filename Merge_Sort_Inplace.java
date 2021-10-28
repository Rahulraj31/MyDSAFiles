import java.util.Arrays;

//              === Merge Sort Recursive Inplace Method ===


public class Merge_Sort_Inplace {
    public static void main(String[] args) {
        int arr[]={8,3,4,10,5,6};

        int start = 0;
        int end = arr.length;
        SortInPlace(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

   static void SortInPlace(int[] arr, int s , int e){

    if( e-s == 1){
        return ;
    }
    int mid = (s+e) /2;
    SortInPlace( arr , s , mid);
    SortInPlace( arr , mid , e);

    mergeInPlace(arr, s, mid, e);
    }

    static void mergeInPlace( int[] arr,  int s, int mid, int e){

        int[] mix= new int[e-s];

        int i = s;
        int j = mid;
        int k = 0;

        while(i< mid && j<e){
            
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
                
            }
            else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i< mid){
            mix[k]=arr[i];
            i++;
            k++;
        }

        while(j< e){
            mix[k]=arr[j];
            j++;
            k++;
        }

        // modifying original array

        for(int l=0; l<mix.length; l++){

            arr[s+l] =mix[l];
        }
    
    }
}