import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = findMax(arr);
        System.out.println(max);
    }
    public static int findMax(int[] arr) {
        int Max = arr[0];
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int max = arr[i];
            sum = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                sum = sum + arr[j];
                if(sum > max) {
                    max = sum;
                }
            }
            if(max > Max) {
                Max = max;
            }
        }
        return Max;
    }
}
