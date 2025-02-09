public class MergeSort {

    private void mergeTwoSortedArray(int[] arr, int low, int mid, int high){
        //here we used temp array to store array element
        //because when we merge element , then we store in arr
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; ++i){
            temp[i] = arr[i];
        }

        int i = low, k = low;
        int j = mid+1;

        while(i <= mid && j <= high){
            if(temp[i] <= temp[j]){
                arr[k++] = temp[i++];
            }
            else{
                arr[k++] = temp[j++];
            }
        }

        //when right half get exhausted we insert left side element
        while(i <= mid){
            arr[k++] = temp[i++];
        }

        //we are writing code for second scenario as well in qsn : Merge 2 Sorted List/Array
        //but why we not writing code for second scenario when left half get exhausted in Merge Sort
        //because if left half get exhausted , the element at right half will be at correct place
    }
    
    public void mergeSort(int[] arr, int low, int high){

        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            mergeTwoSortedArray(arr, low, mid, high);
        }
    }

    //print
    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        MergeSort ms = new MergeSort();
        int[] arr = {3, 1, 5, 2, 4, 6};

        System.out.print("Before Merge Sorting : ");
        ms.print(arr);

        ms.mergeSort(arr, 0, arr.length-1);
        System.out.print("After Merge Sorting : ");
        ms.print(arr);
        
    }
}
