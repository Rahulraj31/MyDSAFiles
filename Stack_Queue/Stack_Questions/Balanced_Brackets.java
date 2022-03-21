/*          === Check for Balanced Brackets in an expression using Stack

Given an expression string exp, write a program to examine whether the pairs and the orders of 
“{“, “}”, “(“, “)”, “[“, “]” are correct in exp.

gfg - https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
leetcode - https://leetcode.com/problems/valid-parentheses/


Using ArrayDeque is faster than using Stack class  
Deque<Character> stack= new ArrayDeque<Character>();

*/

package Stack_Queue.Stack_Questions;
import java.util.*;
public class Balanced_Brackets {
	public static void main(String[] args) {
		
		String expr = "([{}])";     // "[(])"
		if(checkBra(expr)){
		    System.out.println("Balanced ");
		}
		else{
		    System.out.println("Not Balanced ");
		}
	}
	static boolean checkBra(String expr){
	    Stack<Character> stack =  new Stack<Character>();

	    for (int i = 0; i < expr.length(); i++){
	        char x = expr.charAt(i);
	        if(x == '(' || x == '[' || x == '{'){
                //push
	            stack.push(x);
	            continue;
	        }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
	        if(stack.empty()){
	            return false;
	        }
	        if(x==')' && (stack.pop() !='(')){
	            return false;
	        }
	        if(x==']' && (stack.pop() !='[')){
	            return false;
	        }
	        if(x=='}' && (stack.pop() !='{')){
	            return false;
	        }
	    }
        // Check Empty Stack if empty then balanced 
	    return (stack.empty());
	}
}
