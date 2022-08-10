package demo1;

import java.util.Scanner;

public class Test1 {

    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    public static void main(String[] args) {

    }
    //求斐波那契数列的第n项。(迭代实现)
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test1 test1 = new Test1();
        int a = test1.feiBo(n);
        System.out.println(a);
    }
    public int feiBo(int n){
        int a = 1;
        int b = 1;
        int c = 0;
        int count = 0;
        if(n >= 2){
            while(count < (n-2)){
                c = a + b;
                a = b;
                b = c;
                count++;
            }
            return c;
        }else{
            return 1;
        }
    }

    //求1！+2！+3！+4！+........+n!的和
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test1 test1 = new Test1();
        System.out.println(test1.sum(n));;
    }
    public int sum(int n){
        if(n == 1){
            return 1;
        }else{
            return factorial(n) + sum(n-1);
        }
    }

    //求 N 的阶乘 。
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Test1 test1 = new Test1();
        System.out.println(test1.factorial(n));

    }
    public int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }


    //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
    //要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        Test1 test1 = new Test1();
        int max = test1.func2(test1,a,b,c);
        System.out.println("最大值是" + max);
    }
    //三个数值中的最大值
    public int func2 (Test1 test1,int a,int b,int c){
        return func1(test1.func1(a,b),c);
    }
    //二个数值中的最大值
    public int func1(int a,int b){
        return a>b? a : b;
    }

}
