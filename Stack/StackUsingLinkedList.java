import java.util.EmptyStackException;

public class StackUsingLinkedList {

    private int length;
    private ListNode top;

    private class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    StackUsingLinkedList(){
        length = 0;
        top = null;
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = top;
        top = newNode;
        length++;
        System.out.println("Element Pushed : " + val);
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;
        length--;
        System.out.println("Popped Element : " + result);
        return;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    public static void main(String[] args) {
        
        StackUsingLinkedList stack = new StackUsingLinkedList();
        //stack.pop();
        stack.push(10);
        stack.push(50);
        stack.push(90);
        System.out.println("Length : " + stack.getLength());
        System.out.println("Top Element : " + stack.peek());
        stack.push(20);
        stack.push(40);
        System.out.println("Top Element : " + stack.peek());
        stack.pop();
        System.out.println("Length : " + stack.getLength());
        System.out.println("Top Element : " + stack.peek());
    }
}
