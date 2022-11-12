import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路：HashMap存放每个字母及其出现的次数，然后根据出现的次数建立一个小根堆
 * 采用TOP-K的方式来进行筛选，
 * 筛选的过程中如果出现的频率相同，那根据字母的先后顺序进行排序
 */
public class Clos {
    public void topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        //遍历一遍words数组，记录每个单词出现的次数。
        for (int i = 0; i < words.length; i++) {
            if(hashMap.containsKey(words[i])) {
                int value = hashMap.get(words[i]) + 1;
                hashMap.put(words[i],value);
            }else {
                hashMap.put(words[i],1);
            }
        }
        //建立一个键值数组
        Map.Entry<String,Integer>[] arr = new Map.Entry[hashMap.size()];
        int i = 0;
        for (Map.Entry<String,Integer> val : hashMap.entrySet()) {
            arr[i] = val;
            i++;
        }
        //使用向上调整的方法实现小根堆
        shiftUp(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //向上调整
    public void shiftUp(Map.Entry<String,Integer>[] elem,int child) {
        int parent = (child-1)/2;
        while(child > 0) {
            //建立小根堆
            if(elem[child].getValue() < elem[parent].getValue()) {
                // 交换
                Map.Entry<String,Integer> temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                child = parent;
                parent = (child-1)/2;
            }else if(elem[child].getValue() == elem[parent].getValue()) {
                if(elem[child].getKey().charAt(0) > elem[parent].getKey().charAt(0)) {
                    Map.Entry<String,Integer> temp = elem[child];
                    elem[child] = elem[parent];
                    elem[parent] = temp;
                    child = parent;
                    parent = (child-1)/2;
                }
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Clos clos = new Clos();
        String[] array = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        clos.topKFrequent(array,3);
    }
}
