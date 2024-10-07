import java.util.Scanner;

// change the class to main in Litcoder..
public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] arr = new long[n + 1];

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            arr[start - 1] += value;
            if (end < n) {
                arr[end] -= value;
            }
        }

        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
        sc.close();
    }
}
