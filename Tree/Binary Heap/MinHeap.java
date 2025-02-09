public class MinHeap {
    Integer[] minHeap;
    int n;

    public MinHeap(int capacity){
        minHeap = new Integer[capacity+1]; //we will fill element from 1 that's why we taking size+1
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

/*--------------------------Insert in Min Heap----------------- */
    public void insert(int num){

        if(n == minHeap.length-1){
            resize(minHeap.length * 2);
        }

        ++n;
        minHeap[n] = num;
        swim(n); //bottom up reheapify
    }

    //Bottom Up Reheapify
    public void swim(int idx){
        while(idx > 1 && minHeap[idx/2] > minHeap[idx]){
            swap(idx/2, idx);
            idx = idx/2;
        }
    }

/*------------------------------Delete Min-------------------------- */
    public void deleteMin(){
        if(isEmpty()){
            System.out.println("Min Heap is empty!!!");
            return;
        }

        int min = minHeap[1];//we knew that at index 1 minimum element will be there
        swap(1, n);
        n--; //element is deleted so we need to decrement the length

        sink(1);
        minHeap[n+1] = null; //as we have swapped the element
        
        if(n > 0 && n == (minHeap.length - 1) / 4){
            resize(minHeap.length/2);
        }

        System.out.println("Minimum Element in min heap : " + min);
    }

    //Top Down Reheapify
    public void sink(int idx){
        while(idx*2 <= n){
            int j = idx*2;
            if(j < n && minHeap[j] > minHeap[j+1]){
                ++j;
            }

            if(minHeap[idx] <= minHeap[j]){
                break;
            }

            swap(idx, j);
            idx = j;
        }
    }

    //swapping element (this method will be called by swim and sink)
    public void swap(int i, int j){
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    //resizing the minHeap (this method will be called by swim and sink)
    public void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < minHeap.length; ++i){
            temp[i] = minHeap[i];
        }

        minHeap = temp;
    }

/*--------------------------------Print Heap----------------------- */
    public void printMinHeap(){
        for(int i = 1; i <= n; ++i){
            System.out.print(minHeap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        MinHeap pq = new MinHeap(3);
        // System.out.println(pq.size());
        // System.out.println(pq.isEmpty());

        pq.insert(3);
        pq.insert(7);
        pq.insert(5);
        pq.insert(8);
        pq.insert(1);
        pq.insert(2);
        pq.insert(-5);

        System.out.print("Min Heap : ");
        pq.printMinHeap();

        pq.deleteMin();
        pq.deleteMin();

        System.out.print("Min Heap : ");
        pq.printMinHeap();
    }
}
