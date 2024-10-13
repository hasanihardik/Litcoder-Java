import java.util.Scanner;
import java.util.Stack;

// Implement a queue using two stacks
// change the class to main 
public class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public void dequeue() {
        if (stack2.isEmpty()) {
            transferStack1ToStack2();
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public void printFront() {
        if (stack2.isEmpty()) {
            transferStack1ToStack2();
        }
        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        }
    }

    private void transferStack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        
        String input = sc.nextLine();
        
        String[] commands = input.split(",");

        for (String command : commands) {
            String[] parts = command.split(" ");
            int queryType = Integer.parseInt(parts[0]);
            
            switch (queryType) {
                case 1: 
                    int x = Integer.parseInt(parts[1]);
                    queue.enqueue(x);
                    break;
                case 2: 
                    queue.dequeue();
                    break;
                case 3: 
                    queue.printFront();
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
