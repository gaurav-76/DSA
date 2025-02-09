class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}


public class NthNodeFromEnd {

    //print
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //nth node from end
    //assuming n is valid number
    public static ListNode getNthNode(ListNode head, int n){

        if(head == null) return null;

        ListNode temp = head;
        int count = 0;
        while(count < n){
            temp = temp.next;
            count++;
        }

        ListNode curr = head;
        while(temp != null){
            temp = temp.next;
            curr = curr.next;
        }

        return curr;
    }
    public static void main(String[] args) {
        
        ListNode head = null;

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;

        head = first;
        
        System.out.println("Linked list");
        print(head);

        ListNode nthNode = getNthNode(head, 6);
        System.out.println("Nth node from end : " + nthNode.data);
    }
}
