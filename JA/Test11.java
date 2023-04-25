package P1.package4;

import java.io.*;

// 键盘录入内容输出到文件中
public class Test11 {

    public static void main(String[] args) throws IOException {
        // 准备输入方向
        InputStream in = System.in; // 属于标准输入流
        // 使用缓冲流提高效率
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);

        // 准备输出方向
        File file = new File("A:\\TEXT\\122.txt");
        System.out.println(file.exists());
        // 使用缓冲流提高效率
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));

        // 进行操作
        byte[] bytes = new byte[1024];
        int len;
        int count = 0;
        while ((len = bufferedInputStream.read(bytes, 0, 1024)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
            System.out.println(new String(bytes, 0, len));
            count++;
            if(count == 2){
                break;
            }
        }

        // 关闭流（建议使用try-with-resources语句块）
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
