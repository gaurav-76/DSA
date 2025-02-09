public class SelectionSort {

    public void selectionSort(int[] arr){
        int n = arr.length;

        //Array is divided into 2 parts sorted and unsorted array
        //Now we find minimum element in unsorted part, 
        //and will swap minimum element with leftmost index element in unsorted array
        for(int i = 0; i < n-1; ++i){
            int minEleIdx = i;
            for(int j = i+1; j < n; ++j){
                if(arr[j] < arr[minEleIdx]){
                    minEleIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minEleIdx];
            arr[minEleIdx] = temp; 
        }
    }

    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        SelectionSort ss = new SelectionSort();
        int[] arr = {3, 1, 5, 2, 4, 6};

        System.out.print("Before Selection Sorting : ");
        ss.print(arr);

        ss.selectionSort(arr);
        System.out.print("After Selection Sorting : ");
        ss.print(arr);


    }
}
