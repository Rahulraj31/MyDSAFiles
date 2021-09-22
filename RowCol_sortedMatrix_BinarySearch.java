import java.util.Arrays;

/*                                  ======= Binary Search in 2D Array =========


Matrix is row and column wise sorted i.e. each row and each column is sorted and not strictly

Video Link-https://www.youtube.com/watch?v=enI_KyGLYPo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=12
 
 */



public class RowCol_sortedMatrix_BinarySearch {
    public static void main(String[] args) {

        int[][] arr ={
            {10,20,30,40},          
            {15,25,35,45},
            {28,29,37,49},
            {33,34,38,50}
            
        };

        int target=29;

       int[] index = BinarySearch2D(arr,target);

       System.out.println("Element Found at Index -" + Arrays.toString(index));      //return 2,1

       System.out.println("Element Found at Index -" + Arrays.toString(BinarySearch2D(arr,target=51)));     // return -1,-1
        
    }
    public static int[] BinarySearch2D(int[][] arr, int target){

        int row=0;                               // lower bound in this case 0,0 else can be n for n*m matrix
        int col=arr.length-1;                   // upper bound i.e in this case 0,3 else can be m for n*m matrix 

        while(row<arr.length && col>=0){

            if(arr[row][col]==target)
            {
                return new int[]{row,col};
            }
            if(arr[row][col] <  target)
            {
               row++;  // eliminate row as then that element wont be present in that whole column
            }
            else{
                col--;  // increase col
            }
        }

        return new int[]{-1,-1};
    }
    
}
