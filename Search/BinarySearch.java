public class BinarySearch{

    public void binarySearch(int[] arr, int key){

        int low = 0;
        int high = arr.length-1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == key){
                System.out.println("Element found at index : " + mid);
                return;
            }
            else if(arr[mid] < key){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        System.out.println("Element not found!!!");
    }
    public static void main(String[] args) {
        
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 22, 29, 34, 46, 57, 98};
        bs.binarySearch(arr, 134);
    }
}