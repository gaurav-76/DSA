class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicate2 {

    //print
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //Removing duplicate elements
    //we are removing entire elements if that element duplicates are present
    public static ListNode removeDuplicate(ListNode head){
        
        if(head == null) return null;

        //we can also use dummy node concept
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null && curr.next != null) {
            if(curr.data == curr.next.data){
                while(curr.next != null && curr.data == curr.next.data){
                    curr = curr.next;
                }
                //if head pointing to duplicate nodes
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

