class QueueUsingLinkedList{
    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public QueueUsingLinkedList(){
        front = null;
        rear = null;
        length = 0;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Queue is empty!!!");
        }
        ListNode curr = front;
        while(curr != null){
            System.out.print(curr.data + " --> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public boolean isEmpty(){
        return length == 0;
    }

    //enqueue
    public void enqueue(int data){
        ListNode newNode = new ListNode(data);
        if(front == null){
            front = newNode;
        }
        else{
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    //dequeue
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty!!!");
            return;
        }

        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        System.out.println("Deleted Element : " + result);
        length--;
    }

    //front
    public int getFront(){
        if(isEmpty()) return -1;
        return front.data;
    }
    public static void main(String[] args) {
        
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        System.out.println("Front element : " + queue.getFront());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.print();
        queue.enqueue(30);
        queue.print();

        System.out.println("Front element : " + queue.getFront());
        queue.dequeue();
        System.out.println("Front element : " + queue.getFront());
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}