/*                       === Largest Rectangular Area in a Histogram ===

Find the largest rectangular area possible in a given histogram where the 
largest rectangle can be made of a number of contiguous bars.

gfg https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
video exp - https://youtu.be/vhUxKxiconE
leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/


Input: heights = [2,1,5,6,2,3]
Output: 10
-----------------------------------------------------------
Approch - Time Complexity :  O(n) Space Complexity :  O(n)

By finding Left side smaller element and Right Side smaller element for every element in O(n) time complexity and O(n) auxiliary space 
and storing their index in 2 respective arrays.

For Left side if no element is found assign -1 
For right Side if no element is found assign n (length of array, where indexes are from 0 to n-1)

This is so as to make if else condition and calc easier.

we find each possible area using this formula [ arr[i]*(right_smaller[i] - left_smaller[i] - 1) ]

====================================================================
*/

package Stack_Queue.Stack_Questions;
import java.util.*;
public class Max_Area_Histogram {
    public static void main(String[] args) {
        int[] arr = {4,2,1,5,6,3,2,4,2};

        int[] left_smaller = leftSideSmall( arr );
        int[] right_smaller = rightSideSmall( arr );

        int maxAns= 0;

        for( int i=0; i<arr.length; i++){
            int curr_area = arr[i]*(right_smaller[i] - left_smaller[i] -1);
            maxAns = Math.max(maxAns, curr_area);
        }
        System.out.println(Arrays.toString(left_smaller));
        System.out.println(Arrays.toString(right_smaller));
        System.out.println("Max Rectangular Area of histogram : "+ maxAns);

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