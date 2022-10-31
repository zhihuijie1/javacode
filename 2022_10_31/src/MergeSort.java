import java.util.Stack;

/**
 * 归并排序
 * 递归写法
 */

public class MergeSort {
    public void mergeSort(int[] array) {
        mergeS(array,0,array.length-1);
    }
    public void mergeS(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left+right)/2;
        mergeS(array,left,mid);
        mergeS(array,mid+1,right);
        //合并
        combine(array,left,right,mid);
    }
    //合并函数
    public void combine(int[] array,int left ,int right, int mid) {
        //将两个有序数组合并为一个有序数组
        int sl = left;
        int el = mid;
        int sr = mid+1;
        int er = right;

        int[] arr = new int[right-left+1];
        int k =0;

        while(sl <= el && sr <= er) {
            if(array[sl] < array[sr]) {
                arr[k] = array[sl];
                k++;
                sl++;
            }else{
                arr[k] = array[sr];
                k++;
                sr++;
            }
        }
        while(sl <= el) {
            arr[k] = array[sl];
            sl++;
            k++;
        }
        while(sr <= er) {
            arr[k] = array[sr];
            sr++;
            k++;
        }
        for(int j = 0; j < k; j++) {
            array[j+left] = arr[j];
        }
    }

    /**
     * 非递归的归并实现
     * @param array
     */
    public void mergeSor(int[] array) {
        int gap = 1;
        while(gap < array.length) {
            for(int i = 0; i< array.length; i = i+gap*2) {
                int left = i;
                int mid = left+gap-1;
                int right = mid + gap;
                if(mid >= array.length) {
                    mid = array.length-1;
                }
                if(right >= array.length) {
                    right = array.length-1;
                }
                combine(array,left,right,mid);
            }
            gap = gap*2;
        }
    }

}
