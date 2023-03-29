package P1.package1;

public class Test {
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {

        //创建Phone类的对象：
        Phone p1 = new Phone("华为P40", 2035.98, 2020);
        Phone p2 = new Phone("华为P40", 2035.98, 2020);
        //比较两个对象：p1和p2对象：
        //==的作用：比较左右两侧的值是否想的，要么相等，返回true,要么不相等,返回false
        System.out.println(p1 == p2);//-->>>对于引用数据类型来说，比较的是地址值。--->一定返回的是false

        //Object类提供了一个方法 equals方法 ：作用：比较对象具体内容是否相等。
        boolean flag = p1.equals(p2);//点进源码发现：底层依旧比较的是==，比较的还是地址值。
        System.out.println(flag);
        Cat cat = new Cat();
        Boolean flag1 = p1.equals(cat);
        System.out.println(flag1);
        HuaWei huaWei = new HuaWei("华为P40", 2035.98, 2020);
        System.out.println(huaWei.equals(p1));
    }
}
