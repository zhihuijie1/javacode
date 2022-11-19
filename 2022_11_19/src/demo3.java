import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class demo3 {
     /**
     * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
     */
    public static int find(int[] array) {
        int err = array[0];
        for (int i = 1; i < array.length; i++) {
            err ^= array[i];
        }
        return err;
    }

    public static int find2(int[] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(hashMap.containsKey(array[i])) {
                hashMap.put(array[i],hashMap.get(array[i])+1);
            }else{
                hashMap.put(array[i],1);
            }
        }
        for (int nub : hashMap.keySet()) {
            if(hashMap.get(nub) % 2 != 0) {
                return nub;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int maxLen = 30; //数组中元素的种数
        int maxValue = 100; //随机产生的数的最大取值【-100，100】
        int testTime = 10000;
        for(int i = 0;i < testTime; i++) {
            int[] arr = randomArray(maxLen,maxValue);
            //System.out.println(Arrays.toString(arr));
            //System.out.println();
            int[] arr2 = arrayCopy(arr);
            int nub1 = find(arr);
            int nub2 = find(arr2);
            if(nub1 != nub2) {
                System.out.println("false");
                break;
            }
        }
        System.out.println("true");
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>();
        //真命天子
        int k = (int)(Math.random()*(maxValue+1)); //[0,maxValue]
        int kSize = (int)(Math.random()*(maxValue+1)); // 真命天子出现了多少次 [0,100]之间的奇数次
        while(kSize % 2 == 0) {
            kSize = (int)(Math.random()*(maxValue+1));
        }
        for (int i = 0; i < kSize; i++) {
            list.add(k);
        }
        maxLen--;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(k);
        while(maxLen != 0) {
            int v = (int)(Math.random()*(maxValue+1)); //[0,maxValue]
            if(hashSet.contains(v)) {
                v = (int)(Math.random()*(maxValue+1));
            }
            hashSet.add(v);
            int Size = (int)(Math.random()*(maxValue+1))+1; // 其他数出现了多少次 [0,100]之间的奇数次
            while(Size % 2 != 0) {
                Size = (int)(Math.random()*(maxValue+1));
            }
            while(Size > 0) {
                list.add(v);
                Size--;
            }
            maxLen--;
        }
        int[] arr = new int[list.size()];
        Integer[] array = list.toArray(new Integer[list.size()]);

        for (int i = 0; i < array.length; i++) {
            int j = (int)(Math.random()*(array.length));
            swap(array,i, j);
        }
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }
    public static void swap(Integer[] array,int i,int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] arrayCopy(int[] arr) {
        if(arr == null) {
            return null;
        }
        int[] array = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }
}
