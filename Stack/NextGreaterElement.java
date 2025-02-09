import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {

    public static ArrayList<Integer> nextGreaterElement(int[] arr){

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>(n);
        
        //initialization with -1
        for(int i = 0; i < n; ++i){
            result.add(-1);
        }
        
        for(int i = n-1; i >= 0; --i){
            while(!st.empty() && st.peek() <= arr[i]){
                st.pop();
            }

            if(!st.empty()){
                result.set(i, st.peek());
            }

            st.push(arr[i]);
        }

        return result;
    } 
    public static void main(String[] args) {
        
        int[] arr = {32, 67, 45, 76, 89, 9, 90, 11, 32, 23, 56};

        ArrayList<Integer> result = nextGreaterElement(arr);

        System.out.println("Next Greater Element to Right Side");
        
        for(int i = 0; i < arr.length; ++i){
            System.out.println(arr[i] + " : " + result.get(i));
        }

    }
}
