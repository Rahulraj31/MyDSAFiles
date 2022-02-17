/*  ===  Custom Stack Implemenation and Operations ===

This is static stack; we will be using this template for dynamic stacks
*/

package Stack_Queue;
public class CustomStack {

    protected int[] data;
    private static final int Def_size = 10;

    int ptr = -1;  // pointer for stack

    // if no size is passed this constructor will envoke the other const. with default size 
    public CustomStack(){
        this(Def_size);
    }
    public CustomStack(int size){
        this.data = new int[size];
    }

    //-------------- Operations ------------------
    
    public boolean isFull(){
        return (ptr == data.length);
    }
    public boolean isEmpty(){
        return (ptr == -1);
    }

    // Inserting Element
    public void push(int val){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        ptr++;
        data[ptr] = val;
    }

    // Poping Element
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from an empty stack");
        }
        return data[ptr--];    // show data[ptr] and do ptr=ptr--
    }

    // Peek Element i.e Top Element
    public int peek()throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot peek from an empty stack");
        }
        return data[ptr];
    }

    // Display Stack
    public void display(){
        for(int i = ptr; i > -1; i--){
            System.out.print(data[i] + " ");
        }
    }
//-----------------------------------------

    public static void main(String[] args) throws Exception {
        CustomStack stack =  new CustomStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println(); 
        System.out.println(stack.pop()); 
        System.out.println(stack.pop()); 
        System.out.println(stack.peek()); 
    }
}