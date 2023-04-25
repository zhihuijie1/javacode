package P1.package4;

import java.io.*;

public class Test10 {
    public static void main(String[] args) throws IOException {
        // 1: 先准备输入方向
        // 键盘录入
        InputStream in = System.in; // 属于字节流
        // 字节流 --> 字符流
        InputStreamReader inputStreamReader = new InputStreamReader(in); // 转换流
        // 字符流 --> 字符缓冲流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // 字符缓冲流

        // 2：再准备输出方向
        File file = new File("A:\\TEXT\\15.txt");
        FileWriter fileWriter = new FileWriter(file); // 字符写入流
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // 字符缓冲流

        // 3：准备操作

        String s = bufferedReader.readLine();

        while(!s.equals("exist")) {
            System.out.println("111");
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            s = bufferedReader.readLine();
        }

        // 4：关闭流
        bufferedWriter.close();
        bufferedReader.close();
    }
}
