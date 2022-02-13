//           Custom Double Linked List and its operation (w/o tail)

package LinkedList.Double_LL;

public class DLL{

    // node template 
    private class Node{
         int value;
         Node next; 
         Node prev;   
    
        public Node(int val){
            this.value = val;
        }
        
    }
    
    // making head nodes they will also have next and prev

    private Node head;
    private int size ;

    public DLL(){
        this.size=0;
    }


    // -----------------------------------------------------------------

    


    // == Inserting at First in Linked list == 

    public void insertFirst(int val){
        // creat new node
        Node node = new Node(val);
        node.next = head;
        node.prev=null;

        if(head!=null){ 
            head.prev=node;   
        }
       
        head=node;
        size+=1;
    }

    // == Inserting at Last in Linked list == 

    public void insertLast(int val){
        
        Node node = new Node(val);
        node.next=null;

        //If the element going to be added will be first
        if(head==null){ 
            insertFirst(val);
            return;
        }

        Node last =head;
        while(last.next!=null){
            last=last.next;
        }

        last.next=node;
        node.prev=last; 
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

        Node Newnode = new Node(val);
        Newnode.next=temp.next;
        temp.next=Newnode; 
        Newnode.prev=temp;
        // now attaching the right ele previous to the insertion ele as we done for left ele in above
        Newnode.next.prev= Newnode;
        System.out.println();
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
        size--;
        return val;
    }

    // === Delete Last ===

    public void deleteLast() {
       Node temp= head;
       for(int i=1; i<size-1; i++){ // iterate to 2nd last element
           temp=temp.next;
       }
       temp.next=null;
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
        Node last=null;
        while(temp!= null){
           System.out.print(temp.value + " -> ");
           last=temp;
           temp=temp.next;
        }

        System.out.println("End");

        while(last != null){
            System.out.print(last.value + " <- ");
            last=last.prev;
         }
         System.out.println("Start");
    }

}
