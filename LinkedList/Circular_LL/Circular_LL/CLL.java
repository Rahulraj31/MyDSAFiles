//           Custom Circular Linked List and its operation 

package LinkedList.Circular_LL;

public class CLL{

    // node template nested class
    private class Node{
        private int value;
        private Node next;    
    
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

    public CLL(){
        this.size=0;
    }


    // -----------------------------------------------------------------

    // Inserting element at the ends (First == last)
    public void insert(int val){
        Node node= new Node(val);
        if(head==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        tail.next =node;
        node.next=head;
        tail=node;
        size++;
    }
    

    // === Insert At any index ===

    public void InsertIndex(int val, int index) {
        if(index==0 || index==size){
            insert(val);
            size++;
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){
            temp =temp.next;
        }

        Node Newnode = new Node(val, temp.next); 
        
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

    public void deleteFirst() {     
        head=head.next;
        // if(head==tail){  // means if LL has only 1 element
        //     tail=null;
        //     head=null;
        // }

        tail.next = head;
        size--;
    }

    // === Delete Last ===

    public void deleteLast() {
       Node temp= head;
       for(int i=1; i<size-1; i++){ // iterate to 2nd last element
           temp=temp.next;
       }
       tail=temp;
       tail.next=head;
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


        /* This is one way to do 
        while(temp != tail){
           System.out.print(temp.value + "-> ");
           temp=temp.next;
        }
        Best way is this - */
        if(head != null){
            do {
                System.out.print(temp.value + "-> ");
                temp=temp.next;
                
            } while (temp !=head);
            System.out.println("Head");
        }
        
    }
}
