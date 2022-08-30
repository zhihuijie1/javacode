package demo;

public class Test1 {

    public static void main(String[] args) {

    }
    //数组初始化方式
    public static void main1(String[] args) {

       int[] array1 = {1,2,3,4,5};
       //整体初始化
        //int[] array2;
        //array2 = {1.2,3};  error

        //int[] array2;
        //array2 = new int[]{1,2,3};  right
        int[] array2 = new int[]{1,2,3,4,5};

        int[] array3 = new int[10];
        for (int x : array3) {
            System.out.print(x + " ");
        }
        //结果 ： 0 0 0 0 0 0 0 0 0 0
    }

}
