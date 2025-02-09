class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
} 

public class CSLinkedList {
    
    //print
    public static void print(ListNode head){
        ListNode curr = head;
        do{
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }while(curr != head);

        System.out.println("points to first node");
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

        System.out.println("Circular Singly Linked List");
        print(head);
    }
}
