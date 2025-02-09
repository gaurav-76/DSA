class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicate1 {

    //print
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //Removing duplicate elements
    public static ListNode removeDuplicate(ListNode head){
        
        if(head == null) return null;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        
        ListNode head = null;

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(3);
        ListNode sixth = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;

        head = first;
        
        System.out.println("Linked list containing duplicate elements");
        print(head);

        head = removeDuplicate(head);
        System.out.println("Linked list after removing duplicate elements");
        print(head);

    }   
}
