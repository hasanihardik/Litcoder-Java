import java.util.*;

public class StockCombinationFinder {

    // Helper function to find all combinations
    private static void findCombinations(int[] prices, int[] quantities, int index, int budget, int target, List<int[]> results) {
        if (budget == target) {
            results.add(quantities.clone());
            return;
        }
        if (index >= prices.length || budget > target) {
            return;
        }

        for (int i = 0; i <= 5; i++) {
            if (budget + (i * prices[index]) > target) break;  // Optimization
            quantities[index] = i;
            findCombinations(prices, quantities, index + 1, budget + (i * prices[index]), target, results);
        }
        quantities[index] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input budget and number of stocks
            System.out.print("Enter your maximum budget: ");
            int budget = Integer.parseInt(sc.nextLine());
            if (budget <= 0) {
                System.out.println("Invalid input");
                return;
            }

            System.out.print("Enter the number of stocks: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("Invalid input");
                return;
            }

            // Input stock names and prices
            String[] names = new String[n];
            int[] prices = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter stock name and price (space-separated): ");
                String[] stockInput = sc.nextLine().split(" ");
                if (stockInput.length != 2 || !isNumeric(stockInput[1])) {
                    System.out.println("Invalid input");
                    return;
                }
                names[i] = stockInput[0];
                prices[i] = Integer.parseInt(stockInput[1]);
                
                // Validation for negative prices or prices higher than budget
                if (prices[i] <= 0) {
                    System.out.println("The stock prices should be at least greater than 0");
                    return;
                }
                if (prices[i] > budget) {
                    System.out.println("One of the stock prices is higher than the target price");
                    return;
                }
            }

            // Find and print combinations
            List<int[]> results = new ArrayList<>();
            findCombinations(prices, new int[n], 0, 0, budget, results);

            // Sort combinations in lexicographical order
            results.sort(Comparator.comparing(Arrays::toString));

            // Print the results
            for (int[] result : results) {
                System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
            }

            System.out.println("Total valid combinations: " + results.size());

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    // Helper function to check if a string is a numeric value
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
