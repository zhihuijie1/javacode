import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class HashMap_HashSet {
     //统计每个数字出现的次数
     private int statistics(int[] array,int key) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            //判断一下hashMap中有没有这个元素，有的话value+1，放进去，没有的话直接放进去，value==1
            if(hashMap.containsKey(array[i])) {
                int value = hashMap.get(array[i])+1;
                hashMap.put(array[i],value);
            }else {
                hashMap.put(array[i],1);
            }
        }
        return hashMap.get(key);
    }
    public static void main(String[] args) {
        HashMap_HashSet hashMap_hashSet = new HashMap_HashSet();
        int[] array = new int[]{1,1,1,1,1,3,3,3,6};
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        System.out.println(hashMap_hashSet.statistics(array, key));
    }
}
