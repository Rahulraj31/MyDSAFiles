package LinkedList.Circular_LL;

public class Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(6);
        // list.InsertIndex(100, 2);
        list.display();
        System.out.println("Add and Value at index 3 :- "+ list.getAdd(3) +" , "+list.getVal(3));
        System.out.println("Value deleted- "+ list.deleteFirst());
        list.display();
        list.size();
        list.deleteLast();
        list.display();
        list.deleteIndex(1);
        list.display();
        
    }
}
