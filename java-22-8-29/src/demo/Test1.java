package demo;

import java.util.Scanner;

public class Test1 {
    //编写一个程序求ax^2+bx+c=0的根
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("求"+a+"x^2"+"+"+b+"x"+"+"+c+"=0的根");
        if(b*b - 4*a*c >= 0){
            double d = (-b+Math.sqrt(b*b - 4*a*c))/(2*a);
            double e = (-b-Math.sqrt(b*b - 4*a*c))/(2*a);
            if(d != e){
                System.out.println(d );
                System.out.println(e);
            }else{
                System.out.println(d);
            }
        }else{
            System.out.println("无解");
        }
    }


    //计算1！+2！+  n!
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += func1(i);
        }
        System.out.println(sum);
    }
    public static int func1(int n){
        if(n == 1){
            return 1;
        }else{
            return n * func1(n-1);
        }
    }


    //1 - n 中素数的个数
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i =1; i <= n; i++) {
            if(func(i) == 1){
                count++;
            }
        }
        System.out.println(count);

    }
    public static int func(int n){
        int i = 0;
        if(n == 1){
            return 0;
        } else{
            for (i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0){
                    break;
                }
            }
            if(i > Math.sqrt(n)){
                return 1;
            }
        }
        return 0;
    }

    //求1-n的连续整数和
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
