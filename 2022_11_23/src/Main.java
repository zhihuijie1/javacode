import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //滑动窗口算法
        int left = 0;
        int count = 0;
        int right = left + 1;
        while(right < arr.length - 1 && left < arr.length) {
            if(arr[right] >= arr[left] && arr[right+1] >= arr[right]) {
                left++;
                right = left + 1;
            }else if(arr[right] <= arr[left] && arr[right+1] <= arr[right]) {
                left++;
                right = left + 1;
            }else {
                count++;
                left = right + 1;
                right = left + 1;
            }
        }
        count++;
        System.out.println(count);
    }
}















