import java.util.Scanner;

public class Test5 {
    //递归求解汉诺塔问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test5 test5 = new Test5();
        char A = 'a';
        char B = 'b';
        char C = 'c';
        test5.hanNuo(n,A,B,C);
    }
    public void hanNuo(int n,char a,char b,char c){
        if(n==1){
            System.out.println("移动"+n+"从"+a+"到"+c);
        }
        else{
            hanNuo(n-1,a,c,b);
            System.out.println("移动"+n+"从"+a+"到"+c);
            hanNuo(n-1,b,a,c);
        }
    }
    //递归求斐波那契数列的第 N 项
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test5 test5 = new Test5();
        System.out.println(test5.faBo(n));
    }
    public int faBo(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return faBo(n-1) + faBo(n-2);
        }
    }
    //写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test5 test5 = new Test5();
        System.out.println(test5.summer(n));
    }
    public int summer(int n){
        if(n / 10 == 0){
            return n % 10;
        }else{
            return n % 10 + summer(n / 10);
        }
    }
    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test5 test5 = new Test5();
    }

    //递归求 1 + 2 + 3 + ... + 10
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test5 test5 = new Test5();
        System.out.println(test5.sum(n));
    }
    public int sum(int n){
        if(n == 1){
            return 1;
        }else{
            return n + sum(n-1);
        }
    }

    //递归求 N 的阶乘
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test5 test5 = new Test5();
        System.out.println(test5.factorial(n));
    }

    public int factorial(int n){
        if(n == 1){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
}
