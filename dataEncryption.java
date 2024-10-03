import java.util.Scanner;
// change to main class in Litcoder platform
public class dataEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();

        if (!input.matches("-?\\d+")) {
            System.out.println("Enter only integer value");
            return;
        }
        if(input.startsWith("-")){
            System.out.println("Enter positive 4-digit integer");
            return;
        }

        if (input.length() < 4) {
            System.out.println("Provided input is less than 4, enter four digit integers");
            return;
        }
        
        if (input.length() > 4) {
            System.out.println("Provided input is more than 4, enter four digit integers");
            return;
        }

        int number = Integer.parseInt(input);

        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = (Character.getNumericValue(input.charAt(i)) + 5) % 10;
        }

        int temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;

        for (int digit : digits) {
            System.out.print(digit);
        }
    }
}
                                                                                                                            