package P1.package4;

import java.io.*;

// 转换流实现文本文件的复制
public class Test6 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("A:\\TEXT\\16.txt");
        File f2 = new File("A:\\TEXT\\15.txt");

        // 将字节流转化为字符流
        FileInputStream fileInputStream = new FileInputStream(f1); //字节输入流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream , "utf-8"); // 字符转换流

        // 将字符流转化为字节流
        FileOutputStream fileOutputStream = new FileOutputStream(f2); // 字节输出流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK"); // 字符转换流

        char[] c = new char[1024 * 10];
        int len = inputStreamReader.read(c);
        while (len != -1) {
            outputStreamWriter.write(c);
            len = inputStreamReader.read(c);
        }

        outputStreamWriter.close();
        inputStreamReader.close();
    }
}
