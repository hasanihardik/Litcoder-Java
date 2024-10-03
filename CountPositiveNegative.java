import java.util.*;
// change to main class in Litcoder

public class CountPositiveNegative {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[5];
        for(int i=0;i<n;i++){
            arr[i]= input.nextInt();
        }
        doSomething(n, arr);        
    }
    
    public static void doSomething(int n, int[] arr) {
        int pCount =0;
        int nCount=0;
        int zCount=0;
        for(int i=0;i<n;i++){
            if(arr[i]>0) pCount++;
            else if(arr[i]<0) nCount++;
            else zCount++;
        }
        double res1 = (double)pCount/n;
        double res2 = (double)nCount/n;
        double res3 = (double)zCount/n;
        System.out.println(String.format("%.3f",res1));
        System.out.println(String.format("%.3f",res2));
        System.out.println(String.format("%.3f",res3));
    }
}
                                                                                                                            