import java.util.Stack;

/**
 * 快速排序递归的完整优化版
 */
public class QuickSort {
    public void quick(int[] array) {
        quickSort(array,0,array.length-1);
    }
    public void QuickSort(int[] array, int begI, int endI) {
        if(begI >= endI) {
            return;
        }
        if(endI-begI+1 <= 10) {
            insertSort(array,begI,endI);
            return;
        }
        int mid = findMidIndex(array,begI,endI);
        swap(array,mid,begI);
        int benchmark = partition4(array,begI,endI); //找基准
        QuickSort(array,begI,benchmark-1);
        QuickSort(array,benchmark+1,endI);
    }
    public void insertSort(int[] array, int left, int right) {
        for(int i = left+1; i<= right; i++) {
            int temp = array[i];
            int j = i-1;
            while(j >= left) {
                if(array[j] > temp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
                j--;
            }
            array[j+1] = temp;
        }
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
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 快速排序的非递归实现
     */
    public void quickSort(int[] array, int begI,int endI) {
        Stack<Integer> stack = new Stack<>();
        int piovt =  partition4(array,begI,endI);//找到基准下标
        // 1: 判断右面有没有多于两个元素
        //这个条件必须要有，否则就死循环（1个元素）或者越界（0个元素）。
        if(endI-1 > piovt) {
            stack.push(piovt+1);
            stack.push(endI);
        }
        //判断左边有没有多于两个元素
        if(begI+1 < piovt) {
            stack.push(begI);
            stack.push(piovt-1);
        }

        while(!stack.isEmpty()) {
            endI = stack.pop();
            begI = stack.pop();
            piovt =  partition4(array,begI,endI);//找到基准下标
            if(endI-1 > piovt) {
                stack.push(piovt+1);
                stack.push(endI);
            }
            if(begI+1 < piovt) {
                stack.push(begI);
                stack.push(piovt-1);
            }
        }
    }

}























