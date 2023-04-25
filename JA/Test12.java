package P1.package4;


import java.io.*;

// 键盘录入内容输出到文件中
public class Test12 {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 1: 先准备输入方向
        // 键盘录入
        InputStream in = System.in; // 属于字节流
        //File file1 = new File("A:\\TEXT\\188.txt");
        //FileInputStream fileInputStream = new FileInputStream(file1);
        // 字节流 --> 字节缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);

        // 再准备输出方向
        File file = new File("A:\\TEXT\\122.txt");
        System.out.println(file.exists());
        //字节缓冲流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));

        // 进行操作
        byte[] bytes = new byte[1024];
        int len = bufferedInputStream.read(bytes); // 阻塞
        int count = 0;
        while (len != -1) {
            bufferedOutputStream.write(bytes);
            System.out.println(new String(bytes, 0, len));
            len = bufferedInputStream.read(bytes, 0,bytes.length);
            count++;
            if(count == 3) break;
        }
        // 关闭流
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}