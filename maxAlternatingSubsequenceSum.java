import java.util.Scanner;

// this code is not completely correct.... 
class Main {
    public static long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        long evenSum = 0;
        long oddSum = 0; 

        for (int num : nums) {
            long newEvenSum = Math.max(evenSum, oddSum + num); 
            long newOddSum = Math.max(oddSum, evenSum - num);  
            
            evenSum = newEvenSum;
            oddSum = newOddSum;
        }

        return evenSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int[] nums = new int[n];

        
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxAlternatingSum(nums));

        scanner.close();
    }
}