import java.util.Arrays;

public class Duishuqi {
    public static void slectSort(int[] array) {
        if(array == null || array.length == 1) {
            return;
        }
        // 0~1
        // 0~2
        // 0~3
        // 0~i
        // 0~n
        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            while(j >= 0 && array[j+1] < array[j]) {
                swap(array,j,j+1);
                j--;
            }
        }
    }
    public static void swap(int[]array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTime = 500000; //测试次数
        int maxSize = 100; //随机数组的长度：[0~100]
        int maxValue = 100; //产生的数的大小范围是[-100,100]
        Boolean succeed = true;
        //产生testTime个随机数组进行测试，每次都利用这些随机数组有进行比对
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);//产生长度也随机，数值也随机的数组
            int[] arr2 = copyArray(arr1);
            // 利用arr1来测试方法一
            slectSort(arr1);
            // 利用arr2来测试方法二
            comparator(arr2);
            //测试一下两个方法操作后的结果
            if(!isEqual(arr1,arr2)) {
                succeed = false;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        /**
         * Math.random() : 等概率产生[0,1)之间的小数
         * Math.random()*N : 等概率产生[0,N)之间的小数
         * (int)Math.random()*(N+1) : 等概率产生[0,N]之间的整数
         */
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        //保证随机产生的数组的长度在[0,maxSize]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            //[0,100] - [0,100) : 范围是(-100,100]，这样产生的随机数就有正有负，而且范围在 (-100,100]
            //当然这个地方你可以随便写
        }
        return arr;
    }
}
