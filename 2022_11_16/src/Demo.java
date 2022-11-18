import java.util.Arrays;

public class Demo {

    public static void print(int num) {
        for(int i = 31 ;i >= 0; i--) {
            System.out.print((num & (1 << i)));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,4,5,1,2};
        slectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     */
    public static void slectSort(int[] array) {
        if(array == null || array.length == 1) {
            return;
        }
        // 0~1
        // 0~2
        // 0~3
        // 0~i
        // 0~n
        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            while(j >= 0 && array[j+1] < array[j]) {
                swap(array,j,j+1);
                j--;
            }
        }
    }
    public static void swap(int[]array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
