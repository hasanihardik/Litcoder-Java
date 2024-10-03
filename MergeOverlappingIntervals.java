import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// few errors in test cases. this code is not completely correct......
// change the class to main
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String startTimesInput = scanner.nextLine();
        String endTimesInput = scanner.nextLine();

        // Parse input
        String[] startTimesStr = startTimesInput.split(" ");
        String[] endTimesStr = endTimesInput.split(" ");

        // Check for invalid input
        if (startTimesStr.length != endTimesStr.length || startTimesStr.length == 0) {
            System.out.println("Invalid Input");
            return;
        }

        int n = startTimesStr.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        int invalidCount = 0;
        List<int[]> intervals = new ArrayList<>();

        // Read the intervals
        for (int i = 0; i < n; i++) {
            startTimes[i] = Integer.parseInt(startTimesStr[i]);
            endTimes[i] = Integer.parseInt(endTimesStr[i]);

            if (startTimes[i] >= endTimes[i]) {
                invalidCount++;
            } else {
                intervals.add(new int[]{startTimes[i], endTimes[i]});
            }
        }

        // Merge intervals
        int[][] mergedIntervals = mergeIntervals(intervals);

        // Count non-overlapping intervals
        int nonOverlappingCount = countNonOverlapping(mergedIntervals);

        // Output results
        for (int[] interval : mergedIntervals) {
            System.out.print(interval[0] + " " + interval[1] + " ");
        }
        System.out.println();
        System.out.println(nonOverlappingCount);
        System.out.println(invalidCount);
        scanner.close();
    }

    private static int[][] mergeIntervals(List<int[]> intervals) {
        if (intervals.isEmpty()) return new int[0][0];

        // Sort intervals based on the start time
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            if (current[1] >= intervals.get(i)[0]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], intervals.get(i)[1]);
            } else {
                // No overlap, add the current interval to merged list
                merged.add(current);
                current = intervals.get(i);
            }
        }
        merged.add(current); // Add the last interval

        return merged.toArray(new int[merged.size()][]);
    }

    private static int countNonOverlapping(int[][] mergedIntervals) {
        int count = 0;
        for (int i = 0; i < mergedIntervals.length; i++) {
            boolean isNonOverlapping = true;
            for (int j = 0; j < mergedIntervals.length; j++) {
                if (i != j && mergedIntervals[i][0] < mergedIntervals[j][1] && mergedIntervals[i][1] > mergedIntervals[j][0]) {
                    isNonOverlapping = false;
                    break;
                }
            }
            if (isNonOverlapping) {
                count++;
            }
        }
        return count;
    }
}
