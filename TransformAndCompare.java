import java.util.Scanner;

public class TransformAndCompare {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }

        int i = 0, j = 0;
        int n = start.length();

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                if (start.charAt(i) == 'L' && i < j) {
                    return false;
                }
                if (start.charAt(i) == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }
        }

        while (i < n && start.charAt(i) == 'X') {
            i++;
        }
        while (j < n && end.charAt(j) == 'X') {
            j++;
        }

        return i == n && j == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String start = sc.nextLine();

        String end = sc.nextLine();
        
        TransformAndCompare obj = new TransformAndCompare();
        boolean result = obj.canTransform(start, end);

        System.out.println(result);
    }
}
