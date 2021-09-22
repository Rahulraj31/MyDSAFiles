import java.util.Arrays;

/*                          =========== Binary Search in Strictly Sorted 2D ARRAY  ==============

Can also use RowCol_Sortedmatrix program.
Video Link 22:51 https://youtu.be/enI_KyGLYPo 

matric eg-   1 2 3
             4 5 6


*/

public class Sorted_Matrix_BS {
    public static void main(String[] args) {

        int[][] arr= {
            {1, 2, 3,},
            {4,5,6,},
            {7,8,9},

        };

        System.out.println(Arrays.toString(MatrixSearch(arr,  6)));
        
    }

    // search in thr row provided between the cols provided 
    static int[] SimpleBS(int[][] matrix,int row,int colstart,int colend,int target)
    {
        while(colstart<=colend)
        {
            int mid = colstart + (colend-colstart)/2;

            if(matrix[row][mid]==target)
            {
                return new int[]{row,mid};
            }

            if(matrix[row][mid]<target)
            {
                colstart=mid+1;
            }
            else
            {
                colend=mid-1;
            }

            
        }
        return new int[]{-1,-1};
    }
    
     static int[] MatrixSearch(int[][] arr,int target){
         int rows =arr.length;
         int cols = arr[0].length; // be caustious matrix maybe empty

         if(rows==1){
            return SimpleBS(arr, 0, 0, cols-1,target);
         }

         // run the loop till 2 rows are remaining 
         int rstart=0,rend=rows-1;
         int cmid=cols/2;

         while(rstart<(rend-1)) {  // while true it will have more than 2 rows 


                int mid = rstart + (rend-rstart)/2;

                if(arr[mid][cmid]==target)
                {
                    return new int[]{mid,cmid};
                }
                if(arr[mid][cmid]<target)
                {
                    rstart=mid;
                }
                else{
                    rend=mid;
                }
            
         }
         //now we have 2 rows 
         // check if target is in the col of 2 rows

         if(arr[rstart][cmid]==target){
            return new int[]{rstart,cmid};
         }
         if(arr[rstart+1][cmid]==target)
         {
            return new int[]{rstart+1,cmid};
         }
         // other wise search in 1st half
         if(target<= arr[rstart][cmid-1])
         {
            return SimpleBS(arr,rstart,0,cmid-1,target);
         }
         // other wise search in 2nd half
         if(target>= arr[rstart][cmid+1] && target <=arr[rstart][cols-1])
         {
            return SimpleBS(arr,rstart,cmid+1,cols-1,target);
         }
         // other wise search in 3rd half
         if(target<= arr[rstart+1][cmid-1])
         {
            return SimpleBS(arr,rstart+1,0,cmid-1,target);
         }
         // other wise search in 4th half
         if(target>= arr[rstart+1][cmid+1])
         {
            return SimpleBS(arr,rstart+1,cmid+1,cols-1,target);
         }


         return null;
     }
}

