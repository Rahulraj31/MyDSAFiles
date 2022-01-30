package LinkedList.Circular_LL;

public class Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(6);
        list.InsertIndex(100, 2);
        list.display();
        list.size();
        list.deleteFirst();
        list.deleteLast();
        // list.display();
         list.deleteIndex(2); 
         list.display();
        
    }
}
