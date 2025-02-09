class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
} 

public class CSLinkedListDelete {
    
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

    //delete node at first
    public static ListNode deleteFirst(ListNode head){

        if(head == null){
            return null;
        }

        ListNode curr = head;
        do{
            curr = curr.next;
        }while(curr.next != head);

        curr.next = head.next;
        head.next = null;
        System.out.println("Deleted node : " + head.data);
        head = curr.next;

        return head;
    }

    //delete node at end
    public static ListNode deleteLast(ListNode head){

        if(head == null){
            return null;
        }

        if(head.next == head){
            head.next = null;
            System.out.println("Deleted Node : " + head.data);
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;
        
        do{
            prev = curr;
            curr = curr.next;
        }while(curr.next != head);

        prev.next = curr.next;
        curr.next = null;
        System.out.println("Deleted node : " + curr.data);
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
        fourth.next = first;

        head = first;

/*----------------------------Delet Node at beginning -------------------------------------- */
        // System.out.println("Circular Singly Linked List before delete node at first");
        // print(head);

        // head = deleteFirst(head);
        // head = deleteFirst(head);
        // head = deleteFirst(head);
        // head = deleteFirst(head);

        // System.out.println("Circular Singly Linked List after delete node at first");
        // print(head);

/*----------------------------Delete Node at End -------------------------------------- */
        System.out.println("Circular Singly Linked List before delete node at last");
        print(head);

        head = deleteLast(head);
        head = deleteLast(head);
        head = deleteLast(head);
        head = deleteLast(head);

        System.out.println("Circular Singly Linked List after delete node at last");
        print(head);


    }
}
