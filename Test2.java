package P1.package2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a / b);
            // 终止当前虚拟机执行
            System.exit(0);
            return;
        } catch (ArithmeticException ex) {
            System.out.println("对不起，除数不可以为0");
        } catch (InputMismatchException ex) {
            System.out.println("对不起，你录入的数据不是int类型的数据");
        } catch (Exception ex) {
            System.out.println("对不起，你的程序出现异常");
        } finally {
            System.out.println("最后一句话");
        }
    }
}
