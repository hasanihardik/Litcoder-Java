import java.util.Scanner;

// change the class name to Main in Litcoder
public class LegoWall {
    static final int MOD = 1000000007;

    static long modPow(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    static long[] buildWays(int m) {
        long[] ways = new long[m + 1];
        ways[0] = 1;

        for (int i = 1; i <= m; i++) {
            ways[i] = ways[i - 1];
            if (i >= 2) ways[i] = (ways[i] + ways[i - 2]) % MOD;
            if (i >= 3) ways[i] = (ways[i] + ways[i - 3]) % MOD;
            if (i >= 4) ways[i] = (ways[i] + ways[i - 4]) % MOD;
        }

        return ways;
    }

    static long legoWall(int n, int m) {
        long[] rowWays = buildWays(m);
        long[] totalWays = new long[m + 1];
        for (int i = 0; i <= m; i++) {
            totalWays[i] = modPow(rowWays[i], n, MOD);
        }

        long[] solidWays = new long[m + 1];
        solidWays[0] = 1;

        for (int width = 1; width <= m; width++) {
            solidWays[width] = totalWays[width];
            for (int j = 1; j < width; j++) {
                solidWays[width] = (solidWays[width] - solidWays[j] * totalWays[width - j] % MOD + MOD) % MOD;
            }
        }

        return solidWays[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(legoWall(n, m));
    }
}
