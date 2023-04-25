package P1.package4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) throws IOException {
        // 标准的输入流
        InputStream in = System.in;
        // read方法等待键盘的录入，这是一个阻塞方法。
        // system.in这个管怼到键盘上，所以你从键盘上录入的化，就会从这个管到程序中。
        int n = in.read(); // a
        System.out.println(n); // 97
        // Scanner就是一个扫描器，扫描从这个管出来的数据。
        // Scanner scanner = new Scanner(System.in);
        File file = new File("A:\\TEXT\\16.txt");
        Scanner sc = new Scanner(new FileInputStream(file));
        while(sc.hasNext()) {
            System.out.println(sc.nextLine()); // 读取下一个单词并返回这一单词。
        }
    }
}
