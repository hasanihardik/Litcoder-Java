import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This program processes an array of daily visitors to a park and answers queries
 * about the total number of visitors in a given range of days.
 * Time complexity: O(n + q), where n is the number of visitors and q is the number of queries.
 * 
 * Example:
 * Input:
 * visitors = [3, 7, 2, 8, 5, 9]
 * queries = (1, 4), (0, 3), (2, 5)
 * Output:
 * 22
 * 20
 * 24
 */
public class ParkVisitors {
    private static final Logger logger = Logger.getLogger(ParkVisitors.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Reading visitors array
            String visitorsInput = scanner.nextLine();
            String[] visitorsStrings = visitorsInput.split(" ");
            int[] visitors;
            try {
                visitors = new int[visitorsStrings.length];
                for (int i = 0; i < visitorsStrings.length; i++) {
                    visitors[i] = Integer.parseInt(visitorsStrings[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not in correct format or missing");
                return;
            }

            // Reading number of queries
            if (!scanner.hasNextInt()) {
                System.out.println("Input is not in correct format or missing");
                return;
            }
            int numberOfQueries = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (numberOfQueries <= 0) {
                System.out.println("Input is not in correct format or missing");
                return;
            }

            boolean foundValidQuery = false;

            // Reading and processing queries
            for (int i = 0; i < numberOfQueries; i++) {
                if (!scanner.hasNextLine()) {
                    System.out.println("Input is not in correct format or missing");
                    return;
                }

                String query = scanner.nextLine();
                String[] parts = query.split(" ");
                if (parts.length != 2) {
                    System.out.println("Input is not in correct format or missing");
                    return;
                }

                int startDay;
                int endDay;
                try {
                    startDay = Integer.parseInt(parts[0]);
                    endDay = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Input is not in correct format or missing");
                    return;
                }

                // Check boundaries
                if (startDay < 0 || endDay >= visitors.length || startDay > endDay) {
                    System.out.println("0");
                    foundValidQuery = true;
                    continue;
                }

                // Calculate the total number of visitors in the range
                int totalVisitors = 0;
                for (int j = startDay; j <= endDay; j++) {
                    totalVisitors += visitors[j];
                }

                // Print result for the current query
                System.out.println(totalVisitors);
                foundValidQuery = true;
            }

            // If no valid query was found, print "0"
            if (!foundValidQuery) {
                System.out.println("0");
            }
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}