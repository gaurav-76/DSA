class ListNode{
    int data;
    ListNode prev;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedListInsert {

    static ListNode head = null;
    static ListNode last = null;

    //print from start
    public static void printStart(ListNode head){

        while(head != null){
            System.out.print(head.data +  " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //print from end
    public static void printLast(ListNode last){
        while(last != null){
            System.out.print(last.data +  " <- ");
            last = last.prev;
        }
        System.out.println("null");
    }

    //Inserting node at beginning
    public static ListNode insertFirst(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        if(last == null){
            last = newNode;
        }
        else{
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;
        return head;
    }

    //Inserting node at End
    public static ListNode insertLast(ListNode last, int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
        }
        else{
            last.next = newNode;    
        }

        newNode.prev = last;
        last = newNode;
        return last;
    }

    public static void main(String[] args) {
        
        // ListNode first = new ListNode(1);
        // ListNode second = new ListNode(2);
        // ListNode third = new ListNode(5);
        // ListNode fourth = new ListNode(4);
        // ListNode fifth = new ListNode(2);
        // ListNode sixth = new ListNode(3);

        // first.next = second;
        // first.prev = null;
    
        // second.next = third;
        // second.prev = first;

        // third.next = fourth;
        // third.prev = second;

        // fourth.next = fifth;
        // fourth.prev = third;

        // fifth.next = sixth;
        // fifth.prev = fourth;

        // sixth.next = null;
        // sixth.prev = fifth;

        // head = first;
        // last = head;


// /*----------------------------Insert Node at beginning -------------------------------------- */    
        // System.out.println("Doubly Linked List before calling insert node at first");
        // printStart(head);
        // printLast(last);
        
        // head = insertFirst(head, 7);
        // head = insertFirst(head, 5);
        // head = insertFirst(head, 6);
        // head = insertFirst(head, 11);

        // System.out.println("Doubly Linked List after calling insert node at first");
        // printStart(head);
        // printLast(last);

/*----------------------------Insert Node at End -------------------------------------- */    
        System.out.println("Doubly Linked List before calling insert node at end");
        printStart(head);
        printLast(last);
        
        last = insertLast(last, 7);
        last = insertLast(last, 5);
        last = insertLast(last, 6);
        last = insertLast(last, 11);

        System.out.println("Doubly Linked List after calling insert node at end");
        printStart(head);
        printLast(last);

    }
}
