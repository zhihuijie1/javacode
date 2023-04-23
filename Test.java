package P1.package4;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        // File.separator:获取当前操作系统的拼接符。
        // File f = new File("A:" + File.separator + "TEXT" + File.separator + "11.docx");
        // File f1 = new File("A:" + File.separator + "TEXT" + File.separator + "11.docx");
        File f = new File("A:\\TEXT\\11.docx");
        File f1 = new File("A:\\TEXT\\11.docx");
        File f2 = new File("A:\\TEXT\\12.docx"); // 随便写的一个目录
        // 文件是否可读/文件是否可写
        System.out.println(f.canRead()); // true
        System.out.println(f.canWrite()); // true
        System.out.println(f2.canWrite()); // false
        System.out.println(f2.canRead()); // false

        // 获取文件的名字
        System.out.println(f.getName()); // 11.docx
        System.out.println(f1.getName()); // 11.docx
        System.out.println(f2.getName()); // 12.docx

        // 获取当前文件的上级目录
        System.out.println(f.getParent()); // A:\TEXT
        System.out.println(f2.getParent()); // A:\TEXT

        // 判断当前目录下的东西是否是一个文件
        System.out.println(f.isFile()); // true
        System.out.println(f2.isFile()); // false

        // 判断当前目录下的东西是否是一个目录
        System.out.println(f.isDirectory()); // false
        System.out.println(f2.isDirectory()); // false

        // 判断当前文件是否隐藏
        System.out.println(f.isHidden()); // F
        System.out.println(f2.isHidden()); // F

        // 当前文件的大小
        System.out.println(f.length()); // 14246
        System.out.println(f2.length()); // 0

        // 当前文件是否存在
        System.out.println(f.exists()); // true
        System.out.println(f2.exists()); // false

        if (f2.exists()) {
            f2.delete();
        } else {
            f2.createNewFile();
        }

        // 比较两个对象的地址是否一致
        System.out.println(f == f1); // false -> 堆中的两个不同对象

        // 比较两个对象对应的路径
        System.out.println(f.equals(f1)); // true : 两个对象的路径是一样的。

        // 根路径相关的
        System.out.println("绝对路径: " + f.getAbsolutePath()); // 真实的一个精准的，完整的路径
        System.out.println("相对路径: " + f.getPath()); // 有一个参照物，相对这个参照物的路径。
        System.out.println("tostring: " + f.toString()); // tostring跟相对目录一致

        //
        File f5 = new File("demo.txt");
        File f6 = new File("a/b/c/demo.txt");
        if (!f5.exists()) {
            f5.createNewFile();
        }
        System.out.println("绝对路径: " + f6.getAbsolutePath());
        System.out.println("相对路径: " + f6.getPath());
        System.out.println("tostring: " + f6.toString());

    }
}
