package P1.package4;

import java.io.*;

// 字符缓冲流
public class Test5 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("A:\\TEXT\\16.txt");
        File f2 = new File("A:\\TEXT\\15.txt");

        FileReader fileReader = new FileReader(f1);
        FileWriter fileWriter = new FileWriter(f2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        /*
        // 方式一：缓冲数组
        char[] c = new char[1024];
        int len = bufferedReader.read(c);
        while (len != -1) {
            bufferedWriter.write(c, 0, len);
            len = bufferedReader.read(c);
        }
         */

        /*
        // 方式二：一个一个的读写
        int n = bufferedReader.read();
        while(n != -1) {
            bufferedWriter.write(n);
            n = bufferedReader.read();
        }
         */
        // 方式三：一行一行的读取
        String str = bufferedReader.readLine();
        while (str != null) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            str = bufferedReader.readLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}
