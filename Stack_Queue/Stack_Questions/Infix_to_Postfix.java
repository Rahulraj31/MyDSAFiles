/*                      === Infix to Postfix === 

https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/

https://youtu.be/m7SGekhd1mQ

(       -> push to stack
Operand -> print it
)       -> keep poping from stack till '(' is found

Operator -> If stack is Empty, push
            Else
                Compare with top operator in stack
                    If higher precendance, Push
                    Else keep popping nd printing till lower precedence is found
*/


package Stack_Queue.Stack_Questions;
import java.util.*;
public class Infix_to_Postfix {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println( infixToPostfix(exp));
    }

    public static String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
             
            // If c is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
              
            // If c is  '(', push it to the stack.
            else if (c == '(')
                stack.push(c);
             
            //  If c is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();
                 
                    stack.pop();
            }
            else // If c is an operator 
            {
                while (!stack.isEmpty() && Prec(c)
                         <= Prec(stack.peek())){
                   
                    result += stack.pop();
             }
                stack.push(c);
            }
      
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
         }
        return result;
    }

    // To check precedence of the operator  
    static int Prec(char ch){
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }
}
