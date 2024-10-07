import java.util.Scanner;

// change the class to main in Litcoder..
public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");
        String[] arr3 = sc.nextLine().split(" ");

        int i = 0, j = 0, k = 0;
        boolean found = false;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            int val1 = Integer.parseInt(arr1[i]);
            int val2 = Integer.parseInt(arr2[j]);
            int val3 = Integer.parseInt(arr3[k]);

            if (val1 == val2 && val2 == val3) {
                System.out.print(val1 + " ");
                i++;
                j++;
                k++;
                found = true;
            } else if (val1 < val2) i++;
            else if (val2 < val3) j++;
            else k++;
        }

        if (!found) {
            System.out.println("NO Elements");
        }
    }
}
