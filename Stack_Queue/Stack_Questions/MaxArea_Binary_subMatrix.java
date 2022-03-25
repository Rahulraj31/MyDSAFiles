/*      === Maximum size rectangle binary sub-matrix with all 1s ===

Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s. 

video link -https://youtu.be/oaN9ibZKMpA
Leetcode - https://leetcode.com/problems/maximal-rectangle/


Input:
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
Output :
8
Explanation : 
The largest rectangle with only 1's is from 
(1, 0) to (2, 3) which is
1 1 1 1
1 1 1 1 

If it is asked largest square sub matrix then it is solved using DP.

It is similar to the question "Largest Area in Histrogram". 
Consider a row one at a time and try to consider it as histogram 
and find the area of histogram. Now move to next row consider that as a base of histogram 
and all rows above base row will act as height of the histogram. DO the same thing for each row
and id you find any zero in the column of base row , dont consider the columns above the zero column
and make overall height of that column equal to 0 


================================================


*/

package Stack_Queue.Stack_Questions;

import java.util.*;
public class MaxArea_Binary_subMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
            { 0, 1, 1, 0 },
            { 1, 1, 1, 1 },
            { 1, 1, 1, 1 },
            { 1, 1, 0, 0 },
        };

        int ans = largestArea(matrix);
        System.out.println("the laregest sub matrix area is " + ans);
    }
    
    public static int largestArea(int[][] a){
        int curRow[] = new int[a[0].length];
        int maxAns=0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){

                if(a[i][j]==1){
                    curRow[j] +=1;       // adding above rows to make height
                }
                else{
                    curRow[j] =0;   // if any base column is 0 make overall height =0; 
                }
            }

            // for each built histogram(by adding rows) of we calculate the max area
            int currAns = maxhistogram(curRow);
            maxAns = Math.max(currAns, maxAns);
        }

        return maxAns;
    }


    // Finding Area of the resultant Histogram
    public static int maxhistogram(int[] arr){
        int[] left_smaller = leftSideSmall( arr );
        int[] right_smaller = rightSideSmall( arr );

        int maxAns= 0;

        for( int i=0; i<arr.length; i++){
            int curr_area = arr[i]*(right_smaller[i] - left_smaller[i] -1);
            maxAns = Math.max(maxAns, curr_area);
        }
        return maxAns;
    }
    public static int[] leftSideSmall( int[] arr ){
        int[] left  = new int[arr.length]; 
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<arr.length; i++){
            while(stack.isEmpty() == false){
                if(arr[i] > arr[stack.peek()]){
                    left[i] = stack.peek();
                    stack.push(i);
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.empty()){
		        stack.push(i);
		        left[i] = -1;
		    }
        }
        return left;
    }
    public static int[] rightSideSmall( int[] arr ){
        int[] right  = new int[arr.length]; 
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=arr.length-1; i>=0; i--){
            while(stack.isEmpty() == false){
                if(arr[i] > arr[stack.peek()]){
                    right[i] = stack.peek();
                    stack.push(i);
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.empty()){
		        stack.push(i);
		        right[i] = arr.length;
		    }
        }

        return right;
    }
}