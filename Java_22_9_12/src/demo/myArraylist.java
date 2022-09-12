package demo;

import java.util.Arrays;

public class myArraylist {


    /*public static boolean func1(int tofind){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == tofind){
                return true;
            }
        }
        return false;

    }*/


    /*public static int func2 (int tofind){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == tofind){
                return i;
            }
        }
        return -1;
    }*/


    /*public static int func3 (int pos){
        if(pos < 0 || pos >= array.length){
            //抛异常
        }else{
            return array[pos];
        }
    }*/


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[] array2 = new int[2 * array.length];
        System.arraycopy(array,0,array2,0,array.length);
        array = array2;
        System.out.println(Arrays.toString(array));
    }

}
