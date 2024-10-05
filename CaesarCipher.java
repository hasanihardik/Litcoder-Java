import java.util.Scanner;

// change the class to main in Litcoder
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.print("Enter a string to encrypt: ");
        String input = scanner.nextLine();
        int rotation = 4;
        
        // Encrypt the input string using the Caesar cipher
        String encrypted = caesarCipher(input, rotation);
        
        // Output the encrypted string
        System.out.println("Encrypted output: " + encrypted);
        
        // Close the scanner
        scanner.close();
    }

    public static String caesarCipher(String input, int rotation) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) ((ch - 'A' + rotation) % 26 + 'A');
                result.append(encryptedChar);
            } else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) ((ch - 'a' + rotation) % 26 + 'a');
                result.append(encryptedChar);
            } else {
                result.append(ch); // Non-alphabetic characters remain unchanged
            }
        }

        return result.toString();
    }
}
