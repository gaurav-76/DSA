class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class RemoveGivenKeyAllOccu {

    //print
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //Removing given key from linked list
    public static ListNode removeGivenKey(ListNode head, int key){

        if(head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            if(curr.data == key){
                if(prev == null){
                    head = curr.next;
                }
                else{
                    prev.next = curr.next;
                }
            }
            else{
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
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
        sixth.next = null;

        head = first;
        
        System.out.println("Linked list before removing the given key all occurences");
        print(head);

        head = removeGivenKey(head, 2);
        System.out.println("Linked list after removing the given key occurences");
        print(head);
    }
}