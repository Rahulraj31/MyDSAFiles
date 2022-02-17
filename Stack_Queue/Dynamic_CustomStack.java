/*  ===  Dynamic Custom Stack Implemenation and Operations ===

This stack class extends the static class.  Operations will remain the same just push method will be overridden
*/


package Stack_Queue;
public class Dynamic_CustomStack extends CustomStack{

    public Dynamic_CustomStack(){
        super();        // calls CustomStack()
    }

    public Dynamic_CustomStack(int size){
        super();        // calss CustomStack(int size)
    }

    @Override
    public  void push(int val){
        // if array is full
        if(this.isFull()){
            // double the array size
            int[] temp = new int[data.length*2];

            // copy all previous item to new array
            // System.arraycopy(data, 0, temp, ptr, temp.length); OR
            for(int i=0; i < data.length; i++){
                temp[i] = data[i];
            }
            data=temp;
        }
         
        // Inserting Item  
        // at this point array is not full 
        super.push(val);
    }

    public static void main(String[] args) {
        Dynamic_CustomStack dystack = new Dynamic_CustomStack(5);

        dystack.push(1);
        dystack.push(2);
        dystack.push(3);
        dystack.push(4);
        dystack.push(5);
        dystack.push(6);
        dystack.display();
    }
}