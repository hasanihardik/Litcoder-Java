import java.util.Arrays;
import java.util.Scanner;

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read number of jobs
        int n = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline

        // Step 2: Read job names as a space-separated string and split them into an array
        String[] jobIds = sc.nextLine().split(" ");

        // Step 3: Read deadlines as a space-separated string and convert them into an integer array
        int[] deadlines = Arrays.stream(sc.nextLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

        // Step 4: Read profits as a space-separated string and convert them into an integer array
        int[] profits = Arrays.stream(sc.nextLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();

        // Step 5: Sort jobs by profit in descending order while keeping track of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> profits[b] - profits[a]);  // Sort by profit

        // Step 6: Create an array to track the time slots and a result array for job sequencing
        boolean[] timeSlot = new boolean[n];
        String[] result = new String[n];

        // Step 7: Schedule jobs to maximize profit
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            for (int j = Math.min(n, deadlines[idx]) - 1; j >= 0; j--) {
                if (!timeSlot[j]) {
                    timeSlot[j] = true;
                    result[j] = jobIds[idx];
                    break;
                }
            }
        }

        // Step 8: Print the job sequence that maximizes profit
        for (String jobId : result) {
            if (jobId != null) {
                System.out.print(jobId + " ");
            }
        }

        sc.close();
    }
}
