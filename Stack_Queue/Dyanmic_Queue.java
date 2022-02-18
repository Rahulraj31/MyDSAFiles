/*  ===  Dynamic Circular Queue Implemenation and Operations ===

This stack class extends the static class.  Operations will remain the same just push method will be overridden
*/

package Stack_Queue;

public class Dyanmic_Queue extends Circular_Queue{
    public Dyanmic_Queue(){
        super();        // calls Circular()
    }

    public Dyanmic_Queue(int size){
        super(size);        // calss Circular(int size)
    }

    @Override
    public void insert(int val){
        if(isFull()){
            // double the array size
            int[] temp = new int[data.length*2];

            // copy all previous item to new array
            // System.arraycopy(data, 0, temp, ptr, temp.length); OR
            for(int i=0; i < data.length; i++){
                temp[i] = data[(front + i) % data.length];
            }

            front = 0;
            end = data.length;
            data=temp;
        }
        super.insert(val);;
    }
}
