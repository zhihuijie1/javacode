import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MapSet {
    public static void func1(int[] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            //hashMap.put(array[i]);
        }

        Set<Map.Entry<Integer,Integer>> entrySet = hashMap.entrySet();


    }
    public static void main(String[] args) {
        //统计十万个数据中每个数据出现的次数
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50000);
        }
        func1(array);
    }
}
