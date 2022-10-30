import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = new int[]{200,0,8,6,4,1,10};
        int[] array2 = new int[]{2};
        //sort.shellSort(array);
        //sort.slectSort2(array);
        //sort.heapSort(array);
        //sort.bubbleSort(array);
        sort.quick(array);
        System.out.println(Arrays.toString(array));
    }
}
