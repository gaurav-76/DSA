public class MaxHeap{

    Integer[] heap;
    int n;

    public MaxHeap(int capacity){
        heap = new Integer[capacity+1];
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

 /*----------------------------Insert----------------------------------- */   
    public void insert(int num){
        if(n == heap.length - 1){
            resize(2*heap.length);
        }

        n++;
        heap[n] = num;
        swim(n); //here we call swim to maintain max heap property after inserting element
    }

    //Bottom Up Reheapify
    private void swim(int idx){
        while(idx > 1 && heap[idx / 2] < heap[idx]){
            int temp = heap[idx/2];
            heap[idx/2] = heap[idx];
            heap[idx] = temp;

            idx = idx / 2;
        }
    }

/*------------------------------Delete-------------------------------- */
    public void deleteMax(){
        if(isEmpty()){
            System.out.println("Max Heap Empty!!!");
            return;
        }

        int max = heap[1];

        //swapping max element with last element
        int temp = heap[n];
        heap[n] = heap[1];
        heap[1] = temp;
        
        n--;
        sink(1);
        heap[n+1] = null; //removing last node from heap

        if(n > 0 && n == (heap.length - 1) / 4){
            resize(heap.length/2);
        }

        System.out.println("Max Element : " + max);

    }    

    //Top Down Reheapify
    public void sink(int idx){ 

        while(2*idx <= n){
            int j = 2*idx;
            if(j < n && heap[j] < heap[j+1]){
                ++j;
            }

            if(heap[idx] >= heap[j]){
                break;
            }

            int temp = heap[idx];
            heap[idx] = heap[j];
            heap[j] = temp;

            idx = j;
        }
    }

/*------------------------Resize Heap---------------------- */
    public void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < heap.length; ++i){
            temp[i] = heap[i];
        }

        //now heap will point to new heap
        heap = temp;
    }


/*--------------------------------Print Heap----------------------- */
    public void printMaxHeap(){
        for(int i = 1; i <= n; ++i){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        MaxHeap pq = new MaxHeap(3);
        // System.out.println(pq.size());
        // System.out.println(pq.isEmpty());
        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);
        pq.insert(9);

        System.out.print("Max Heap : ");
        pq.printMaxHeap();

        pq.deleteMax();

        System.out.print("Max Heap : ");
        pq.printMaxHeap();

        pq.deleteMax();

        System.out.print("Max Heap : ");
        pq.printMaxHeap();
    }
}