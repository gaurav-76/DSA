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

public class DoublyLinkedList {

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
            System.out.print(last.data +  " -> ");
            last = last.prev;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        
        ListNode head = null;
        ListNode last = null;

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

        System.out.println("Linked list from start");
        printStart(head);
        
        System.out.println("Linked list from last");
        printLast(last);

    }
}
