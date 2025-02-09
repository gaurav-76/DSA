class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class RemoveCycleLoop {

    //print
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //Get Start Node from where the loop starts
    public static void removeLoop(ListNode head, ListNode slow){

        ListNode temp = head;
        while(temp.next != slow.next){
            temp = temp.next;
            slow = slow.next;
        }

        slow.next = null;
    }

    //Contains cycle or not
    public static void containsCycle(ListNode head){
        
        if(head == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                removeLoop(head, slow);
            }
        }
    }
    public static void main(String[] args) {
        ListNode head = null;

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        head = first;
        
        containsCycle(head);

        System.out.println("Linked List After removing loop : ");
        print(head);
    }
}
