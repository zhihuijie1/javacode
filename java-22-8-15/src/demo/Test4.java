package demo;

import java.util.Arrays;
import java.util.Scanner;

//二分查找 字写有bug
public class Test4 {

    public static void main(String[] args) {
        int[] array = {10,2,54,13,78,95,100,12,4,5};
        Scanner scanner = new Scanner(System.in);

        int temp = 0;
        for(int i = 0 ; i < array.length ; i++){
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        while(scanner.hasNext()){
            int n =scanner.nextInt();
            int index = findInt(array,n);
            if(index >= 0){
                System.out.println("找到了下标是"+ index);
            }else{
                System.out.println("没找到");
            }
        }
    }

    public static int findInt(int[] array,int n){
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid = left+right / 2;
            if(array[mid] > n){
                right = mid -1;
            }else if(array[mid] < n){
                left = mid +1;
            }else{
                return mid;
            }
        }
        if(left > right)
            return -1;

        return left;
    }
}
