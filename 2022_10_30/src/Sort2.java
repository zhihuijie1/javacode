/**
 * 希尔排序
 * 假设有10个元素，刚开始分为5组，一组2个元素，每个元素之间相隔5个元素
 * 假设有n个元素，刚开始分为gap组，一组 n/gap 个元素，每个元素之间相隔 gap 个元素
 */
public class Sort2 {
    public void shellSort(int[] array) {
        int gap = array.length;

        while(gap>1) {
            gap = gap/2;
            shell(array, gap);
        }
    }

    public void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int j = i - gap;
            int temp = array[i];
            for(;j >= 0; j -= gap) {
                if(array[j] > temp) {
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }
}
