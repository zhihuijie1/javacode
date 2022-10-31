import javax.swing.plaf.basic.BasicArrowButton;

public class Sort {
    /**
     * 快速排序的优化
     * 挖坑发
     */
    public void quick(int[] array) {
        int begI = 0;
        int endI = array.length-1;
        QuickSort(array,begI,endI);
    }
    public void QuickSort(int[] array, int begI, int endI) {
        if(begI >= endI) {
            return;
        }
        int benchmark = partition2(array,begI,endI);
        QuickSort(array,begI,benchmark-1);
        QuickSort(array,benchmark+1,endI);
    }
    public int partition(int[] arr, int left,int right) {
        int pivot = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];

            while(left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
    /**
     * 快速排序的优化
     * 双指针法
     */
    public int partition2(int[] arr, int left,int right) {
        int cur = left+1;
        int prev = left;
        int priot = arr[left];//基准
        while(cur <= right) {
            if(arr[cur] < priot && prev != cur) {
                if(arr[prev] > priot) {
                    swap(arr,prev,cur);
                }else {
                    prev++;
                    swap(arr,prev,cur);
                }
            }
            cur++;
        }
        swap(arr,left,prev);
        return prev;
    }
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public int partition3(int[] arr, int left,int right) {
        int privot = arr[left];//基准
        int prev = left;
        int cur = left+1;
        for(; cur <= right; cur++) {
            if(arr[cur] < privot && ++prev != cur) {
                //++prev != cur  防止cur和prev相等时，相当于自己和自己交换，可以省略
                //交换
                swap(arr, cur, prev);
            }
        }
        swap(arr, prev, left);
        return prev;
    }

    /**
     * 快速排序的优化
     * 三数取中法，来进行快速排序
     */
    public void quickS(int[] array) {
        QuickSorts(array,0,array.length-1);
    }
    public void QuickSorts(int[] array, int begI, int endI) {
        if(begI >= endI) {
            return;
        }
        /**
         * 最坏的情况是排列一组有序的数据，时间复杂度是n^2,空间复杂度是n,
         * 我们采用三数取中法进行划分，这样可以使数据分布的更均匀。
         * 【1，2，3，4，5，6，7】--> 【4，2，3，1，5，6，7】--> 【1，2，3，4，5，6，7】
         *       初始数组                  优化后数组           找到基准是4，而不是1
         */
        int mid = findMidIndex(array,begI,endI);
        swap(array,mid,begI);
        int benchmark = partition4(array,begI,endI); //找基准
        QuickSort(array,begI,benchmark-1);
        QuickSort(array,benchmark+1,endI);
    }
    public int findMidIndex(int[] array,int begI,int endI) {
        int mid = (begI+endI)/2;
        if(array[endI] > array[begI]) {
            if(array[mid] < array[begI]) {
                return begI;
            }else if(array[mid] > array[endI]) {
                return endI;
            }else{
                return mid;
            }
        }else{
            if(array[mid] > array[endI]) {
                return endI;
            }else if(array[mid] < array[begI]) {
                return begI;
            }else {
                return mid;
            }
        }
    }
    public int partition4(int[] arr, int left,int right) {
        int cur = left+1;
        int prev = left;
        int priot = arr[left];//基准
        while(cur <= right) {
            if(arr[cur] < priot && prev != cur) {
                if(arr[prev] > priot) {
                    swap(arr,prev,cur);
                }else {
                    prev++;
                    swap(arr,prev,cur);
                }
            }
            cur++;
        }
        swap(arr,left,prev);
        return prev;
    }
}
