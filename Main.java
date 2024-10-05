import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String charlieInput = scanner.nextLine();
        String daveInput = scanner.nextLine();

        String[] charlieScoresStr = charlieInput.split(" ");
        String[] daveScoresStr = daveInput.split(" ");

        int charliePoints = 0;
        int davePoints = 0;

        int len = Math.min(charlieScoresStr.length, daveScoresStr.length); 
        for (int i = 0; i < len; i++) {
            int charlieScore = Integer.parseInt(charlieScoresStr[i]);
            int daveScore = Integer.parseInt(daveScoresStr[i]);

            if (charlieScore > daveScore) {
                charliePoints++;
            } else if (charlieScore < daveScore) {
                davePoints++;
            }
        }

        System.out.println(charliePoints + " " + davePoints);
    }
}