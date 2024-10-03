import java.util.HashSet;
import java.util.Scanner;

// change to main class in Litcoder platform
class ZeroSumSubarray{

    private static final String SIZE_ERROR = "Array size must be between 1 and 10";
    private static final String ELEMENT_RANGE_ERROR = "Array elements must be from -10 to 10";
    private static final String ELEMENT_TYPE_ERROR = "Array elements must be integers";
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();

        String[] strArr = input.split(" ");
        int n = strArr.length;
        if (n < 1 || n > 10) {
            System.out.println(SIZE_ERROR);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            try {
                arr[i] = Integer.parseInt(strArr[i]);
                if (arr[i] < -10 || arr[i] > 10) {
                    System.out.println(ELEMENT_RANGE_ERROR);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println(ELEMENT_TYPE_ERROR);
                return;
            }
        }

        if (hasZeroSumSubarray(arr)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        System.out.println(arr.length);
    }
    private static boolean hasZeroSumSubarray(int[] arr) {
        HashSet<Integer> sumSet = new HashSet<>();
        int cumulativeSum = 0;

        for (int value : arr) {
            cumulativeSum += value;

            if (cumulativeSum == 0 || sumSet.contains(cumulativeSum)) {
                return true;
            }
            sumSet.add(cumulativeSum);
        }
        return false;
    }
}
                                                                                                                            