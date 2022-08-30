package demo;

import java.util.Arrays;
/*
数组的拷贝
* **/
public class Test3 {

    //1：数组名.clone()
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] array2 = array.clone();
        System.out.println(Arrays.toString(array2));
    }

    //2：Arrays.copyOfRange()的局部拷贝
    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] array2 = Arrays.copyOfRange(array,2,5);//左闭右开
        System.out.println(Arrays.toString(array2));
    }

    //3：System.arraycopy() 的局部拷贝
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] array2 = new int[array.length * 2];
        System.arraycopy(array, 2 , array2, 0,array.length - 2);
        System.out.println(Arrays.toString(array2));
    }

   //4：手写的
    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }

    //5：copyof 全拷贝
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int n = 2;
        int[] array2 = Arrays.copyOf(array,n * array.length);
        //注意这里的n只能是整数不可以是小数，原码中数组长度的类型是int.
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array));
    }
}
