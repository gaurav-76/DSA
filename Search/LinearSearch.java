public class LinearSearch{

    //Linear Search
    public void  linearSearch(int[] arr, int key){

        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == key){
                System.out.println("Element found at index : " + i);
                return;
            }
        }
        System.out.println("Element not found!!!");
    }
    public static void main(String[] args) {
        
        LinearSearch ls = new LinearSearch();
        int[] arr = {13, 45, 1, 86, 34, 20, 10, 34};

        ls.linearSearch(arr, 186);
    }
}