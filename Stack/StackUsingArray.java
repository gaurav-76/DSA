public class StackUsingArray {

    int top;
    int[] arr;

    StackUsingArray(){
        this(10);
    }
    
    StackUsingArray(int capacity){
        top = -1;
        arr = new int[capacity];
    }

    public void push(int val){
        if(isFull()){
            throw new RuntimeException("Stack is Full !!!");
        }
        top++;
        arr[top] = val;
        System.out.println("Element pushed : " + arr[top]);
    }

    public boolean isFull() { return arr.length == size(); }

    public int size() { return top+1; }

    public void pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty !!!");
        }

        int result = arr[top];
        top--;
        System.out.println("Popped Element : " + result);
    }

    public boolean isEmpty() { return top < 0; }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty !!!");
        }
        return arr[top];
    }
    public static void main(String[] args) {
        
        StackUsingArray stack = new StackUsingArray();
        stack.push(10);
        stack.push(5);
        System.out.println("Top Element : " + stack.peek());
        stack.pop();
        System.out.println("Top Element : " + stack.peek());
        stack.push(15);
        stack.push(35);
        stack.push(45);
        System.out.println("Top Element : " + stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
