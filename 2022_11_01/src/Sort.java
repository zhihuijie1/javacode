/**
 * 计数排序
 */
public class Sort {
    public void JiShuSort(int[] array) {
        //1：遍历数组找到最大值与最小值
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > maxVal) {
                maxVal = array[i];
            }
            if(array[i] < minVal) {
                minVal = array[i];
            }
        }
        //2:确定数组的长度
        int len = maxVal-minVal+1;
        int[] arrayCount = new int[len];
        //3: 计数
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - minVal;
            arrayCount[index]++;
        }
        //4: 排序
        int size = 0;
        for(int i = 0; i < len; i++) {
            while(arrayCount[i] != 0) {
                array[size] = i + minVal;
                size++;
                arrayCount[i]--;
            }
        }
    }
    /**
     * 直接插入排序
     */
    public void insertSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int j = i-1;
            int temp = array[i];
            while(j >= 0) {
                if(array[j] > temp) {
                    array[j+1] = array[j];
                    j--;
                }else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

}
