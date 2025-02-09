public class InsertionSort{

    public void insertionSort(int[] arr){
        int n = arr.length;

        //element at 0th index will always be sorted
        //that's why we will start from index 1
        for(int i = 1; i < n; ++i){//unsorted part
            int temp = arr[i];
            int j = i-1; // 0 to i-1 sorted part
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = temp;
        }
    }

    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        InsertionSort is = new InsertionSort();
        int[] arr = {3, 1, 5, 2, 6, 4};

        System.out.print("Before Insertion Sorting : ");
        is.print(arr);

        is.insertionSort(arr);
        System.out.print("After Insertion Sorting : ");
        is.print(arr);
    }
}