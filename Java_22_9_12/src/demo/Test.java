package demo;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,3,7,8,9,10};
        int size = array.length;
        size = remove(array,3,size);

    }
    /**
     * 1:如果链表是空的，那么就不可以删除
     * 2：找到ret 找到其下标
     * 3:删除，后面数据前移
     * 4：size--
     * */
    public static int remove(int[] array,int ret,int size){
        if(size == 0){
            System.out.println("链表是空的");
            return 0;
        }
        for (int i = 0; i < size; i++) {
            if(array[i] == ret){
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size --;
                return size;
            }
        }
        return -1;
    }
}










