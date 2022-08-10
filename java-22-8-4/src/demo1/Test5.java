package demo1;

import java.util.Scanner;

public class Test5 {
    /*
    * 求出0～n之间的所有“水仙花数”并输出。
    * (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，
    * 如；153＝1^3＋5^3＋3^3，则153是一个“水仙花数“。）*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 100; i <= n; i++) {
            int nub = i;
            int count = 0;
            while(nub != 0){
                int a = nub % 10;
                count = count + a * a * a;
                nub = nub / 10;
            }
            if(count == i){
                System.out.println(i);
            }
        }
    }

    //多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
    public static void main9(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int nub = scanner.nextInt();
            for(int i = 0; i < nub; i++){
                for (int j = 0; j < nub; j++) {
                    if(i == j || i + j == nub-1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
    //输出n*n的乘法口诀表，n由用户输入。
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%2d  ",i,j,j * i);
            }
            System.out.println();
        }
    }
    //输出一个整数的每一位，如：123的每一位是3，2，1
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nub = scanner.nextInt();
        while(nub != 0){
            System.out.print(nub % 10 + " ");
            nub = nub / 10;
        }
    }
    /*
    * 编写代码模拟三次密码输入的场景。
    * 最多能输入三次密码，密码正确，提示“登录成功”,密码错误，
    * 可以重新输 入，最多输入三次。三次均错，则提示退出程序*/
    public static void main6(String[] args) {
        String s = "123456789";
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        while(count <= 3){
            if(s.equals(scanner.nextLine())){
                System.out.println("密码输入正确");
                break;
            }else{
                count++;
            }

        }
        if(count == 4){
            System.out.println("三次输入均错误");
        }

    }
    //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
    public static void main5(String[] args) {
        /*
        * 0011 1100
        * 0000 0001
        *
        * */
         Scanner scanner = new Scanner(System.in);
         int nub = scanner.nextInt();
         int i = 0;
         int flag = 0;
         int a = 0;
         for(i = 0; i < 32; i++){
             a = nub & 1;
             if(flag == 0){
                 System.out.print(a+" ");
                 flag = 1;
             }

             if(flag == 1){
                 System.out.print(a+" ");
                 flag = 0;
             }
             nub = nub >> 1;
         }
    }
    //编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static void main4(String[] args) {
        int i = 0;
        int count = 0;
        for(i = 1; i <= 100; i++){
            if(i % 10 == 9){
                count++;
            }
            if(i / 10 == 9){
                count++;
            }
        }
        System.out.println(count);
    }
    //输出 1000 - 2000 之间所有的闰年
    public static void main3(String[] args) {
        int i = 0;
        int j = 0;
        for (i = 1000; i <= 2000; i++) {
            if((i % 4 == 0 && i % 100 != 0)||(i % 400 == 0)){
                System.out.println(i);
            }
        }
    }
    //打印 1 - 100 之间所有的素数
    //(int)Math.sqrt(i)为什么不行
    public static void main2(String[] args) {
        int i = 0;
        int j = 0;
        for(i = 1; i < 101; i++){
            for(j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0) {
                    break;
                }
            }
            if(j > Math.sqrt(i)){
                System.out.println(i);
            }
        }

    }

    //判断一个数是不是素数
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nub = scanner.nextInt();
        int i = 0;
        for(i = 2; i <= (int)Math.sqrt(nub); i++){
            if(nub % i == 0){
                System.out.println(nub + "不是素数");
                break;
            }
        }
        if(i==nub){
            System.out.println(nub+ "是素数");
        }
    }
}
