
import java.util.Scanner;
// change to main class in Litcoder platform    
public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int n = Integer.parseInt(inputArray[0]);
        int[] sightings = new int[n];

        for (int i = 0; i < n; i++) {
            sightings[i] = Integer.parseInt(inputArray[i + 1]);
        }

        System.out.println(mostCommonPlant(sightings));
        scanner.close();
    }

    private static int mostCommonPlant(int[] sightings) {
        int[] count = new int[100];  // Assuming plant IDs range from 1 to 100
        for (int id : sightings) {
            count[id]++;
        }

        int maxCount = 0;
        int resultId = Integer.MAX_VALUE;

        for (int i = 1; i < count.length; i++) {
            if (count[i] > maxCount || (count[i] == maxCount && i < resultId)) {
                maxCount = count[i];
                resultId = i;
            }
        }

        return resultId;
    }
}
