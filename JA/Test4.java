package P1.package4;

import java.io.*;
// 字节缓冲流
public class Test4 {
    public static void main(String[] args) throws IOException {
        // 1:创建一个源文件与一个目标文件
        File f1 = new File("A:\\TEXT\\1.1.jpg");
        File f2 = new File("A:\\TEXT\\1.2.jpg");
        // 2:创建字节流，读取字节流与写入字节流
        FileInputStream fileInputStream = new FileInputStream(f1);
        FileOutputStream fileOutputStream = new FileOutputStream(f2);
        // 3:功能加强
        // FileInputStream外面套一个管子
        // fileOutputStream外面套一个管子
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        // 4:进行传输动作
        long a = System.currentTimeMillis();
        byte[] bytes = new byte[1024]; // 缓冲数组
        int len = bufferedInputStream.read(bytes); // 返回的是有效长度
        while(len != -1) {
            bufferedOutputStream.write(bytes,0,len);
            len = bufferedInputStream.read(bytes);
        }
        long b = System.currentTimeMillis();
        System.out.println(b-a); // 6
        // 4:关闭流
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
