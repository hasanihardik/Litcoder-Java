import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// change to main class in Litcoder
public class SpecialPrime {
    private static final int MAX = 1000000;
    private static boolean[] isPrime = new boolean[MAX];
    private static List<Integer> specialPrimes = new ArrayList<>();

    static {
        sieveOfEratosthenes();
        generateSpecialPrimes();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findLargestSpecialPrime(n));
        scanner.close();
    }

    private static int findLargestSpecialPrime(int n) {
        int low = 0, high = specialPrimes.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (specialPrimes.get(mid) < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high >= 0 ? specialPrimes.get(high) : -1;
    }

    private static void generateSpecialPrimes() {
        for (int i = 2; i < MAX; i++) {
            if (isPrime[i] && isSpecialPrime(i)) {
                specialPrimes.add(i);
            }
        }
    }

    private static boolean isSpecialPrime(int num) {
        String numStr = String.valueOf(num);
        return isSpecialPrimeHelper(numStr, 0);
    }

    private static boolean isSpecialPrimeHelper(String numStr, int index) {
        if (index == numStr.length()) return true;
        for (int i = index + 1; i <= numStr.length(); i++) {
            int subNum = Integer.parseInt(numStr.substring(index, i));
            if (!isPrime[subNum]) return false;
        }
        return true;
    }

    private static void sieveOfEratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) isPrime[j] = false;
            }
        }
    }
}
                                                                                                                            