package Demo;

import java.util.Scanner;

public class Test {
    //最大公约数
    public static void main(String[] args) {
                                         //之辗转相除法
        Scanner scanner = new Scanner(System.in);
        int n = 18;
        int m = 24;
        int c = m % n;
        while(c != 0){
            m = n;
            n = c;
            c = m % n;
        }
        System.out.println(n);

    }
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int y = m<n ? m : n;
        for (int i = y; i > 0; i--) {
            if(m % i == 0 && n % i == 0){
                System.out.println("最大公约数是"+ i);
                break;
            }
        }
    }

    //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 31; i >= 1; i = i-2){
            int m = i;
            System.out.print((n >> i) & 1);
        }
        System.out.println();
        for (int i = 30; i >= 0; i = i-2) {
            int m = i;
            System.out.print((n >> i) & 1);
        }
    }
    //打印X型图案
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int i = 0;
            int j = 0;
            for (i = 0; i < num; i++) {
                for (j = 0; j < num; j++) {
                    if(i == j || i + j == num-1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                //一行弄完了再弄下一行
                System.out.println();
            }
        }
    }

    //水仙花数的拓展
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            int count = 0;
            int n = i;
            //几位数
            while(n != 0){
                n = n / 10;
                count ++;
            }
            //计算幂次方和
            int sum = 0;
            n = i;
            while(n != 0){
                sum = sum + (int)Math.pow(n % 10,count);
                n = n / 10;
            }
            if(sum == i){
                System.out.println(i);
            }
        }


    }
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
    public static void main4(String[] args) {
        int flag = 1;
        double count = 0;
        for (int i = 1; i < 101; i++) {
            count = count + (1.0/i) * flag;
            flag = flag * -1;
        }
        System.out.println(count);
    }

    //二进制1的个数。
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count ++;
        }
        System.out.println(count);
    }

    public static void mai2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count ++;
            }
            n = n >>> 1;
        }
        System.out.println(count);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }
}
