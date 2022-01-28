package LinkedList.Single_LL;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertLast(6);
        list.InsertIndex(100, 2);
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
