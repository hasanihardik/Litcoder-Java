import java.util.Scanner;

public class pinGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbers = input.split(" ");
        StringBuilder pin = new StringBuilder();

        for (String num : numbers) {
            int singleDigit = getSingleDigitSum(num);
            if (singleDigit % 2 == 0) {
                pin.append(singleDigit);
            } else {
                pin.append((char) ('a' + (singleDigit - 1)));
            }
        }

        System.out.println(pin.toString());
    }

    private static int getSingleDigitSum(String num) {
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }
        while (sum > 9) {
            sum = sumDigits(sum);
        }
        return sum;
    }

    private static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
                           