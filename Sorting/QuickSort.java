public class QuickSort{

    //doing partition between range [low, high]
    //this partition method will place all smaller element at left of pivot and larger element at right of pivot
    private int partition(int[] arr, int low, int high){

        int pivot = high; //we take last element of array as pivot
        int i = low, j = low;

        while(i <= high){
            if(arr[i] <= arr[pivot]){ 
                //if element <= arr[pivot] we swap, as all element left to j-1 , 
                //will be <= arr[pivot] also we increment as we have placed element <= pivot at idx j
                swap(arr, i, j);
                ++j;
            }
            ++i; 
        }
        return j-1; //we return pivot element index
    }
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high); //we got pivot fixed at correct index
            quickSort(arr, low, p-1); //now we pass new range pivot's left array
            quickSort(arr, p+1, high); //now we pass new range pivot's right array
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //print method
    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        QuickSort qs = new QuickSort();

        int[] arr = {9, -3, 5, 2, 6, 8, -6, 1, 3};

        System.out.print("Before Quick Sorting : ");
        qs.print(arr);

        qs.quickSort(arr, 0, arr.length-1);
        
        System.out.print("After Quick Sorting : ");
        qs.print(arr);
    }
}