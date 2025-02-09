class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListDelete{

    //Printing singly linked list
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //Delete first node
    public static ListNode deleteFirst(ListNode head){
        if(head == null) return null;

        ListNode temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Deleted node value : " + temp.data);
        return head;
    }

    //Delete last node
    public static ListNode deleteLast(ListNode head){
        if(head == null) return null;

        if(head.next == null){
            System.out.println("Deleted node value : " + head.data); 
            head = head.next;
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        System.out.println("Deleted node value : " + curr.data);
        return head;
    }

    //Delete at given position
    public static ListNode deletePos(ListNode head, int pos){
        if(pos == 1){
            ListNode prev = head;
            head = head.next;
            prev.next = null;
            System.out.println("Deleted node value : " + prev.data);
            return head;
        }

        ListNode prev = head;
        int count = 1;
        while(count < (pos-1)){
            prev = prev.next;
            count++;
        }

        ListNode curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
        System.out.println("Deleted node value : " + curr.data);
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

// /*----------------------------Delete Node at beginning -------------------------------------- */ 
        // System.out.println("Before calling method delete at first");
        // print(head);

        // head = deleteFirst(head);
        // head = deleteFirst(head);
        // head = deleteFirst(head);
        // //head = deleteFirst(head);

        // System.out.println("After calling method delete at first");
        // print(head);

/*----------------------------Delete Node at End -------------------------------------- */ 
        // System.out.println("Before calling method delete at end");
        // print(head);

        // head = deleteLast(head);
        // head = deleteLast(head);
        // //head = deleteLast(head);
        // //head = deleteLast(head);

        // System.out.println("After calling method delete at end");
        // print(head);

/*----------------------------Delete Node at given position -------------------------------------- */ 
        System.out.println("Before calling method delete at given position");
        print(head);

        head = deletePos(head, 3);
        head = deletePos(head, 1);
        head = deletePos(head, 2);
        head = deletePos(head, 1);

        System.out.println("After calling method delete at given positon");
        print(head);

    }
}