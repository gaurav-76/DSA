import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryNumber1toN {

    //generate binary number from 1 to n
    // I/P : 4
    // O/P : "1" "10" "11" "100"


    /*
        Intution : First push 1, then append 0 , then 1 and continue this process
                           1
            append 0   /        \   append 1
                      10         11
                 a0  /  \ a1  a0/  \  a1
                    100 101    110   111

    */

    public static String[] generateBinaryNumber(int n){
        String[] result = new String[n];

        Queue<String> que = new LinkedList<>();
        que.offer("1");
        for(int i = 0; i < n; ++i){
            result[i] = que.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            que.offer(n1);
            que.offer(n2);
        }

        return result;
    }

    public static void print(String[] result){
        for(String str : result){
            System.out.print(str + " ");
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number n : ");
        int n = sc.nextInt();

        String[] result = generateBinaryNumber(n);
        print(result);
    }
}
