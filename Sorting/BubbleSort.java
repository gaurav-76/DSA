public class BubbleSort{

    //Normal bubble sorting
    public void bubbleSort1(int[] arr){

        int n = arr.length;
        for(int i = 0; i < n-1; ++i){
            //System.out.print("Pass ");
            for(int j = 0; j < n-i-1; ++j){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //System.out.println();
    }

    // //Optimized bubble sorting 
    // //T.C : O(N*N)
    public void bubbleSort2(int[] arr){

        int n = arr.length;
        for(int i = 0; i < n-1; ++i){
            
            //System.out.print("Pass ");
            boolean isSwapped = false;
            
            for(int j = 0; j < n-i-1; ++j){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }

            //minor optimization
            //if swap doesn't happen means the array is sorted
            //so we break from current loop
            if(isSwapped == false) break;
        }

        //System.out.println();
    }


    //Printing array
    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        BubbleSort bs = new BubbleSort();
        int[] arr = {3, 1, 5, 2, 6, 4};

        //In bubble sort , after each pass/iteration
        //the greater element got placed at last in array
        System.out.print("Before Bubble Sorting : ");
        bs.print(arr);

        bs.bubbleSort2(arr);
        System.out.print("After Bubble Sorting : ");
        bs.print(arr);
        
    }
}