package P1.package4;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        // File.separator:获取当前操作系统的拼接符。
        // File f = new File("A:" + File.separator + "TEXT" + File.separator + "11.docx");
        // File f1 = new File("A:" + File.separator + "TEXT" + File.separator + "11.docx");
        File f = new File("A:\\TEXT\\145");
        File f1 = new File("A:\\TEXT\\145");
        File f2 = new File("A:\\TEXT\\146"); // 随便写的一个目录
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


        // 比较两个对象的地址是否一致
        System.out.println(f == f1); // false -> 堆中的两个不同对象

        // 比较两个对象对应的路径
        System.out.println(f.equals(f1)); // true : 两个对象的路径是一样的。

        // 根路径相关的
        System.out.println("绝对路径: " + f.getAbsolutePath()); // 真实的一个精准的，完整的路径
        System.out.println("相对路径: " + f.getPath()); // 有一个参照物，相对这个参照物的路径。
        System.out.println("tostring: " + f.toString()); // tostring跟相对目录一致


        File f6 = new File("a/b/c/");
        System.out.println("绝对路径: " + f6.getAbsolutePath()); // 绝对路径: D:\java\javacode\src\MyJavaSE\a\b\c\demo.txt
        System.out.println("相对路径: " + f6.getPath()); // 相对路径: a\b\c\demo.txt
        System.out.println("tostring: " + f6.toString()); // tostring: a\b\c\demo.txt

        // 与目录有关的操作
        File file = new File("A:\\a\\b\\c");

        // 创建单层目录 -------------
        file.mkdir();

        // 创建多层目录
        file.mkdirs();

        // 目录的删除只会删除一层，并且这一层必须是空的才会被删除。
        //file.delete();

        // 当前目录下所有的文件和目录的名字放到String数组中。
        String[] str = file.list();
        System.out.println(Arrays.toString(str)); // [1.txt, 145.docx, 2]

        // 功能更加的强大：将当前目录下所有的文件和目录的放到File数组中。
        File[] files = file.listFiles();
        for (File F : files) {
            System.out.println(F.getName() + " ->  " + F.getAbsolutePath());
        }
        /*
        1.txt ->  A:\a\b\c\1.txt
        145.docx ->  A:\a\b\c\145.docx
        2 ->  A:\a\b\c\2`
         */
    }
}


