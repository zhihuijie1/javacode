package demo;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1,0};
        int[] array2 = {9,8,7,6,5,4,3,2,1,10};

        //Arrays.equals(array, array2)   返回值是Boolean类型
        System.out.println(Arrays.equals(array, array2));

        //Arrays.sort( )  默认是升序，降序要比较器
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));


        //Arrays.binarySearch(array, 7)  返回值是下标
        System.out.println(Arrays.binarySearch(array, 7));

        //Arrays.fill(array2,1,5,0);     数组的区间赋值   注意前闭后开
        Arrays.fill(array2,1,5,0);
        System.out.println(Arrays.toString(array2));

    }
}
