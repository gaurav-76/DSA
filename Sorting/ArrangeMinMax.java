public class ArrangeMinMax {

    //To solve this qsn we need to find formular which will help in getting the number
    //We knew that all greater element will come on even index
    //All smaller element will come on odd index

    //max = arr[n-1]+1
    //Even Index : arr[i] + (arr[maxIdx] % max) * max
    //Odd Index : arr[i] + (arr[minIdx] % max) * max

    //by this formula we will store both number on ith index

    public void arrangeMinMax(int[] arr){

        int n = arr.length;
        int max = arr[n-1]+1; //we always take make element arr[n-1] + 1, because if we take arr[n-1], then our remainder will be 0, due to which we will get wrong answer
        int minIdx = 0; //we knew that minimum element will start from index 0
        int maxIdx = n-1; //we knew that maximum element will start from n-1 index

        for(int i = 0; i < n; ++i){
            if(i % 2 == 0){
                //even index, we knew there should be max element, so we use even index formula
                arr[i] = arr[i] + (arr[maxIdx] % max) * max;
                maxIdx--; //we decrement maxIdx ptr
            }
            else{
                //odd index, we knew there should be min element , so we use odd index formula
                arr[i] = arr[i] + (arr[minIdx] % max) * max;
                minIdx++;
            }
        }

        //to get the original number , we will use this formula = arr[i] / max
        for(int i = 0; i < n; ++i){
            arr[i] = arr[i] / max;
        }
    }

    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        // Given a sorted array of positive integers, rearrange the array alternately 
        // i.e first element should be a maximum value, at second position minimum value, 
        // at third position second max, at fourth position second min, and so on. 

        // Examples: 

        // Input: arr[] = {1, 2, 3, 4, 5, 6, 7} 
        // Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
        // Explanation: First 7 is the max value, then 1 is the min value, then 6 is the second max value, 
        // then 2 is the second min value, then 5 is the third max value, then 3 is the third min value and 
        // at last 4 is the fourth max value.

        // Solution should be in T.C : O(N) S.C : O(1)

        ArrangeMinMax obj = new ArrangeMinMax();
        int[] arr = {2, 3, 5, 6, 8, 9};
        System.out.print("Before : ");
        obj.print(arr);

        obj.arrangeMinMax(arr);
        System.out.print("After : ");
        obj.print(arr);
    }
}
