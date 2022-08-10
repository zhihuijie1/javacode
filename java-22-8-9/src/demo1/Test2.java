package demo1;

public class Test2 {
    //在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
    public static void main(String[] args) {
        Test3 test3 = new Test3(2,5);
        Test3 test31 = new Test3(1.2 , 2.5 ,36.6);
        System.out.println(test3.max1(2,5));
        System.out.println(test31.max2(1.2 , 2.5 ,36.6));
    }
}
