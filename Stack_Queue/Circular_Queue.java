/*              ===  Custom Circular Queue ===

This is static; we will be using this template for dynamic

*/

package Stack_Queue;

public class Circular_Queue   {
    protected int[] data;
    private static final int Def_size = 10;

    // pointers
    int end = 0; 
    int front = 0;
    int size = 0; 

    public Circular_Queue(){
        this(Def_size);
    }
    public Circular_Queue(int size){
        this.data = new int[size];
    }
//-------------- Operations ------------------
    
    public boolean isFull(){
        return (size == data.length );
    }
    public boolean isEmpty(){
        return (size == 0);
    }

    // Inserting Element
    public void insert(int val){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        data[end++] = val;    
        end = end % data.length;
        size++;
    }

    // Removing First Element
    public int remove(){
        if(isEmpty()){
            System.out.println("Cannot remove from an empty Queue");
        }

        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;    
    }

    // Peek function to show front element in Queue
    public int peek(){
        if(isEmpty()){
            System.out.println("Cannot remove from an empty Queue");
        }

        return data[front];
    }
    
    //Display Queue
    public void display(){
        int i = front;
        do{
            System.out.print(data[i] + " ");
            i++;
            i %= data.length;
        } while( i != end);
    }


    public static void main(String[] args) {
        Circular_Queue queue = new Circular_Queue(5);

        queue.insert(17);
        queue.insert(23);
        queue.insert(3);
        queue.insert(14);
        queue.insert(65);

        queue.display();
        queue.remove();
        System.out.println("\nPeek is : "+ queue.peek());
        queue.display();
    } 
}
