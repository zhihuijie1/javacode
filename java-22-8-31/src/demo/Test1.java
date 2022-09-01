package demo;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    //不规则二维数组
    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] =new int[]{1,2,3,4,5,6};
        array[1] =new int[]{9,8,7};
        System.out.println(Arrays.deepToString(array));
    }

    public static void main5(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8,9,10}};
        System.out.println(array);
        System.out.println(Arrays.toString(array));
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(Arrays.toString(array[0]));
        System.out.println(Arrays.toString(array[1]));
        System.out.println(Arrays.deepToString(array));
    }
    /**
     * 二维数组的打印方式
     * */
    //方式一：
    public static void main4(String[] args) {
        int[][] array = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
            //一行打印完再打印下一行
        }


        //方式二：
        System.out.println(Arrays.deepToString(array));

        //方式三:
        for (int[] index : array) {
            System.out.println(Arrays.toString(index));
        }
    }



    /**
     * 二维数组的定义方式
     * */
    public static void main3(String[] args) {
        // 1:
        int[][] array = {{1,2,3},{4,5,6,7}};
        // 2:
        int[][] array1 = new int[][]{{1,2,3},{4,5,6,7}};
        // 3:
        int[][] array2 = new int[2][3];
    }


    ///**
    //     * 冒泡排序的优化
    //     * */
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System .in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0 ; i < n ; i++){
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length - 1; i++) { //比较的趟数
            int flg = -1;
            for (int j = 0; j < n-i-1 ; j++) { //比较的次数
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flg = 1;
                }
            }
            if(flg == -1){
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    /**
     * 冒泡排序
     * */
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System .in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0 ; i < n ; i++){
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length - 1; i++) { //比较的趟数
            for (int j = 0; j < n-i-1 ; j++) { //比较的次数
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
