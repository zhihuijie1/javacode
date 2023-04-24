package P1.package4;

import java.io.*;

public class Test3 {
    // 文件的赋值
    public static void main(String[] args) {
        // 源文件
        File f1 = new File("A:\\test.txt");
        // 目标文件
        File f2 = new File("A:\\T.txt");
        // 输入管和一个输出管
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(f1);
            fileWriter = new FileWriter(f2);
            // 开始动作：读动作与写动作
            char[] c = new char[5]; // 缓冲数组
            int len = fileReader.read(c); // len:有效长度
            while (len != -1) {
                fileWriter.write(c, 0, len);
                len = fileReader.read(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if(fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
