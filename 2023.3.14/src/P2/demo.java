package P2;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(func(n));
    }

    public static int func(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        if(n == 2) {
            return 2;
        }
        return func(n-1) + func(n-2);
    }
}
