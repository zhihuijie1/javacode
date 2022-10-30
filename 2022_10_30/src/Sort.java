import java.util.Queue;

public class Sort {
    /**
     * 希尔排序
     * 假设有10个元素，刚开始分为5组，一组2个元素，每个元素之间相隔5个元素
     * 假设有n个元素，刚开始分为gap组，一组 n/gap 个元素，每个元素之间相隔 gap 个元素
     */
    public void shellSort(int[] array) {
        int gap = array.length; //有gap组

        while(gap > 1) {
            //这两句的先后顺序比较重要，影响着gap == 1时会不会进行shell排序
            gap = gap / 2;
            shell(array,gap);
        }
    }

    public void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j = i-gap;
            for(; j >= 0;j -= gap) {
                if(array[j] > temp) {
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }
    /**
     * 选择排序
     * [2,1,5,5,9,8.8]
     * [1,2,5,5,9,5,8,8]
     * [1,2,5,5,9,8.8]
     */
    public void slectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i+1;
            int min = i;
            for(; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    /**
     * 拓展
     * 选择排序的第二种做法
     */
    public void slectSort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int min = left;
            int max = left;
            //找最大的与最小的
            for (int j = left+1; j <= right; j++) {
                //如果一个数即使最大的又是最小的，那么要么就是这组数都是一样的，要么就剩一个数了
                if(array[j] > array[max]) {
                    max = j;
                }
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array,min,left);
            if(max == left) {
                max = min;
            }
            swap(array,max,right);
            left++;
            right--;
        }
    }
    //交换函数
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 堆排序
     */
    public void heapSort(int[] array) {
        //建一个大根堆
        createHeap(array);
        //交换
        int end = array.length-1;
        while(end > 0) {
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    public static void createHeap(int[] array) {
        int end = array.length;
        int child = array.length-1;
        int parent = (child-1)/2;
        while(parent >= 0) {
            shiftDown(array,parent,end);
            parent--;
        }
    }
    public static void shiftDown(int[]array,int parent,int end) {
        int child = parent*2+1;
        while(child < end) {
            if(child+1 < end && array[child+1] > array[child]) {
                child = child+1;
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = parent*2+1;
        }
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] array) {
        //最外层是趟数
        for(int i = 0; i < array.length - 1; i++) {
            boolean flg = false;
            for(int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    flg = true;
                    swap(array,j,j+1);
                }
            }
            if(flg == false) {
                break;
            }
        }
    }
    /**
     * 快速排序
     * Hoare版
     */

    public void quick(int[] array) {
        int begI = 0;
        int endI = array.length-1;
        QuickSort(array,begI,endI);
    }
    public void QuickSort(int[] array, int begI, int endI) {
        //能不能不写>号，预防 1 2 3 4 5, 直接没有左树，或右树，
        if(begI >= endI) {
            return;
        }
        int benchmark = partition(array,begI,endI);
        QuickSort(array,begI,benchmark-1);
        QuickSort(array,benchmark+1,endI);
    }
    public int partition(int[] array,int left,int right) {
        int temp = array[left];
        int index = left;
        while(left < right) {
            //left < right &&这个条件不能少，预防后面的right都大于left，数组越界
            while (left < right && array[right] >= temp) {  //注意这里的等于号
                right--;
            }
            //right下标的值小于temp
            while(left < right && array[left] <= temp) {
                left++;
            }
            //left下标的值大于temp
            //交换
            swap(array,left,right);
        }
        //交换和原来的left
        swap(array,index,left);
        return left;
    }
}







