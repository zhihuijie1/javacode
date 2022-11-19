import java.util.Arrays;

public class demo1 {
    /**
     * 自写对数器
     */
    public static void DuiShuQi() {
        int testTime = 5000;
        int maxSize = 100;//数组最大长度
        int maxValue = 100;//生成的最大数值
        for(int i = 0; i < testTime; i++) {
            int[] arr1 = shenChen(maxSize,maxValue);
            int[] arr2 = copyOf(arr1);
            /**
             * 测试
             */

            if(!isEquals(arr1,arr2)) {
                /**
                 * 把错误给打印出来
                 */
                System.out.println("error");
                System.out.println(Arrays.toString(arr1));
                System.out.println();
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println("true");
    }

    public static int[] shenChen(int maxSize,int maxValue) {
        int[] num = new int[(int)(Math.random()*(maxSize+1))];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int)(Math.random()*(maxValue+1))-(int)(Math.random()*(maxValue+1));
        }
        return num;
    }
    public static int[] copyOf(int[] arr1) {
        if(arr1 == null) {
            return null;
        }
        int[] arr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        return arr;
    }
    public static boolean isEquals(int[] arr1,int[] arr2) {
        if(arr1 == null && arr2 == null) {
            return true;
        }
        if(arr1 == null || arr2 == null) {
            return false;
        }
        if(arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
