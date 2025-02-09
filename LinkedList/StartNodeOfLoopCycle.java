class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class StartNodeOfLoopCycle {

    //Get Start Node from where the loop starts
    public static ListNode getStartNode(ListNode head, ListNode slow){

        ListNode temp = head;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }

        return temp;
    }

    //Contains cycle
    public static ListNode containsCycle(ListNode head){
        
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return getStartNode(head, slow);
            }
        }

        return null;
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
        
        ListNode startNode = containsCycle(head);
        System.out.println("Start Node : " + startNode.data);
    }
}
