import java.util.Scanner;

class ListNode{
    public int data;
    public ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList{

    public static void print(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.data + " --> ");
            curr = curr.next;
        }
        System.out.print(" null ");
    }
    public static void main(String[] args) {
        
        ListNode head = null;
        ListNode curr = null;
        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("Want to enter elemnent in linked list?");
            System.out.print("Enter 1 for yes or -1 for no : ");
            int num = sc.nextInt();

            if(num == 1){
                System.out.print("Enter node value : ");
                int data = sc.nextInt();
                ListNode node = new ListNode(data);
                if(head == null){
                    head = node;
                    curr = node;
                }
                else{
                    curr.next = node;
                    curr = node;
                }
            }
            else{
                break;
            }
        }

        System.out.println("Singly Linked List");
        print(head);

        sc.close();
    }
}