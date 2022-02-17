/*              ===  Custom Queue Implemenation and Operations ===

This is static; we will be using this template for dynamic
*/
package Stack_Queue;
 
public class Custom_Queue {
    protected int[] data;
    private static final int Def_size = 10;

    int end = 0;  // pointer 

    public Custom_Queue(){
        this(Def_size);
    }
    public Custom_Queue(int size){
        this.data = new int[size];
    }
//-------------- Operations ------------------
    
    public boolean isFull(){
        return (end == data.length );
    }
    public boolean isEmpty(){
        return (end == 0);
    }

    // Inserting Element
    public void insert(int val){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        data[end++] = val;     // use end and  then increase end value
    }

    // Removing First Element
    public int remove(){
        if(isEmpty()){
            System.out.println("Cannot remove from an empty Queue");
        }

        int removed = data[0];
        
        // shift elements to left
        for(int i=1; i < end; i++){
            data[i-1]=data[i];
        }
        data[data.length] = 0; // making last element of queue 0

        end--;
        return removed;    
    }

    // Peek function to show front element in Queue
    public int peek(){
        if(isEmpty()){
            System.out.println("Cannot remove from an empty Queue");
        }

        return data[0];
    }


    //Display Queue
    public void display(){
        for(int i : data){
            System.out.print(i + " ");
        }
    }
//-------------------------------------

    public static void main(String[] args) {
        Custom_Queue queue = new Custom_Queue(5);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.display();
        queue.remove();
        System.out.println("\nPeek is : "+ queue.peek());
        queue.display();
    }  
}
