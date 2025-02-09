class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
} 

public class CSLinkedListInsert {
    
    //print
    public static void print(ListNode head){
        if(head == null){
            System.out.println("null");
            return;
        }

        ListNode curr = head;
        do{
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }while(curr != head);

        System.out.println("points to first node");
    }

    //insert node at first
    public static ListNode insertFirst(ListNode head, int data){

        ListNode newNode = new ListNode(data);
        if(head == null){
            newNode.next = newNode;
            head = newNode;
            return head;
        }

        ListNode curr = head;
        do{
            curr = curr.next;
        }while(curr.next != head);

        curr.next = newNode;
        newNode.next = head;
        head = curr.next;

        return head;
    }

    //insert node at end
    public static ListNode insertLast(ListNode head, int data){

        ListNode newNode = new ListNode(data);
        if(head == null){
            newNode.next = newNode;
            head = newNode;
            return head;
        }

        ListNode curr = head;
        //ListNode prev = null;
        do{
            //prev = curr;
            curr = curr.next;
        }while(curr.next != head);

        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        
        ListNode head = null;

        // ListNode first = new ListNode(1);
        // ListNode second = new ListNode(2);
        // ListNode third = new ListNode(3);
        // ListNode fourth = new ListNode(4);

        // first.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = first;

        // head = first;

/*----------------------------Insert Node at beginning -------------------------------------- */
        // System.out.println("Circular Singly Linked List before insert node at first");
        // print(head);

        // head = insertFirst(head, 5);
        // head = insertFirst(head, 6);
        // head = insertFirst(head, 7);

        // System.out.println("Circular Singly Linked List after insert node at first");
        // print(head);

/*----------------------------Insert Node at End -------------------------------------- */
        System.out.println("Circular Singly Linked List before insert node at last");
        print(head);

        head = insertLast(head, 5);
        head = insertLast(head, 6);
        head = insertLast(head, 7);

        System.out.println("Circular Singly Linked List after insert node at last");
        print(head);


    }
}
