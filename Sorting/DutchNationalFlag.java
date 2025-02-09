public class DutchNationalFlag{

    //LC : 75 - Sort Colors

    //i's responsibility to place 1 at mid
    //j's responsibility to place 0 at start
    //k's responsibility to place 2 at end
    public void sortColors(int[] arr){

        int i = 0, j = 0;
        int k = arr.length-1;
        while(i <= k){
            if(arr[i] == 0){
                swap(arr, i, j);
                ++i; //here we will increment i,j both becuase our 0 element placed at start, so we move further
                ++j; //so that if new 0 came, we can place
            }
            else if(arr[i] == 1){
                ++i; //we increment i 
            }
            else if(arr[i] == 2){
                swap(arr, i, k);
                --k; //we decrement k because our 2 element placed at end, now come at index k-1 , so if any 2 element came we can place
                //we are not incrementing i because we don't know with which element 2 is swapped
                //the other element can be 0 or 1, so we need to check , that's why don't increment i
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");       
        }
        System.out.println();  
    }
    public static void main(String[] args) {
        
        DutchNationalFlag sc = new DutchNationalFlag();
        int[] arr = {1, 0, 2, 2, 0, 1, 2, 1, 0};

        System.out.print("Array Before Sorting : ");
        sc.print(arr);


        sc.sortColors(arr);
        System.out.print("Array After Sorting : ");
        sc.print(arr);
    }
}