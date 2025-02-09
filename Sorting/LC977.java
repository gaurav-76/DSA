public class LC977 {

    //There can be negative numbers in array
    //So if we do square of negative number, will become positive

    //Idea is that we keep 2 pointer one at 0, and another one at n-1
    //and keep ptr k at n-1 , in result arr
    
    public int[] squareOfSortedArrays(int[] arr){

        int n = arr.length;
        int[] result = new int[n];
        int i = 0, j = n-1;
        int k = n-1;

        while(k >= 0){
            if((arr[i] * arr[i]) > (arr[j] * arr[j])){
                result[k] = arr[i] * arr[i];
                ++i;
            }
            else{
                result[k] = arr[j] * arr[j];
                --j;
            }
            --k;
        }

        return result;
    }

    public void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        // Given an integer array nums sorted in non-decreasing order, return an array of the squares 
        // of each number sorted in non-decreasing order.

        // Example 1:

        // Input: nums = [-4,-1,0,3,10]
        // Output: [0,1,9,16,100]

        LC977 obj = new LC977();
        int[] arr = {-4, -1, 0, 3, 10};

        System.out.print("Before : ");
        obj.print(arr);

        arr = obj.squareOfSortedArrays(arr);
        System.out.print("After : ");
        obj.print(arr);
    }

}
