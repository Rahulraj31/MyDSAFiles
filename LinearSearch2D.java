import java.util.Arrays;

public class LinearSearch2D {
    public static void main(String[] args) {
        int arr[][]= {

            {34,56,78},
            {54,65,76,90},
            {22,44},
        };

        int target =54;
        int[] ans = search(arr,target); // return array coodinate

        System.out.println("index-" + Arrays.toString(ans));
    }

    static int[] search(int[][] arr, int target)
    {
        for (int row=0; row<arr.length; row++){
            for (int col=0; col<arr[row].length; col++){
                if(arr[row][col]==target){
                    return new int[]{row,col};
                }
            }
        }
         
        return  new int[]{-1,-1};
    }
    
}
