public class BSExist {
    /**
     * 在一个有序数组中，找某个数是否存在
     */
    public static boolean exist(int[] sortedArr, int num) {
        if(sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length-1;
        int mid = -1;
        while(L <= R) {
            mid = L +((R - L) >> 1);
            if(sortedArr[mid] > num) {
                R = mid - 1;
            }else if(sortedArr[mid] < num) {
                L = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        System.out.println(exist(array,6));
    }
}
