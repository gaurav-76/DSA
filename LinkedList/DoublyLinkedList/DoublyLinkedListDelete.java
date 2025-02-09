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

public class DoublyLinkedListDelete {

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

    //Deleting first node
    public static ListNode deleteFirst(ListNode head){

        ListNode curr = head;    
        if(head == last){
            last = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }

        curr.next = null;
        System.out.println("Deleted node : " + curr.data);
        return head;
    }

    //Deleting last node
    public static ListNode deleteLast(ListNode last){

        ListNode curr = last;    
        if(last == head){
            head = null;
        }
        else{
            last = last.prev;
            last.next = null;
        }

        curr.prev = null;
        System.out.println("Deleted node : " + curr.data);
        return last;
    }

    public static void main(String[] args) {
        
        

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(3);

        first.next = second;
        first.prev = null;
    
        second.next = third;
        second.prev = first;

        third.next = fourth;
        third.prev = second;

        fourth.next = fifth;
        fourth.prev = third;

        fifth.next = sixth;
        fifth.prev = fourth;

        sixth.next = null;
        sixth.prev = fifth;

        head = first;
        last = sixth;

/*----------------------------Delete Node at beginning -------------------------------------- */
        // System.out.println("Doubly linked list before calling delete at first");
        // printStart(head);
        // printLast(last);
        
        // head = deleteFirst(head);
        // head = deleteFirst(head);
        // head = deleteFirst(head);

        // System.out.println("Doubly linked list after calling delete at first");
        // printStart(head);
        // printLast(last);

/*----------------------------Delete Node at End -------------------------------------- */
        System.out.println("Doubly linked list before calling delete at last");
        printStart(head);
        printLast(last);
        
        last = deleteLast(last);
        last = deleteLast(last);
        last = deleteLast(last);

        System.out.println("Doubly linked list after calling delete at last");
        printStart(head);
        printLast(last);
    }
}
