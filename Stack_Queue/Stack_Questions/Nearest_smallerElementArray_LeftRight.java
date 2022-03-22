/*                                      === Find the nearest smaller numbers on left side in an array ===

Given an array of integers, find the nearest smaller number for every element such 
that the smaller element is on left side.

https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
video explaination - https://youtu.be/_RtghJnM1Qo

Input:  arr[] = {1, 6, 4, 10, 2, 5}
Output:         {-1, 1, 1,  4, 1, 2}
First element ('1') has no element on left side. For 6, 
there is only one smaller element on left side '1'. 
For 10, there are three smaller elements on left side (1,
6 and 4), nearest among the three elements is 4.

Input: arr[] = {4, 10, 5, 18, 3, 12, 7}
Output:        {-1, 4, 4, 5, -1, 3, 3}

We will use stack concept O(n) time if stack is empty while comparing return -1 
else start comparing each element with peek of stack. Pop the peek until we
find the smallest number and if we find then push the element(for which we are finding smallest element) 
to the stack and move on next element of the array.

=== For Right Side smallest element ===
just start from the end of array 

*/


package Stack_Queue.Stack_Questions;
import java.util.*;
public class Nearest_smallerElementArray_LeftRight {
    public static void main(String[] args) {
        int[] arr= {4,10,5,18,3,12,7};
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<arr.length; i++){

		        while(stack.empty()==false){
		            if(arr[i]>stack.peek()){
		                System.out.println( arr[i] + " " + stack.peek());
		                stack.push(arr[i]);
		                break;
		            }
		            else{
		                stack.pop();
		            }
		        }
		        if(stack.empty()){
		        stack.push(arr[i]);
		        System.out.println( arr[i] + " " + -1);
		    }
	    }
    }
}
