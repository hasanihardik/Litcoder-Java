
import java.util.LinkedList;
import java.util.Scanner;

// change this to main function in Litcoder 
public class MergeLinkedLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        LinkedList<String> list1 = new LinkedList<>();
        for (int i = 0; i < n1; i++) {
            list1.add(scanner.next());
        }
        int n2 = scanner.nextInt();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < n2; i++) {
            list2.add(scanner.next());
        }
        LinkedList<String> mergedList = new LinkedList<>();
        int maxLength = Math.max(list1.size(), list2.size());
        for (int i = 0; i < maxLength; i++) {
            if (i < list1.size()) {
                mergedList.add(list1.get(i));
            }
            if (i < list2.size()) {
                mergedList.add(list2.get(i));
            }
        }
        for (String value : mergedList) {
            System.out.println(value);
        }
    }
}