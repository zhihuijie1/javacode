package P1.package4;

import java.io.PrintStream;

public class Test8 {
    public static void main(String[] args) {
        // 打印到控制台上
        PrintStream o = System.out;
        o.print("1");
        o.print("2");
        o.print("3");
        o.print("4");
        o.println("1");
        o.println("1");
        o.println("1");

        // 就相当于
        System.out.println("1");
        System.out.print("1");
    }
}
