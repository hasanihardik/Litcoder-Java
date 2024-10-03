import java.util.Scanner;

// change this class to main in Litcoder platform..
public class DivisibleSumPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int divisor = scanner.nextInt();
        scanner.nextLine(); 
        
        String[] inputArray = scanner.nextLine().split(" ");
        int[] arr = new int[inputArray.length];
        
        for (int i = 0; i < inputArray.length; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
        }
        
        System.out.println(divisibleSumPairs(divisor, arr));
        
        scanner.close();
    }

    private static int divisibleSumPairs(int divisor, int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) % divisor == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
