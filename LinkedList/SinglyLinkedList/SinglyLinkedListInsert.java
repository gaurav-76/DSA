class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}


public class SinglyLinkedListInsert{

    //Printing singly linked list
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //Insert node at begining
    public static ListNode insertFirst(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    //Insert node at end
    public static ListNode insertLast(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return head;
        }

        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    //Insert node at given position
    public static ListNode insertPos(ListNode head, int data, int pos){

        ListNode newNode = new ListNode(data);
        
        if(pos == 1){
            newNode.next = head;
            head = newNode;
            return head;
        }
        
        ListNode prev = head;
        int cnt = 1;

        while(prev != null && cnt < (pos-1)){
            prev = prev.next;
            cnt++;
        }
        
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        
        ListNode head = null;

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        head = first;

        System.out.println("Singly Linked List");
        print(head);


    /*----------------------------Insert Node at beginning -------------------------------------- */    
        // System.out.println("Singly Linked List before calling insert node at first");
        // print(head);
        
        // head = insertFirst(head, 7);
        // head = insertFirst(head, 5);
        // head = insertFirst(head, 6);

        // System.out.println("Singly Linked List after calling insert node at first");
        // print(head);

    /*----------------------------Insert Node at last -------------------------------------- */    
        // System.out.println("Singly Linked List before calling insert node at last");
        // print(head);
        
        // head = insertLast(head, 7);
        // head = insertLast(head, 5);
        // head = insertLast(head, 6);

        // System.out.println("Singly Linked List after calling insert node at last");
        // print(head);

/*----------------------------Insert Node at given position -------------------------------------- */    
        // System.out.println("Singly Linked List before calling insert node at given position");
        // print(head);
            
        // head = insertPos(head, 7, 3);
        // head = insertPos(head, 5, 1);
        // head = insertPos(head, 6, 7);
    
        // System.out.println("Singly Linked List after calling insert node at given position");
        // print(head);



    }
}