package demo;

import java.util.Arrays;

public class Test6 {
    /*
    手写tostring()函数 1
    * **/

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //tostring(array);//方法一
        System.out.println(tostring2(array));//方法二
    }
    //方法一
    public static void tostring(int[] array){
        if(array == null){
            System.out.println("null");
        }else{
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if(i != array.length-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
        }
    }

    //方法二
    public static String tostring2 (int[] array){
        if(array == null){
            return "null";
        }else{
            String ret = "[";
            for (int i = 0; i < array.length; i++) {
                ret = ret+ array[i];
                if(i != array.length-1){
                    ret = ret + ",";
                }
            }
            return ret + "]";
        }
    }
}
