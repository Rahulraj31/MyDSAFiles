//                               === Custom Single Linked List and its operation (insert, delete, display, size)  ====

/*  Other Topic:- 
 1. Recursion Insertion in the list
 2. Recursion Reversal of list  [1:47:28] https://www.youtube.com/watch?v=70tx7KcMROc&t=6199s
*/

package LinkedList.Single_LL;

public class LL{

    // node template nested class
    private class Node{
        private int value;
        private Node next;    // by deafult points null
    
        public Node(int val){
            this.value = val;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next =  next;
        }
    }
    
    // making head and tail nodes

    private Node head;
    private Node tail;
    private int size ;

    public LL(){
        this.size=0;
    }


    // -----------------------------------------------------------------

    


    // == Inserting at First in Linked list == 

    public void insertFirst(int val){
        // creat new node
        Node node = new Node(val);
        node.next = head;
        head=node;

        if(tail==null){  //means 1st item is being added
            tail=head;
        }
        size+=1;
    }

    // == Inserting at Last in Linked list == 

    public void insertLast(int val){
        
        //If the element going to be added will be first
        if(tail==null){ 
            insertFirst(val);
            return;
        }
        // creat new node
        Node node = new Node(val);
        tail.next = node;
        tail=node;

        size+=1;
    }


    // === Insert At any index ===

    public void InsertIndex(int val, int index) {
        if(index==0){
            insertFirst(val);
            return;
        }

        if(index==size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i=1; i<index; i++){
            temp =temp.next;
        }

        Node Newnode = new Node(val, temp.next);  // Newnode.next=temp.next;
        
        temp.next=Newnode; 
        size++;
    }


    // === Get Address of Node in LL ===
    public Node getAdd(int index){
        Node ele = head;
        for(int i=1; i<=index; i++){
            ele =ele.next;
        }
        return ele;
    }

    // === Get Value of Node in LL ===
    public int getVal(int index){
        Node ele = head;
        for(int i=1; i<=index; i++){
            ele =ele.next;
        }
        return ele.value;
    }

    // === Find Value  in LL ===
    public Node find(int val){
        Node ele = head;
        while(ele!=null){
            if(ele.value == val){
                return ele;
            }
            ele=ele.next;
        }
        return null;
    }

    // === Delete First ===
    public int deleteFirst() {
        int val = head.value;
        head=head.next;
        if(head==null){  // means if LL has only 1 element
            tail=null;
        }
        size--;
        return val;
    }

    // === Delete Last ===

    public void deleteLast() {
       Node temp= head;
       for(int i=1; i<size-1; i++){ // iterate to 2nd last element
           temp=temp.next;
       }
       tail=temp;
       tail.next=null;
       size--;
    }

    // === Delete at Index ===
    public void deleteIndex(int index){
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == size-1){
            deleteLast();
            return;
        }

        Node prev= head;
        // iterate to the index just before the index to be deleted
       for(int i=1; i<index; i++){ 
           prev=prev.next;
       }

       // now linking prev element to the element after index to be deleted
       prev.next=prev.next.next; 
       // means go the element skipping one in between 
       size--;

    }


//-----------------------------------------------------------------

    // Display Size
    public void size(){
        System.out.println("The size of Linked List is "+this.size);
    }

    // Display LL
    public void display(){
        Node temp =  head;
        while(temp != null){
           System.out.print(temp.value + "-> ");
           temp=temp.next;
        }

        System.out.println("End");
    }



    // Recursive Insertion in LL 
    public void insertRec(int val, int index){
        head=insertRec(val, index,head);
    }
    private Node insertRec(int val, int index, Node Anode){     //here Anode is the next index node of the inserted node
        if( index==0 ){
            Node temp= new Node(val, Anode);
            size++;
            return temp;
        }
        Anode.next=insertRec(val, index--, Anode.next);
        return Anode;
    }

    // Recursive Reversal of LL 
    public void recurReverse(Node node){
        if(node==tail){
            head=tail;
            return;
        }

        recurReverse(node.next);
        tail.next=node;
        tail=node;
        tail.next = null;
    }
                   

}

