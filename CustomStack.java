import java.util.Scanner;
import java.util.Stack;

public class CustomStack {
    private StringBuilder text;
    private Stack<String> undoStack;

    public CustomStack() {
        text = new StringBuilder();
        undoStack = new Stack<>();
    }

    public void insert(String value) {
        undoStack.push(text.toString());
        text.append(value);
    }

    public void delete(int value) {
        undoStack.push(text.toString());
        text.delete(text.length() - value, text.length());
    }

    public void get(int index) {
        System.out.println(text.charAt(index - 1));
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            text = new StringBuilder(undoStack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomStack editor = new CustomStack();
        String[] commands = sc.nextLine().split(",");

        for (String command : commands) {
            if (command.startsWith("1")) {
                String value = command.substring(2);
                editor.insert(value);
            } else if (command.startsWith("2")) {
                int value = Integer.parseInt(command.substring(2));
                editor.delete(value);
            } else if (command.startsWith("3")) {
                int value = Integer.parseInt(command.substring(2));
                editor.get(value);
            } else if (command.equals("4")) {
                editor.undo();
            }
        }
    }
}
