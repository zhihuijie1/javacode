public class demo2 {
    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
     */
    public static void TimesNum(int[] arr) {
        int err = arr[0];
        for (int i = 1; i < arr.length; i++) {
            err = err ^ arr[i]; // 最后相当于 err = a ^ b
        }
        //寻找err最右边第一个1的位置
        int index = err & (~err+1);
        //之所以会出现1，说明a 与 b在这个位置不一样，出现了差异化，
        // 根据差异化将数组分成两组，一组有a,另一组有b
        int err2 = 0;
        int i = 0;
        while((arr[i] & index) != 0) {
            err2 = err2 ^ arr[i];
            i++;
        }
        System.out.println(err2 + " " + (err2 ^ err));
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,1,1,2,2,3,3,4,5,5,6,6};
        TimesNum(array);
    }
}
