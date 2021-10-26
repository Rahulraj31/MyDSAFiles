import java.util.Arrays;

//                  === Recursion Bubble Sort === 


public class Recursion_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};

      bubble_sort(arr, arr.length-1 ,0);      // pass last index  and col=0
        
      System.out.println(Arrays.toString(arr));
    }

    public static void bubble_sort(int[] arr, int r, int c){
        if(r==0){
            return;
        }
        if(c < r){     //why c<=r coz index out of bound error

            if(arr[c]>arr[c+1]){
                //swap
                int temp = arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }

            bubble_sort(arr,r,c=c+1);     
        }
        else{
            
            bubble_sort(arr,r=r-1,0);    //nxt iteratation
        }
    }
}


