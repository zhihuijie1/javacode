import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = new int[]{6,7,1,2,5,3,9,8};
        //sort.quickS(array);
        //System.out.println(Arrays.toString(array));
        //QuickSort quickSort = new QuickSort();
        //quickSort.quick(array);
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSor(array);
        System.out.println(Arrays.toString(array));

    }
}
