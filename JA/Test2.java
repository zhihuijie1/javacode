package P1.package4;

import java.io.*;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws IOException {
        // 1: 有一个文件 -> 创建一个File文件
        File file = new File("A:\\test.txt");
        // 2： 有一根管子，将这个管子怼到文件中 -> 创建一个FileReader对象，
        FileReader fileReader = new FileReader(file);
        // 3：有一个”吸“的操作 --> 进行读取操作
        //    一次只会读一个字符。当读到文件的结尾处，那读到是-1.
        int n = fileReader.read();
        while (n != -1) {
            System.out.print((char) n);
            n = fileReader.read();
        }
        // 4：管子不用了，要关闭管子 --> 关闭流
        // 流，数据库，网络资源，靠jvm本身没有办法帮我们关闭，此时必须程序员手动关闭：
        fileReader.close();
        System.out.println();
        method();
        method2();
    }


    public static void method() throws IOException {
        // 1:创建一个File文件
        File file = new File("A:\\test.txt");
        // 2:创建一个FileReader对象
        FileReader fileReader = new FileReader(file);
        // 3: 进行读取操作
        char[] c = new char[5];
        // 一次读取5个返回值是有效长度
        int len = fileReader.read(c);
        while(len != -1) {
            // 错误方式
            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i]); // 肝死你们,草泥马们,
            }
            // 正确方式1：
            for (int i = 0; i < len; i++) {
                System.out.print(c[i]); // 肝死你们,草泥马
            }
            // 正确方式2：
            String str = new String(c);
            System.out.print(str);

            len = fileReader.read(c);
        }
        // 4:关闭流
;       fileReader.close();
    }


    public static void method2() throws IOException {
        // 1:创建一个文件
        File file = new File("A:\\T.txt");
        // 2:创建一个FileWriter怼到文件中去
        FileWriter fileWriter = new FileWriter(file);
        // 3:写动作
        String str = "abcdefghijklmn";
        /*
        char[] c = str.toCharArray(); // 缓冲数组
        fileWriter.write(c);
         */
        fileWriter.write(str);
        // 4:关闭流
        fileWriter.close();
    }
}













