import java.util.PriorityQueue;
import java.util.Scanner;

public class CandiesSweetness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int target = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        
        String[] candies = sc.nextLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String candy : candies) {
            pq.offer(Integer.parseInt(candy));
        }

        int steps = 0;
        while (pq.size() > 1 && pq.peek() < target) {
            int least = pq.poll();
            int secondLeast = pq.poll();
            int newSweetness = least + 2 * secondLeast;
            pq.offer(newSweetness);
            steps++;
        }

        if (pq.peek() >= target) {
            System.out.println(steps);
        } else {
            System.out.println(-1);
        }
    }
}
