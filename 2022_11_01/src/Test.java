import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{3,2,2,1,6,7,8,4,90};
        Sort sort = new Sort();
        sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
